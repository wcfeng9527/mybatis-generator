package com.mybatis.generator.fix;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.generator.service.db.DBService;
import com.mybatis.generator.util.RetInfo;
/**
 * 将生成的代码进行一些修改为了不修改源代码
 * @author zhangpeng
 * 20170814
 */
@RestController
public class FixAndExportController {
	
	@Autowired
	private DBService dBService;
	
	@RequestMapping(value="/export")
	private ModelAndView exportPage(){
		return new ModelAndView("/exportCode");
	}
	
	@RequestMapping(value="/exportCode")
	@ResponseBody
	public RetInfo export(HttpServletRequest request,HttpServletResponse response){
		RetInfo retInfo = new RetInfo();
		String dbId = request.getParameter("dbId");
		String tableName = request.getParameter("tableName");
		String moduleName = request.getParameter("moduleName");
		String projectName = request.getParameter("projectName");
		String outPath = "d:\\genfile\\";
		try {
			this.Gen(dbId, tableName, outPath, moduleName,projectName);
		} catch (Exception e) {
			e.printStackTrace();
			retInfo.setResult(false);
		}
		return retInfo;		
	}
	
	/**
	 * 1、获取文件并下载到本地
	 * 2、解析html文件
	 * 3、替换无用标签
	 * 4、获取实体类名称
	 * 5、获取类信息并输出到文件
	 * @param fileUrl 远程文件路径
	 * @param outPath 项目文件输出路径
	 * @param fileName 远程下载到本地的文件名称
	 * @param moduleName 项目模块名称
	 * @throws Exception
	 */
	public void Gen(String dbId,String tableName,String outPath,String moduleName,String projectName) throws Exception{ 
		
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("dbid", dbId);
		paraMap.put("tbName", tableName);
		List<String> codeList = dBService.codeList(paraMap);
			
		
		File file = new File(outPath);
		File[] fileArr = file.listFiles();
		if(fileArr!=null && fileArr.length>0){
			for(File temp : fileArr){				
				temp.delete();				
			}
		}		

		String classRegEx="public class (.*?) \\{";			
		//获取实体类名称
		String entityName = getFileName(codeList.get(0),classRegEx);
		FixAndExportController.outPutFile(outPath+entityName+".java",getEntity(codeList.get(0),moduleName,projectName));
		FixAndExportController.outPutFile(outPath+"I"+entityName+"Dao.java",getDao(codeList.get(1),entityName,moduleName,projectName));
		FixAndExportController.outPutFile(outPath+entityName+"Mapper.xml",getXML(codeList.get(2),entityName,moduleName,projectName));
		FixAndExportController.outPutFile(outPath+"I"+entityName+"Service.java",getService(codeList.get(3),entityName,moduleName,projectName));
		FixAndExportController.outPutFile(outPath+"I"+entityName+"FeignService.java",getFeign(codeList.get(4),entityName,moduleName,projectName));
		FixAndExportController.outPutFile(outPath+entityName+"ServiceImpl.java",getImpl(codeList.get(5),entityName,moduleName,projectName));
		FixAndExportController.outPutFile(outPath+entityName+"Controller.java",getController(codeList.get(6),entityName,moduleName,projectName));
		
		 
	} 
	
	private static String getEntity(String body,String moduleName,String projectName){
		String entity = body.replace("--------以下为实体类型自动生成内容，类型为 class", "package com.hivescm."+projectName+".entity."+moduleName+";");
		String str = replaceWord(entity);
		return str;
	}
	
	/**
	 * 获取DAO接口
	 * @param body
	 * @param entityName
	 * @param moduleName
	 * @return
	 */
	private static String getDao(String body,String entityName,String moduleName,String projectName){
		
		StringBuffer sb = new StringBuffer();
		sb.append("package com.hivescm."+projectName+".dao."+moduleName+";\n");
		sb.append("import java.util.List;\n");
		sb.append("import java.util.Map;\n");
		sb.append("import com.fw.route.rule.FwScmRouteRule;\n");
		sb.append("import com.hivescm."+projectName+".entity."+moduleName+"."+entityName+";\n");
		sb.append("import com.mogujie.trade.db.DataSourceRouting;\n");
		sb.append("import com.mogujie.trade.tsharding.annotation.ShardingExtensionMethod;\n");
		sb.append("import com.mogujie.trade.tsharding.annotation.parameter.ShardingParam;\n");
		
		String dao = body.replace("--------以下为 数据读取接口自动生成内容，类型为 interface", "");
		String str = replaceWord(dao);
		sb.append(str);
		return sb.toString();
	}
	
	/**
	 * 获取Mapper配置文件
	 * @param body
	 * @param entityName
	 * @param moduleName
	 * @return
	 */
	private static String getXML(String body,String entityName,String moduleName,String projectName){
		String xml = body;
		xml = xml.replace("--------以下为 sql文件自动生成内容，类型为 .xml ", "");
		xml = xml.replace(" mapper name:"+entityName+"Mapper.xml", "");
		xml = xml.replace("对应的数据读取接口的全类型", "com.hivescm.scm.dao."+moduleName+".I"+entityName+"Dao");
		xml = xml.replace("对应的model路径", "com.hivescm."+projectName+".entity."+moduleName+"."+entityName);
		xml = xml.replace("parameterType= \""+entityName+"\"", "parameterType=\"com.hivescm."+projectName+".entity."+moduleName+"."+entityName+"\"");
		xml = xml.replace("resultType=\""+entityName+"\"", "resultType=\"com.hivescm."+projectName+".entity."+moduleName+"."+entityName+"\"");		
		String str = replaceWord(xml);		
		return str;
	}
	
	/**
	 * 获取Service接口类
	 * @param body
	 * @param entityName
	 * @param moduleName
	 * @return
	 */
	private static String getService(String body,String entityName,String moduleName,String projectName){
		StringBuffer sb = new StringBuffer();
		sb.append("package com.hivescm."+projectName+".intf."+moduleName+";\n");
		sb.append("import java.util.List;\n");
		sb.append("import java.util.Map;\n");
		sb.append("import com.hivescm."+projectName+".entity."+moduleName+"."+entityName+";\n");
		String service = body.replace("--------以下为 service接口自动生成内容，类型为 interface ", "");
		String str = replaceWord(service);
		sb.append(str);
		return sb.toString();
	}	
	
	/**
	 * 获取Feign接口类
	 * @param body
	 * @param entityName
	 * @param moduleName
	 * @return
	 */
	private static String getFeign(String body,String entityName,String moduleName,String projectName){
		StringBuffer sb = new StringBuffer();
		sb.append("package com.hivescm."+projectName+".service."+moduleName+";\n");
		sb.append("import java.util.List;\n");
		sb.append("import java.util.Map;\n");
		sb.append("import org.springframework.cloud.netflix.feign.FeignClient;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestBody;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestMethod;\n");
		sb.append("import com.hivescm."+projectName+".entity."+moduleName+"."+entityName+";\n");	
				
		String feign = body.replace("--------以下为 feignservice接口自动生成内容，类型为 interface", "");
		String str = replaceWord(feign);
		sb.append(str);
		return sb.toString();
	}
	
	/**
	 * 获取ServiceImpl实现类
	 * @param body
	 * @param entityName
	 * @param moduleName
	 * @return
	 */
	private static String getImpl(String body,String entityName,String moduleName,String projectName){
		StringBuffer sb = new StringBuffer();
		sb.append("package com.hivescm."+projectName+".impl."+moduleName+";\n");
		sb.append("import java.util.List;\n");
		sb.append("import java.util.Map;\n");

		sb.append("import org.apache.log4j.Logger;\n");
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.stereotype.Service;\n");
		
		sb.append("import com.hivescm."+projectName+".dao."+moduleName+".I"+entityName+"Dao;\n");
		sb.append("import com.hivescm."+projectName+".entity."+moduleName+"."+entityName+";\n");
		sb.append("import com.hivescm."+projectName+".intf."+moduleName+".I"+entityName+"Service;\n");
		
		
		String impl = body.replace("--------以下为 serviceImpl自动生成内容，类型为 Class ", "");
		String str = replaceWord(impl);
		sb.append(str);
		return sb.toString();
	}
	
	/**
	 * 获取controller代码
	 * @param body
	 * @param entityName
	 * @param moduleName
	 * @return
	 */
	private static String getController(String body,String entityName,String moduleName,String projectName){
		StringBuffer sb = new StringBuffer();
		sb.append("package com.hivescm."+projectName+".controller."+moduleName+";\n");
		sb.append("import java.util.HashMap;\n");
		sb.append("import java.util.List;\n");
		sb.append("import java.util.Map;\n");
		sb.append("import javax.servlet.http.HttpServletRequest;\n");
		sb.append("import javax.servlet.http.HttpServletResponse;\n");
		sb.append("import org.apache.log4j.Logger;\n");
		sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		sb.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
		sb.append("import org.springframework.web.bind.annotation.RestController;\n");
		sb.append("import com.hivescm."+projectName+".entity."+moduleName+"."+entityName+";\n");
		sb.append("import com.hivescm."+projectName+".intf."+moduleName+".I"+entityName+"Service;\n");		
		
		String controller = body.replace("--------以下为 Controller自动生成内容，类型为 Class ", "");
		String str = replaceWord(controller);
		sb.append(str);
		return sb.toString();
	}
	
	/**
	 * 根据正则表达式获取实体类名称
	 * @param soap
	 * @param rgex
	 * @return
	 */
	private static String getFileName(String soap,String rgex){  
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式  
        Matcher m = pattern.matcher(soap);  
        while(m.find()){  
            return m.group(1);  
        }  
        return "";  
    }  
	
	/**
	 * 生成文件到指定目录
	 * @param path
	 * @param content
	 * @return
	 * @throws Exception
	 */
	private static boolean outPutFile(String path,String content) throws Exception{		 
		 InputStream input = new ByteArrayInputStream(content.getBytes());
		
		DataOutputStream output = new DataOutputStream(new FileOutputStream(path));
		byte[] buffer = new byte[1024 * 8];
		int count = 0;
		while ((count = input.read(buffer)) > 0) {
			output.write(buffer, 0, count);
		}
		output.close();
		input.close();
		return true;
	}
	/**
	 * 读取远程文件写到本地目录
	 * @param strUrl
	 * @param outPath
	 * @return
	 * @throws IOException
	 */
	private static boolean getRemoteFile(String strUrl, String outPath) throws IOException {
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		DataInputStream input = new DataInputStream(conn.getInputStream());
		DataOutputStream output = new DataOutputStream(new FileOutputStream(outPath));
		byte[] buffer = new byte[1024 * 8];
		int count = 0;
		while ((count = input.read(buffer)) > 0) {
			output.write(buffer, 0, count);
		}
		output.close();
		input.close();
		return true;
	}
	
	public static String replaceWord(String body){
		String str = body.replaceAll("<br>", "\n").replaceAll("&nbsp;", " ").replaceAll("&lt;", "<");
		return str;
	}
}
