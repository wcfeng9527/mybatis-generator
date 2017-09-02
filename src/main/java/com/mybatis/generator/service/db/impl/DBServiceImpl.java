package com.mybatis.generator.service.db.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mybatis.generator.dao.DataBaseConfigMapper;
import com.mybatis.generator.dao.db.ColumnDao;
import com.mybatis.generator.dao.db.MyTableDao;
import com.mybatis.generator.model.DataBaseConfig;
import com.mybatis.generator.model.MyColumn;
import com.mybatis.generator.model.MyTable;
import com.mybatis.generator.service.db.DBService;
import com.mybatis.generator.service.db.DbListConfig;
import com.mybatis.generator.service.db.EntityInfoService;
import com.mybatis.generator.util.CBStringUtils;
import com.mybatis.generator.util.NumberUtil;
@Service
public class DBServiceImpl implements DBService {

	Logger log = Logger.getLogger(DBServiceImpl.class);
	
	@Autowired
	private MyTableDao myTableDao;
	@Autowired
	private ColumnDao columnDao;
	@Autowired
	private EntityInfoService entityInfoService;
	@Autowired
	private DbListConfig dbListConfig;
	@Autowired
	private DataBaseConfigMapper dataBaseConfigMapper;
	
	@Value("${dbxml.url}")
	private String dbxmlUrl;
	
	
	
	@Override
	public List<DataBaseConfig> getDataBaseList() {
		return dataBaseConfigMapper.selectDataBaseList();
	}
	
	
	/**
	 * 查询数据库下table list
	 */
	@Override
	public List<MyTable> tableList(String dbid) {
		DataBaseConfig dbEntity = getDbEntity(dbid);
		List<MyTable> tableList = myTableDao.tableList(dbEntity);
		
		return tableList;
	}
	
	public DataBaseConfig getDbEntity(String dbId)
	{
//		DbListConfigImpl dbConfig = new DbListConfigImpl();
		List<DataBaseConfig> list = getDataBaseList();
		if (list != null && list.size() > 0) {
			for (DataBaseConfig entity : list) {
				if (NumberUtil.getInt(dbId) ==  entity.getId())
					return entity;
			}
		}
		return null;
	}
	
	
	/**
	 * 查询table 代码
	 */
	@Override
	public List<String> codeList(Map<String, Object> paraMap) {
		String dbid = CBStringUtils.toString(paraMap.get("dbid")); 
		String tbName = CBStringUtils.toString(paraMap.get("tbName")); 
		DataBaseConfig dbEntity = getDbEntity(dbid);
		MyTable tb = myTableDao.loadByName(dbEntity, tbName);
		List<MyColumn> columns = columnDao.list(dbEntity, tbName);
		
		//实体model生成
		String codeEntity = entityInfoService.buildEntityInfo(tb, columns);
		String codeDao = null;
		if(dbEntity.getState()== 0){//不分库分表
			 codeDao = entityInfoService.buildIDaoInfo(tb);
		}else if(dbEntity.getState()== 1){//分库分表
			 codeDao = entityInfoService.buildIDaoInfoSpecial(tb,dbEntity,columns);
		}
		String codeMapper = entityInfoService.buildMapperInfo(tb, columns); 
		String codeService = entityInfoService.buildServiceInfo(tb);
		String codeFeignService = entityInfoService.buildFeignServiceInfo(tb);
		String codeServiceImpl = entityInfoService.buildServiceImplInfo(tb);
		String codeController = entityInfoService.buildControllerInfo(tb);
		
		
		
		List<String> codeList = new ArrayList<String>();
		codeList.add(codeEntity);
		codeList.add(codeDao);
		codeList.add(codeMapper);
		codeList.add(codeService);
		codeList.add(codeFeignService);
		codeList.add(codeServiceImpl);
		codeList.add(codeController);
		return codeList;
	}
	
	
	
	@Override
	public List<MyColumn> columnList(Map<String, Object> paraMap) {
		String dbid = CBStringUtils.toString(paraMap.get("dbid")); 
		String tbName = CBStringUtils.toString(paraMap.get("tbName")); 
		DataBaseConfig dbEntity = getDbEntity(dbid);
		List<MyColumn> columns = columnDao.list(dbEntity, tbName);
		
		return columns;
	}
	
	
	@Override
	public void addDBSubmit(DataBaseConfig dataBaseEntity) {
//		List<DataBaseConfig> dbList  = getDataBaseList();
//		int idInfo = 1;
//		if(dbList.size()>0){
//			DataBaseConfig dataBase = dbList.get(dbList.size()-1);
//			log.info("当前dbList中最后一个元素"+dataBase.toString());
//		    idInfo = NumberUtil.getInt(dataBase.getId())+1;
//		}
		
//		dataBaseEntity.setId(idInfo);
		
		String dbUrl = dataBaseEntity.getUrl();
		if(dbUrl.indexOf("jdbc:mysql://")<0){
			dbUrl = "jdbc:mysql://"+dbUrl;
		}
		if(dbUrl.indexOf("/information_schema")<0){
			dbUrl = dbUrl+"/information_schema";
		}
		dataBaseEntity.setUrl(dbUrl);
		
		
		try {
				dataBaseConfigMapper.insert(dataBaseEntity);
			} catch (Exception e) {
				log.error("添加数据库设置时发生异常：", e);
			}
		
		
		
//		log.info("获取到的xmlurl:"+dbxmlUrl);
		
//		XStream xStream = XStreamBuilder.getXmlFriendlyXStream(DataBaseEntity.class);
//		String strXml = xStream.toXML(dataBaseEntity);
//		log.info("转化出xml内容："+strXml);	
//		File directory = new File("");
//		String path = directory.getAbsolutePath()+dbxmlUrl;
		
//		String projectPath = this.getClass().getResource(dbxmlUrl).getPath();
//		String path = "../../../"+projectPath.substring(1, projectPath.length());
//		log.info("path路径："+path);
//		File file = new File(path);
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		try {
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document doc = builder.parse(file);
//			doc.setXmlStandalone(true);// 设置XML文件的声明standalone的值为yes并不予显示
////		     // 4.追加节点
//	        Node dblist =  doc.getElementsByTagName("dblist").item(0);// 得到第一个book节点
//	        Element db = doc.createElement("db");
//	       
//	        
//			Element id= doc.createElement("id");  
//			id.setTextContent(dataBaseEntity.getId());   
//			db.appendChild(id);
//			Element showname=doc.createElement("showname");     
//			showname.setTextContent(dataBaseEntity.getShowName());   
//			db.appendChild(showname);
//			Element url=doc.createElement("url");     
//			url.setTextContent(dataBaseEntity.getUrl());     
//			db.appendChild(url);
//			Element database=doc.createElement("database");     
//			database.setTextContent(dataBaseEntity.getDatabase());  
//			db.appendChild(database);
//			Element username=doc.createElement("username");     
//			username.setTextContent(dataBaseEntity.getUsername());
//			db.appendChild(username);
//			Element password=doc.createElement("password");     
//			password.setTextContent(dataBaseEntity.getPassword());   
//			db.appendChild(password);
//			dblist.appendChild(db);
			
			
			 // 5.创建一个TransformerFactory对象
//	        TransformerFactory tff = TransformerFactory.newInstance();
	        // 6.通过TransformerFactory对象创建一个Transformer对象
//	        Transformer tf = tff.newTransformer();
	 
	        // 7.利用Transformer对象的transform方法指定输出流
//	        tf.setOutputProperty(OutputKeys.INDENT, "yes");// 设置缩进、换行
//	        tf.transform(new DOMSource(doc), new StreamResult(new File(dbxmlUrl)));
//	        log.info("写入dbInfo完成！！！");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
	
	
	
	
	public static void main(String[] args) {
//		ServletContext.getResourceAsStream(dbxmlUrl);
		
		
		
//		String request = request.getContextPath();
		
//		System.out.println(str2);
		
	}
}
