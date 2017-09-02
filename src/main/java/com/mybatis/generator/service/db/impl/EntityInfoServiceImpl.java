package com.mybatis.generator.service.db.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybatis.generator.model.DataBaseConfig;
import com.mybatis.generator.model.MyColumn;
import com.mybatis.generator.model.MyTable;
import com.mybatis.generator.service.db.EntityInfoService;
import com.mybatis.generator.util.CBStringUtils;
import com.mybatis.generator.util.DateUtil;
@Service
public class EntityInfoServiceImpl implements EntityInfoService {

	String space="&nbsp;";
	String tab= "&nbsp;&nbsp;&nbsp;&nbsp;";
	

	/**
	 * 以下为实体类型自动生成内容
	 */
	public String buildEntityInfo(MyTable tbInfo,List<MyColumn> columns)
	{
		
		StringBuilder sbEntity = new StringBuilder(1024);		
		sbEntity.append("--------以下为实体类型自动生成内容，类型为 class <br>");
		sbEntity.append("/**<br>");
		sbEntity.append(space+"* <br>");
		sbEntity.append("&nbsp;* author : "+System.getProperty("user.name")+"<br>");
		sbEntity.append(space+"* comments:").append(tbInfo.getTable_comment()).append("实体类型 <br>");
		sbEntity.append(space+"* create date:").append(DateUtil.toFullString(DateUtil.getCurrentDate())).append("<br>");
		sbEntity.append(space+"*/<br>");
		sbEntity.append("public class ").append(CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name())).append(" {").append("<br>");
		for(MyColumn cl :columns)
		{
			String javaType = CBStringUtils.convertDataTypeToJavaType(cl.getData_type());
			sbEntity.append(tab+"//").append(cl.getColumn_comment()).append("<br>");
			String columnName = CBStringUtils.getStrUnderlineUpper(cl.getColumn_name(), cl.getColumn_name());
			sbEntity.append(tab+"private ").append(javaType).append(" ").append(columnName).append(";	<br>");
		}
		sbEntity.append("<br>");
		sbEntity.append("<br>");
		for(MyColumn mycl :columns)
		{
			String columnNameUpper = CBStringUtils.getStrFirstCharAndUnderLineUpper(mycl.getColumn_name(),mycl.getColumn_name());//字符串首写字母大写且下划线后字母大写
			String columnName = CBStringUtils.getStrUnderlineUpper(mycl.getColumn_name(), mycl.getColumn_name());//字符串下划线后字母大写
			String javaType = CBStringUtils.convertDataTypeToJavaType(mycl.getData_type());
			sbEntity.append(tab+"/**<br>");
			sbEntity.append(tab+space+"* 获取").append(mycl.getColumn_comment()).append("的值 <br>");
			sbEntity.append(tab+space+"* @return :<br>");
			sbEntity.append(tab+space+"*/<br>");
			sbEntity.append(tab+"public ").append(javaType).append(" get").append(columnNameUpper).append("(){ <br>");
			sbEntity.append(tab+tab+"return ").append(columnName).append(";<br>");
			sbEntity.append(tab+"}<br>");
			sbEntity.append("<br>");
			
			sbEntity.append(tab+"/**<br>");
			sbEntity.append(tab+space+"* 设置").append(mycl.getColumn_comment()).append("的值 <br>");
			sbEntity.append(tab+space+"* @param  ").append(columnName).append("<br>");
			sbEntity.append(tab+space+"*/<br>");
			sbEntity.append(tab+"public void set").append(columnNameUpper).append("(").append(javaType)
						.append(" ").append(columnName).append("){ <br>");
			sbEntity.append(tab+tab+"this.").append(columnName).append(" = ").append(columnName).append(";<br>");
			sbEntity.append(tab+"}<br>");
			sbEntity.append("<br>");
		}
		sbEntity.append("}<br>");
		
		return sbEntity.toString();
	}
	
	
	
	
	@Override
	public String buildIDaoInfo(MyTable tbInfo) {
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name());//字符串首写字母大写且下划线后字母大写
		String classParam = CBStringUtils.getStrUnderlineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());//字符串下划线后字母大写
		String comment = tbInfo.getTable_comment();
		StringBuilder sbDao = new StringBuilder(1024);
		sbDao.append("<br>");
		sbDao.append("--------以下为 数据读取接口自动生成内容，类型为 interface  <br>");
		sbDao.append("/**<br>");
		sbDao.append("&nbsp;* author : "+System.getProperty("user.name")+"<br>");
		sbDao.append("&nbsp;* comments:").append(comment).append("数据读取接口 <br>");
		sbDao.append("&nbsp;* create date:").append(DateUtil.toFullString(DateUtil.getCurrentDate())).append("<br>");
		sbDao.append("&nbsp;*/<br>");
		sbDao.append("@Mapper"+"<br>");
		sbDao.append("public interface I").append(className).append("Dao {").append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 单条插入 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param user<br>");
		sbDao.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public int insert(").append(className).append(" ").append(classParam).append(");<br>");

		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 单条插入 ").append(comment).append(" 数据 生成主键id，赋值到实体<br>");
		sbDao.append(tab+space+"* @param user<br>");
		sbDao.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public int insertSetId(").append(className).append(" ").append(classParam).append(");<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 批量插入 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param "+classParam+"<br>");
		sbDao.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public int insertList(List&lt;").append(className).append("> ").append(classParam).append("s);<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 动态插入 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param "+classParam+"<br>");
		sbDao.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public int insertSelective(").append(className).append(" ").append(classParam).append(");<br>");
		sbDao.append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 单条更新 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param "+classParam+"<br>");
		sbDao.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public int update(").append(className).append(" ").append(classParam).append(");<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 批量更新 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param "+classParam+"<br>");
		sbDao.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public int updateList(List&lt;").append(className).append("> ").append(classParam).append("s);<br>");
		sbDao.append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 根据主键删除 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param id 主键id<br>");
		sbDao.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public int delete(int id);<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 根据查询条件删除 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param params 查询条件<br>");
		sbDao.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public int deleteByParam(Map&lt;String, Object> params);<br>");
		sbDao.append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 根据主键查询 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param id <br>");
		sbDao.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public ").append(className).append(" load(int id);<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 根据条件查询 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param params<br>");
		sbDao.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public ").append(className).append(" loadByParam(Map&lt;String, Object> params);<br>");
		sbDao.append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 不分页查询全部 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public List&lt;").append(className).append("> list();<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 不分页根据条件查询 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param params<br>");
		sbDao.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public List&lt;").append(className).append("> listByParam(Map&lt;String, Object> params);<br>");
		sbDao.append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 根据查询条件分页查询 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @return 查询到的列表数据 分页<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public List&lt;").append(className).append("> find(Map&lt;String, Object> params);<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 查询满足条件的 ").append(comment).append("数据的记录数<br>");
		sbDao.append(tab+space+"* @param params<br>");
		sbDao.append(tab+space+"* @return 满足条件的记录数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"public int  findCount(Map&lt;String, Object> params);<br>");
		sbDao.append("<br>");
		
		sbDao.append("}<br>");
		return sbDao.toString();
	}
	
	
	@Override
	public String buildIDaoInfoSpecial(MyTable tbInfo,DataBaseConfig dbEntity,List<MyColumn> columns) {
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name());//字符串首写字母大写且下划线后字母大写
		String classParam = CBStringUtils.getStrUnderlineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());//字符串下划线后字母大写
		String comment = tbInfo.getTable_comment();
		MyColumn myColumn = getPrimaryKeyColumn(columns);
	    String primaryKey = myColumn.getColumn_name();//主键
		StringBuilder sbDao = new StringBuilder(1024);
		sbDao.append("<br>");
		sbDao.append("--------以下为 数据读取接口自动生成内容，类型为 interface  <br>");
		sbDao.append("/**<br>");		
		sbDao.append("&nbsp;* author : "+System.getProperty("user.name")+"<br>");
		sbDao.append("&nbsp;* comments:").append(comment).append("数据读取接口 <br>");
		sbDao.append("&nbsp;* create date:").append(DateUtil.toFullString(DateUtil.getCurrentDate())).append("<br>");
		sbDao.append("&nbsp;*/<br>");
		sbDao.append("@DataSourceRouting(dataSource = \""+CBStringUtils.handlerNumbersInStr(dbEntity.getDatabaseName())+"\", table = \""+CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name())+"\", tables = 10, databases = 10, routeRule=FwScmRouteRule.class,isReadWriteSplitting = true)"+"<br>");
		sbDao.append("public interface I").append(className).append("Dao {").append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 单条插入 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param user<br>");
		sbDao.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public int insert(@ShardingParam(\""+primaryKey+"\") ").append(className).append(" ").append(classParam).append(");<br>");

		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 单条插入 ").append(comment).append(" 数据 生成主键id，赋值到实体<br>");
		sbDao.append(tab+space+"* @param user<br>");
		sbDao.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public int insertSetId(@ShardingParam(\""+primaryKey+"\") ").append(className).append(" ").append(classParam).append(");<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 批量插入 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param "+classParam+"<br>");
		sbDao.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public int insertList(@ShardingParam(\""+primaryKey+"\") List&lt;").append(className).append("> ").append(classParam).append("s);<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 动态插入 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param "+classParam+"<br>");
		sbDao.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public int insertSelective(@ShardingParam(\""+primaryKey+"\") ").append(className).append(" ").append(classParam).append(");<br>");
		sbDao.append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 单条更新 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param user<br>");
		sbDao.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public int update(@ShardingParam(\""+primaryKey+"\") ").append(className).append(" ").append(classParam).append(");<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 批量更新 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param "+classParam+"<br>");
		sbDao.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public int updateList(@ShardingParam(\""+primaryKey+"\") List&lt;").append(className).append("> ").append(classParam).append("s);<br>");
		sbDao.append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 根据主键删除 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param id 主键id<br>");
		sbDao.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public int delete(@ShardingParam(\""+primaryKey+"\") Long id);<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 根据查询条件删除 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param params 查询条件<br>");
		sbDao.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public int deleteByParam(@ShardingParam(\""+primaryKey+"\") Map&lt;String, Object> params);<br>");
		sbDao.append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 根据主键查询 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param id <br>");
		sbDao.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public ").append(className).append(" load(@ShardingParam(\""+primaryKey+"\") Long id);<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 根据条件查询 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param params<br>");
		sbDao.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public ").append(className).append(" loadByParam(@ShardingParam(\""+primaryKey+"\") Map&lt;String, Object> params);<br>");
		sbDao.append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 不分页查询全部 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public List&lt;").append(className).append("> list(@ShardingParam(\""+primaryKey+"\") Long id);<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 不分页根据条件查询 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @param params<br>");
		sbDao.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public List&lt;").append(className).append("> listByParam(@ShardingParam(\""+primaryKey+"\") Map&lt;String, Object> params);<br>");
		sbDao.append("<br>");
		
		sbDao.append("<br>");
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 根据查询条件分页查询 ").append(comment).append(" 数据<br>");
		sbDao.append(tab+space+"* @return 查询到的列表数据 分页<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public List&lt;").append(className).append("> find(@ShardingParam(\""+primaryKey+"\") Map&lt;String, Object> params);<br>");
		sbDao.append("<br>");
		
		sbDao.append(tab+"/**<br>");
		sbDao.append(tab+space+"* 查询满足条件的 ").append(comment).append("数据的记录数<br>");
		sbDao.append(tab+space+"* @param params<br>");
		sbDao.append(tab+space+"* @return 满足条件的记录数<br>");
		sbDao.append(tab+space+"*/<br>");
		sbDao.append(tab+"@ShardingExtensionMethod<br>");
		sbDao.append(tab+"public int  findCount(@ShardingParam(\""+primaryKey+"\") Map&lt;String, Object> params);<br>");
		sbDao.append("<br>");
		
		sbDao.append("}<br>");
		return sbDao.toString();
	}
	
	
	
	@Override
	public String buildServiceInfo(MyTable tbInfo) {
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name());//字符串首写字母大写且下划线后字母大写
		String classParam = CBStringUtils.getStrUnderlineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());//字符串下划线后字母大写
		String comment = tbInfo.getTable_comment();
		StringBuilder sbService = new StringBuilder(1024);
		sbService.append("<br>");
		sbService.append("--------以下为 service接口自动生成内容，类型为 interface  <br>");
		sbService.append("/**<br>");		
		sbService.append("&nbsp;* author : "+System.getProperty("user.name")+"<br>");
		sbService.append("&nbsp;* comments:").append(comment).append("service接口 <br>");
		sbService.append("&nbsp;* create date:").append(DateUtil.toFullString(DateUtil.getCurrentDate())).append("<br>");
		sbService.append("&nbsp;*/<br>");
		sbService.append("public interface I").append(className).append("Service {").append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param user<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public int insert(").append(className).append(" ").append(classParam).append(");<br>");

		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条插入 ").append(comment).append(" 数据 生成主键id，赋值到实体<br>");
		sbService.append(tab+space+"* @param user<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public int insertSetId(").append(className).append(" ").append(classParam).append(");<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 批量插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public int insertList(List&lt;").append(className).append("> ").append(classParam).append("s);<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 动态插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public int insertSelective(").append(className).append(" ").append(classParam).append(");<br>");
		sbService.append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条更新 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public int update(").append(className).append(" ").append(classParam).append(");<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 批量更新 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public int updateList(List&lt;").append(className).append("> ").append(classParam).append("s);<br>");
		sbService.append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据主键删除 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param id 主键id<br>");
		sbService.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public int delete(Long id);<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据查询条件删除 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params 查询条件<br>");
		sbService.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public int deleteByParam(Map&lt;String, Object> params);<br>");
		sbService.append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据主键查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param id <br>");
		sbService.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public ").append(className).append(" load(Long id);<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据条件查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public ").append(className).append(" loadByParam(Map&lt;String, Object> params);<br>");
		sbService.append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 不分页查询全部 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> list(Long Id);<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 不分页根据条件查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> listByParam(Map&lt;String, Object> params);<br>");
		sbService.append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据查询条件分页查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> find(Map&lt;String, Object> params);<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 查询满足条件的 ").append(comment).append("数据的记录数<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 满足条件的记录数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"public int  findCount(Map&lt;String, Object> params);<br>");
		sbService.append("<br>");
		
		sbService.append("}<br>");
		return sbService.toString();
	}
	
	
	@Override
	public String buildFeignServiceInfo(MyTable tbInfo) {
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name());//字符串首写字母大写且下划线后字母大写
		String classParam = CBStringUtils.getStrUnderlineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());//字符串下划线后字母大写
		String comment = tbInfo.getTable_comment();
		StringBuilder sbService = new StringBuilder(1024);
		sbService.append("<br>");
		sbService.append("--------以下为 feignservice接口自动生成内容，类型为 interface  <br>");
		sbService.append("/**<br>");
		sbService.append("&nbsp;* <br>");
		sbService.append("&nbsp;* author : "+System.getProperty("user.name")+"<br>");
		sbService.append("&nbsp;* comments:").append(comment).append("feignservice接口 <br>");
		sbService.append("&nbsp;* create date:").append(DateUtil.toFullString(DateUtil.getCurrentDate())).append("<br>");
		sbService.append("&nbsp;*/<br>");
		sbService.append("@FeignClient(value=\"服务名\")<br>");
		sbService.append("public interface I").append(className).append("FeignService {").append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param user<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/insert\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public int insert(@RequestBody ").append(className).append(" ").append(classParam).append(");<br>");

		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条插入 ").append(comment).append(" 数据 生成主键id，赋值到实体<br>");
		sbService.append(tab+space+"* @param user<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/insertSetId\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public int insertSetId(@RequestBody ").append(className).append(" ").append(classParam).append(");<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 批量插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/insertList\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public int insertList(@RequestBody List&lt;").append(className).append("> ").append(classParam).append("s);<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 动态插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/insertSelective\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public int insertSelective(@RequestBody ").append(className).append(" ").append(classParam).append(");<br>");
		sbService.append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条更新 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/update\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public int update(@RequestBody ").append(className).append(" ").append(classParam).append(");<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 批量更新 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/updateList\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public int updateList(@RequestBody List&lt;").append(className).append("> ").append(classParam).append("s);<br>");
		sbService.append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据主键删除 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param id 主键id<br>");
		sbService.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/delete\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public int delete(@RequestBody int id);<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据查询条件删除 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params 查询条件<br>");
		sbService.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/deleteByParam\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public int deleteByParam(@RequestBody Map&lt;String, Object> params);<br>");
		sbService.append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据主键查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param id <br>");
		sbService.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/load\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public ").append(className).append(" load(@RequestBody int id);<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据条件查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/loadByParam\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public ").append(className).append(" loadByParam(@RequestBody Map&lt;String, Object> params);<br>");
		sbService.append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 不分页查询全部 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/list\",method = RequestMethod.GET)<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> list();<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 不分页根据条件查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/listByParam\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> listByParam(@RequestBody Map&lt;String, Object> params);<br>");
		sbService.append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据查询条件分页查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/find\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> find(@RequestBody Map&lt;String, Object> params);<br>");
		sbService.append("<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 查询满足条件的 ").append(comment).append("数据的记录数<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 满足条件的记录数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/findCount\",method = RequestMethod.POST)<br>");
		sbService.append(tab+"public int  findCount(@RequestBody Map&lt;String, Object> params);<br>");
		sbService.append("<br>");
		
		sbService.append("}<br>");
		return sbService.toString();
	}
	
	
	
	@Override
	public String buildServiceImplInfo(MyTable tbInfo) {
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name());//字符串首写字母大写且下划线后字母大写
		String classParam = CBStringUtils.getStrUnderlineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());//字符串下划线后字母大写
		String comment = tbInfo.getTable_comment();
		StringBuilder sbService = new StringBuilder(1024);
		sbService.append("<br>");
		sbService.append("--------以下为 serviceImpl自动生成内容，类型为 Class  <br>");
		sbService.append("/**<br>");
		sbService.append("&nbsp;* author : "+System.getProperty("user.name")+"<br>");
		sbService.append("&nbsp;* comments:").append(comment).append("serviceImpl <br>");
		sbService.append("&nbsp;* create date:").append(DateUtil.toFullString(DateUtil.getCurrentDate())).append("<br>");
		sbService.append("&nbsp;*/<br>");
		sbService.append("@Service"+"<br>");
		sbService.append("public class ").append(className).append("ServiceImpl implements I"+className+"Service {").append("<br>");
		
		sbService.append(tab+"private static final Logger log = Logger.getLogger("+className+"ServiceImpl.class"+");").append("<br>");
		
		
		sbService.append("<br>");
		sbService.append(tab+"@Autowired<br>");
		sbService.append(tab+"private I"+className+"Dao i"+className+"Dao;<br><br><br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param user<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public int insert(").append(className).append(" ").append(classParam).append(") {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.insert("+classParam+");"+"<br>");
		sbService.append("<br>"+tab+"}<br>");

		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条插入 ").append(comment).append(" 数据 生成主键id，赋值到实体<br>");
		sbService.append(tab+space+"* @param user<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public int insertSetId(").append(className).append(" ").append(classParam).append(") {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.insertSetId("+classParam+");"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 批量插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public int insertList(List&lt;").append(className).append("> ").append(classParam).append("s) {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.insertList("+classParam+"s"+");"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 动态插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public int insertSelective(").append(className).append(" ").append(classParam).append(") {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.insertSelective("+classParam+");"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条更新 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public int update(").append(className).append(" ").append(classParam).append(") {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.update("+classParam+");"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 批量更新 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public int updateList(List&lt;").append(className).append("> ").append(classParam).append("s) {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.updateList("+classParam+"s"+");"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据主键删除 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param id 主键id<br>");
		sbService.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public int delete(Long id) {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.delete(id);"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据查询条件删除 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params 查询条件<br>");
		sbService.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public int deleteByParam(Map&lt;String, Object> params) {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.deleteByParam(params);"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据主键查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param id <br>");
		sbService.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public ").append(className).append(" load(Long id) {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.load(id);"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据条件查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public ").append(className).append(" loadByParam(Map&lt;String, Object> params) {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.loadByParam(params);"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 不分页查询全部 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> list(Long id) {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.list(id);"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 不分页根据条件查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> listByParam(Map&lt;String, Object> params) {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.listByParam(params);"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据查询条件分页查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> find(Map&lt;String, Object> params) {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.find(params);"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 查询满足条件的 ").append(comment).append("数据的记录数<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 满足条件的记录数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@Override<br>");
		sbService.append(tab+"public int findCount(Map&lt;String, Object> params) {<br>");
		sbService.append("<br>"+tab+tab+"return i"+className+"Dao.findCount(params);"+"<br>");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("}<br>");
		return sbService.toString();
	}
	
	
	
	@Override
	public String buildControllerInfo(MyTable tbInfo) {
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name());//字符串首写字母大写且下划线后字母大写
		String classParam = CBStringUtils.getStrUnderlineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());//字符串下划线后字母大写
		String comment = tbInfo.getTable_comment();
		StringBuilder sbService = new StringBuilder(1024);
		sbService.append("<br>");
		sbService.append("--------以下为 Controller自动生成内容，类型为 Class  <br>");
		sbService.append("/**<br>");
		sbService.append("&nbsp;* author : "+System.getProperty("user.name")+"<br>");
		sbService.append("&nbsp;* comments:").append(comment).append("Controller <br>");
		sbService.append("&nbsp;* create date:").append(DateUtil.toFullString(DateUtil.getCurrentDate())).append("<br>");
		sbService.append("&nbsp;*/<br>");
		sbService.append("@RestController"+"<br>@RequestMapping(value=\"/"+classParam+"\")<br>");
		sbService.append("public class ").append(className).append("Controller {").append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"private static final Logger log = Logger.getLogger("+className+"Controller.class"+");").append("<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"@Autowired<br>");
		sbService.append(tab+"private I"+className+"Service i"+className+"Service;<br><br><br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param user<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/insert\")<br>");
		sbService.append(tab+"public Map&lt;String,Object> insert(").append("HttpServletRequest request,HttpServletResponse response,").append(className).append(" "+classParam+") {<br>");
		sbService.append("<br>"+tab+tab+"i"+className+"Service.insert("+classParam+");"+"<br>");
		sbService.append(tab+tab+"Map&lt;String,Object> map = new HashMap&lt;>();<br>");
		sbService.append(tab+tab+"return map;");
		sbService.append("<br>"+tab+"}<br>");

		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条插入 ").append(comment).append(" 数据 生成主键id，赋值到实体<br>");
		sbService.append(tab+space+"* @param user<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/insertSetId\")<br>");
		sbService.append(tab+"public Map&lt;String,Object> insertSetId(").append("HttpServletRequest request,HttpServletResponse response,").append(className).append(" "+classParam+") {<br>");
		sbService.append("<br>"+tab+tab+"i"+className+"Service.insertSetId("+classParam+");"+"<br>");
		sbService.append(tab+tab+"Map&lt;String,Object> map = new HashMap&lt;>();<br>");
		sbService.append(tab+tab+"return map;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 批量插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/insertList\")<br>");
		sbService.append(tab+"public Map&lt;String,Object> insertList(HttpServletRequest request,HttpServletResponse response,List&lt;").append(className).append("> ").append(classParam).append("s) {<br>");
		sbService.append("<br>"+tab+tab+"i"+className+"Service.insertList("+classParam+"s"+");"+"<br>");
		sbService.append(tab+tab+"Map&lt;String,Object> map = new HashMap&lt;>();<br>");
		sbService.append(tab+tab+"return map;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 动态插入 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 插入数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/insertSelective\")<br>");
		sbService.append(tab+"public Map&lt;String,Object> insertSelective(HttpServletRequest request,HttpServletResponse response,").append(className).append(" ").append(classParam).append(") {<br>");
		sbService.append("<br>"+tab+tab+"i"+className+"Service.insertSelective("+classParam+");"+"<br>");
		sbService.append(tab+tab+"Map&lt;String,Object> map = new HashMap&lt;>();<br>");
		sbService.append(tab+tab+"return map;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 单条更新 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/update\")<br>");
		sbService.append(tab+"public Map&lt;String,Object> update(HttpServletRequest request,HttpServletResponse response,").append(className).append(" ").append(classParam).append(") {<br>");
		sbService.append("<br>"+tab+tab+"i"+className+"Service.update("+classParam+");"+"<br>");
		sbService.append(tab+tab+"Map&lt;String,Object> map = new HashMap&lt;>();<br>");
		sbService.append(tab+tab+"return map;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 批量更新 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param "+classParam+"<br>");
		sbService.append(tab+space+"* @return 更新数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/updateList\")<br>");
		sbService.append(tab+"public Map&lt;String,Object> updateList(HttpServletRequest request,HttpServletResponse response,List&lt;").append(className).append("> ").append(classParam).append("s) {<br>");
		sbService.append("<br>"+tab+tab+"i"+className+"Service.updateList("+classParam+"s"+");"+"<br>");
		sbService.append(tab+tab+"Map&lt;String,Object> map = new HashMap&lt;>();<br>");
		sbService.append(tab+tab+"return map;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据主键删除 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param id 主键id<br>");
		sbService.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/delete\")<br>");
		sbService.append(tab+"public Map&lt;String,Object> delete(Long id) {<br>");
		sbService.append("<br>"+tab+tab+"i"+className+"Service.delete(id);"+"<br>");
		sbService.append(tab+tab+"Map&lt;String,Object> map = new HashMap&lt;>();<br>");
		sbService.append(tab+tab+"return map;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据查询条件删除 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params 查询条件<br>");
		sbService.append(tab+space+"* @return 删除数据 影响行数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/deleteByParam\")<br>");
		sbService.append(tab+"public Map&lt;String,Object> deleteByParam(HttpServletRequest request,HttpServletResponse response) {<br>");
		sbService.append("<br>"+tab+tab+"Map&lt;String,Object> params = new HashMap&lt;>();<br>");
		sbService.append("<br>"+tab+tab+"i"+className+"Service.deleteByParam(params);"+"<br>");
		sbService.append(tab+tab+"Map&lt;String,Object> map = new HashMap&lt;>();<br>");
		sbService.append(tab+tab+"return map;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据主键查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param id <br>");
		sbService.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/load\")<br>");
		sbService.append(tab+"public ").append(className).append(" load(HttpServletRequest request,HttpServletResponse response) {<br>");
		sbService.append("<br>"+tab+tab+"Long id = 1L;"+"<br>");
		sbService.append("<br>"+tab+tab+""+className+" "+classParam+" = "+"i"+className+"Service.load(id);"+"<br>");
		sbService.append(tab+tab+"return "+classParam+";");
		sbService.append("<br>"+tab+"}<br>");
		
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据条件查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 查询到的").append(comment).append("数据<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/loadByParam\")<br>");
		sbService.append(tab+"public ").append(className).append(" loadByParam(HttpServletRequest request,HttpServletResponse response) {<br>");
		sbService.append("<br>"+tab+tab+"Map&lt;String,Object> params = new HashMap&lt;>();<br>");
		sbService.append("<br>"+tab+tab+""+className+" "+classParam+" = "+"i"+className+"Service.loadByParam(params);"+"<br>");
		sbService.append(tab+tab+"return "+classParam+";");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 不分页查询全部 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/list\")<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> list() {<br>");
		sbService.append(tab+tab+"Long id = 0L;");
		sbService.append("<br>"+tab+tab+"List&lt;"+className+"> "+classParam+"s = "+"i"+className+"Service.list(id);"+"<br>");
		sbService.append(tab+tab+"return "+classParam+"s;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 不分页根据条件查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 不分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/listByParam\")<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> listByParam(HttpServletRequest request,HttpServletResponse response) {<br>");
		sbService.append("<br>"+tab+tab+"Map&lt;String,Object> params = new HashMap&lt;>();<br>");
		sbService.append("<br>"+tab+tab+"List&lt;"+className+"> "+classParam+"s = "+"i"+className+"Service.listByParam(params);"+"<br>");
		sbService.append(tab+tab+"return "+classParam+"s;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("<br>");
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 根据查询条件分页查询 ").append(comment).append(" 数据<br>");
		sbService.append(tab+space+"* @return 查询到的列表数据 分页<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/find\")<br>");
		sbService.append(tab+"public List&lt;").append(className).append("> find(HttpServletRequest request,HttpServletResponse response) {<br>");
		sbService.append("<br>"+tab+tab+"Map&lt;String,Object> params = new HashMap&lt;>();<br>");
		sbService.append("<br>"+tab+tab+"List&lt;"+className+"> "+classParam+"s = "+"i"+className+"Service.find(params);"+"<br>");
		sbService.append(tab+tab+"return "+classParam+"s;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append(tab+"/**<br>");
		sbService.append(tab+space+"* 查询满足条件的 ").append(comment).append("数据的记录数<br>");
		sbService.append(tab+space+"* @param params<br>");
		sbService.append(tab+space+"* @return 满足条件的记录数<br>");
		sbService.append(tab+space+"*/<br>");
		sbService.append(tab+"@RequestMapping(value=\"/findCount\")<br>");
		sbService.append(tab+"public Map&lt;String,Object>  findCount(HttpServletRequest request,HttpServletResponse response) {<br>");
		sbService.append("<br>"+tab+tab+"Map&lt;String,Object> params = new HashMap&lt;>();<br>");
		sbService.append("<br>"+tab+tab+"int count = "+"i"+className+"Service.findCount(params);"+"<br>");
		sbService.append("<br>"+tab+tab+"Map&lt;String,Object> map = new HashMap&lt;>();<br>");
		sbService.append(tab+tab+"map.put(\"count\",count);<br>");
		sbService.append(tab+tab+"return map;");
		sbService.append("<br>"+tab+"}<br>");
		
		sbService.append("}<br>");
		return sbService.toString();
	}
	
	
	@Override
	public String buildMapperInfo(MyTable tbInfo, List<MyColumn> columns) {
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name());//字符串首写字母大写且下划线后字母大写
//		String classParam = CBStringUtils.getStrUnderlineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());//字符串下划线后字母大写
		
		
		StringBuilder sbMapper = new StringBuilder();
//		String className = CBStringUtils.convertFirstCharToUpper(tbInfo.getTable_name());
		//sbMapper.append("<br>");
		//sbMapper.append("--------以下为 sql文件自动生成内容，类型为 .xml  <br>");
		//sbMapper.append("mapper name:").append(className).append("Mapper.xml <br>");
		sbMapper.append("&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?> <br>");
		sbMapper.append("&lt;!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" <br>");		
		sbMapper.append("\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\"> <br>");
		sbMapper.append("<br>");
		sbMapper.append("&lt;mapper namespace=\"对应的数据读取接口的全类型\"> <br>");
		sbMapper.append(tab+"&lt;resultMap id=\"BaseResultMap\" type=\"对应的model路径\"> <br>");
		int i = 0;
		for(MyColumn mycl :columns){
			String jdbcType = CBStringUtils.convertDataTypeToMapperType(mycl.getData_type());
			String classParam = CBStringUtils.getStrUnderlineUpper(mycl.getColumn_name(), mycl.getColumn_name());//字符串下划线后字母大写
			if(i == 0){
				sbMapper.append(tab+tab+"&lt;id column=\""+mycl.getColumn_name()+"\" jdbcType=\""+jdbcType+"\" property=\""+classParam+"\" /> <br>");
				i++;
			}else{
				sbMapper.append(tab+tab+"&lt;result column=\""+mycl.getColumn_name()+"\" jdbcType=\""+jdbcType+"\" property=\""+classParam+"\" /> <br>");
			}
		}
		sbMapper.append(tab+"&lt;/resultMap> <br>");
		
		
		
		sbMapper.append(tab+"&lt;!-- 全部字段列表，供查询单个实体使用--> <br>");
		sbMapper.append(tab+"&lt;sql id=\"Base_Column_List\"> <br>");
		sbMapper.append(tab+tab+buildColumnSelect(columns,true) + "<br>");
		sbMapper.append(tab+"&lt;/sql><br><br>");
		
//		sbMapper.append(tab+"&lt;!-- 部分字段列表，供查询列表实体使用--> <br>");
//		sbMapper.append(tab+"&lt;sql id=\"briefColumn\"> <br>");
//		sbMapper.append(tab+tab+buildColumnSelect(columns,true) + "<br>");
//		sbMapper.append(tab+"&lt;/sql><br>");
//		sbMapper.append("<br>");
		
		//更新
		sbMapper.append(buildUpdate(tbInfo,columns));
		sbMapper.append("<br>");
		//批量更新
		sbMapper.append(buildUpdateBatch(tbInfo, columns));
		sbMapper.append("<br>");
		//添加 设置实体主键
		sbMapper.append(buildInsert(tbInfo, columns, true));
		sbMapper.append("<br>");
		//添加  不设置实体主键
		sbMapper.append(buildInsert(tbInfo, columns, false));
		sbMapper.append("<br>");
		//批量添加
		sbMapper.append(buildInsertList(tbInfo,columns));
		sbMapper.append("<br>");
		//动态添加
		sbMapper.append(buildInsertSelective(tbInfo,columns));
		
		
		//删除
		sbMapper.append(buildDelete(tbInfo, columns));
		sbMapper.append("<br>");
		//根据条件删除
		sbMapper.append(buildDeleteByParam(tbInfo, columns));
		sbMapper.append("<br>");
		
		//Select
		sbMapper.append(buildSelectList(tbInfo, columns));
		sbMapper.append("<br>");
		//Select by param
		sbMapper.append(buildSelectByParam(tbInfo, columns));
		sbMapper.append("<br>");
		
		//list
		sbMapper.append(buildList(tbInfo));
		sbMapper.append("<br>");
		//listbyparam
		sbMapper.append(buildListByParam(tbInfo, columns));
		sbMapper.append("<br>");
		
		//find
		sbMapper.append(buildFind(tbInfo, columns));
		sbMapper.append("<br>");
		
		//findcount
		sbMapper.append(buildFindCount(tbInfo, columns));
		sbMapper.append("<br>");
		
		sbMapper.append("&lt;/mapper>");
		return sbMapper.toString();
	}
	
	
	
	private Object buildInsertSelective(MyTable tbInfo, List<MyColumn> columns) {
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;insert id=\"insertSelective\" parameterType= \""+className+"\"> <br>");
		sbSql.append(tab+tab+"insert into "+CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name())+"<br>");
		sbSql.append(tab+tab+"&lt;trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" ><br>");
		for (MyColumn mycl : columns) {
			String columnName = mycl.getColumn_name();
			String columnNameUpper = CBStringUtils.getStrUnderlineUpper(columnName, columnName);
			sbSql.append(tab+tab+tab+"&lt;if test=\""+columnNameUpper + "!=null\"><br>"+tab+tab+tab+tab+columnName+",<br> "+tab+tab+tab+"&lt;/if> <br>");
		}
		sbSql.append(tab+tab+"&lt;/trim><br>");
		sbSql.append(tab+tab+"&lt;trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" ><br>");
		for (MyColumn mycl : columns) {
			String columnName = mycl.getColumn_name();
			String columnNameUpper = CBStringUtils.getStrUnderlineUpper(columnName, columnName);
			String javaType = CBStringUtils.convertDataTypeToMapperType(mycl.getData_type());
			sbSql.append(tab+tab+tab+"&lt;if test=\""+columnNameUpper + "!=null\"><br>"+tab+tab+tab+tab+"#{"+columnNameUpper+",jdbcType="+javaType+"},<br>"+tab+tab+tab+"&lt;/if> <br>");
		}
		sbSql.append(tab+tab+"&lt;/trim><br>");
		sbSql.append(tab+"&lt;/insert> <br><br>");
		
		return sbSql.toString();
	}


	/**
	 * 查询列
	 * @param columns
	 * @param containsKey
	 * @return
	 */
	private String buildColumnSelect(List<MyColumn> columns,Boolean containsKey)
	{
		StringBuilder sbSql = new StringBuilder();
		String primaryKey = "";
		if(!containsKey)
		{
			MyColumn myColumn = getPrimaryKeyColumn(columns);
			primaryKey = myColumn.getColumn_name();
		}
		boolean first = true;
		for(MyColumn mycl : columns)
		{
			if(!containsKey && mycl.getColumn_name().equalsIgnoreCase(primaryKey))
			{
				continue;
			}
			if(first) first =false;
			else sbSql.append(",");
			sbSql.append(mycl.getColumn_name());
		}		
		return sbSql.toString();
	}
	
	
	
	/**
	 * 更新sql语句
	 * @param tbInfo
	 * @param columns
	 * @return
	 */
	private String buildUpdate(MyTable tbInfo,List<MyColumn> columns)
	{
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name());//字符串首写字母大写且下划线后字母大写
//		String className = CBStringUtils.convertFirstCharToUpper(tbInfo.getTable_name());
	    MyColumn myColumn = getPrimaryKeyColumn(columns);
	    String primaryKey = myColumn.getColumn_name();
	    String primaryKeyJdbcType = CBStringUtils.convertDataTypeToMapperType(myColumn.getData_type());//主键数据类型
	    StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;update id=\"update\" parameterType= \""+className+"\"> <br>");
		sbSql.append(tab+tab+"update " + CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name()) + "<br>");
		sbSql.append(tab+tab+"&lt;set> <br>");
		int index = 1;
		for(MyColumn column : columns)
		{
			String columnUpper = CBStringUtils.getStrUnderlineUpper(column.getColumn_name(),column.getColumn_name());//字符串首写字母大写且下划线后字母大写
			String colName = column.getColumn_name();
			String jdbcType = CBStringUtils.convertDataTypeToMapperType(column.getData_type());
			if(colName == null || colName.equalsIgnoreCase(primaryKey)){
				index++;
				continue;
			}
			sbSql.append(tab+tab+tab+"&lt;if test=\"" + columnUpper + "!=null\"><br>"+tab+tab+tab+tab+colName +"=#{"+columnUpper+",jdbcType="+jdbcType+"}");
			if(index < columns.size())
				sbSql.append(",<br>"+tab+tab+tab+"&lt;/if> <br>");
			else {
				sbSql.append("<br>"+tab+tab+tab+"&lt;/if> <br>");
			}
			index++;
		}
		sbSql.append(tab+tab+"&lt;/set> <br>");
		String primaryKeyUpper = CBStringUtils.getStrUnderlineUpper(primaryKey,primaryKey);
		sbSql.append(tab+tab+"where " + primaryKey + " = #{" + primaryKeyUpper + ",jdbcType="+primaryKeyJdbcType+"} and	modified_time=#{modifiedTime,jdbcType=TIMESTAMP} <br>");
		sbSql.append(tab+"&lt;/update> <br>");
		
		return sbSql.toString();
	}
	
	/**
	 * 获取主键列
	 * @param columns
	 * @return
	 */
	private MyColumn getPrimaryKeyColumn(List<MyColumn> columns)
	{
//		String primaryKey = "";
		MyColumn myColumn = null;
		for(MyColumn column :columns)
		{
			if(column.getColumn_key().equalsIgnoreCase("PRI"))
			{
				myColumn = column;
				break;
			}
		}
		return myColumn;
	}
	
	
	/**
	 * 批量修改
	 * @param tbInfo
	 * @param columns
	 * @return
	 */
	private String buildUpdateBatch(MyTable tbInfo,List<MyColumn> columns)
	{
		MyColumn myColumn = getPrimaryKeyColumn(columns);
		String primaryKey = myColumn.getColumn_name();
		String primaryKeyJdbcType = CBStringUtils.convertDataTypeToMapperType(myColumn.getData_type());//主键数据类型
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;update id=\"updateList\" parameterType= \"List\"> <br>");
		sbSql.append(tab+tab+"&lt;foreach collection=\"list\" item=\"item\" index=\"index\" open=\"\" close=\"\" separator=\";\">	 <br>");
		sbSql.append(tab+tab+tab+"update " + CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name()) + "<br>");
		sbSql.append(tab+tab+tab+"&lt;set> <br>");
		
		int index = 1;
		for(MyColumn column : columns)
		{
			String colNameUpper = CBStringUtils.getStrUnderlineUpper(column.getColumn_name(), column.getColumn_name());
			String colName = column.getColumn_name();
			String jdbcType = CBStringUtils.convertDataTypeToMapperType(column.getData_type());
			if(colName == null || colName.equalsIgnoreCase(primaryKey)){
				index++;
				continue;
			}
			sbSql.append(tab+tab+tab+tab+"&lt;if test=\"item." + colNameUpper + "!=null\"><br>"+tab+tab+tab+tab+tab+colName +"=#{item."+colNameUpper+",jdbcType="+jdbcType+"}");
			if(index < columns.size())
				sbSql.append(",<br>"+tab+tab+tab+tab+"&lt;/if> <br>");
			else {
				sbSql.append("<br>"+tab+tab+tab+tab+"&lt;/if> <br>");
			}
			index++;
		}
		
		sbSql.append(tab+tab+tab+"&lt;/set> <br>");
		String primaryKeyUpper = CBStringUtils.getStrUnderlineUpper(primaryKey, primaryKey);
		sbSql.append(tab+tab+tab+"where " + primaryKey + " = #{item." + primaryKeyUpper + ",jdbcType="+primaryKeyJdbcType+"}	 <br>");
		sbSql.append(tab+tab+"&lt;/foreach> <br>");
		sbSql.append(tab+"&lt;/update> <br>");
		return sbSql.toString();
	}
	
	/**
	 * 增加
	 * @param tbInfo
	 * @param columns
	 * @param setId
	 * @return
	 */
	private String buildInsert(MyTable tbInfo,List<MyColumn> columns,boolean setId)
	{
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());
//		String className = CBStringUtils.convertFirstCharToUpper(tbInfo.getTable_name());
		MyColumn myColumn= getPrimaryKeyColumn(columns);
		String primaryKey = myColumn.getColumn_name();
		String primaryKeyUpper = CBStringUtils.getStrUnderlineUpper(primaryKey, primaryKey);
		StringBuilder sbSql = new StringBuilder();
		if(setId){
			sbSql.append(tab+"&lt;insert id=\"insertSetId\" parameterType= \""+className+"\" useGeneratedKeys=\"true\" keyProperty=\""+primaryKeyUpper +"\"> <br>");
		}
		else {
			sbSql.append(tab+"&lt;insert id=\"insert\" parameterType= \""+className+"\"> <br>");
		}
		
		sbSql.append(tab+tab+"insert into   <br>");
		sbSql.append(tab+tab+CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name()) + "(" + buildColumnSelect(columns, true) + ")  <br>");
		sbSql.append(tab+tab+"values( "+buildColumnInsertParam(columns,true,"") + ") <br>");
		
		sbSql.append(tab+"&lt;/insert> <br>");
		
		return sbSql.toString();
	}
	
	private String buildColumnInsertParam(List<MyColumn> columns,Boolean containsKey,String item)
	{
		StringBuilder sbSql = new StringBuilder();
		String primaryKey = "";
		if(!containsKey)
		{
			
			MyColumn myColumn = getPrimaryKeyColumn(columns);
			primaryKey = myColumn.getColumn_name();
		}
		
		boolean first = true;
		for(MyColumn mycl : columns)
		{
			if(!containsKey && mycl.getColumn_name().equalsIgnoreCase(primaryKey))
			{
				continue;
			}
			if(first) first =false;
			else sbSql.append(",");
			String columnNameUpper = CBStringUtils.getStrUnderlineUpper(item+mycl.getColumn_name(), item+mycl.getColumn_name());
			String jdbcType = CBStringUtils.convertDataTypeToMapperType(mycl.getData_type());
			sbSql.append("#{"+columnNameUpper+",jdbcType="+jdbcType+"}");
		}		
		return sbSql.toString();
	}
	
	private String buildInsertList(MyTable tbInfo,List<MyColumn> columns){
		StringBuilder sbSql = new StringBuilder();
		
		sbSql.append(tab+"&lt;insert id=\"insertList\" parameterType= \"List\"> <br>");
		sbSql.append(tab+tab+"insert into   <br>");
		sbSql.append(tab+tab+CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name()) + "(" + buildColumnSelect(columns, true) + ")  <br>");
		sbSql.append(tab+tab+"values <br>");
		sbSql.append(tab+tab+"&lt;foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\" > <br>");
		sbSql.append(tab+tab+tab+"(" + buildColumnInsertParam(columns,true,"item.") + ") <br>");
		sbSql.append(tab+tab+"&lt;/foreach> <br>");
		sbSql.append(tab+"&lt;/insert> <br>");
		return sbSql.toString();
	}
	
	
	private String buildDelete(MyTable tbInfo,List<MyColumn> columns)
	{
		MyColumn myColumn = getPrimaryKeyColumn(columns);
		String primaryKey = myColumn.getColumn_name();
		String primaryKeyJdbcType = CBStringUtils.convertDataTypeToMapperType(myColumn.getData_type());//主键数据类型
		String primaryKeyUpper = CBStringUtils.getStrUnderlineUpper(primaryKey, primaryKey);
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;delete id=\"delete\" parameterType= \"int\"> <br>");
		sbSql.append(tab+tab+"delete from " + CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name())  + " where " + primaryKey +  " = #{"+ primaryKeyUpper + ",jdbcType="+primaryKeyJdbcType+"}<br>");
		sbSql.append(tab+"&lt;/delete> <br>");
		
		return sbSql.toString();
	}
	
	private String buildDeleteByParam(MyTable tbInfo,List<MyColumn> columns)
	{
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;delete id=\"deleteByParam\" parameterType= \"java.util.Map\"> <br>");
		sbSql.append(tab+tab+"delete from " + CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name())  + "<br>");
		sbSql.append(tab+tab+"&lt;where> <br>");
		sbSql.append(tab+tab + "&lt;!-- 以下查询条件为模拟生成，请大家开发时进行修改--><br>");
		
		for(int i=1;i<4&&i<columns.size();i++)
		{
			String columnName = columns.get(i).getColumn_name();
			String columnNameUpper = CBStringUtils.getStrUnderlineUpper(columnName, columnName);
			String jdbcType = CBStringUtils.convertDataTypeToMapperType(columns.get(i).getData_type());
			sbSql.append(tab+tab+tab+"&lt;if test=\""+columnNameUpper + "!=null\"><br>"+tab+tab+tab+tab+"and "+columnName+"=#{"+columnNameUpper+",jdbcType="+jdbcType+"}<br> "+tab+tab+tab+"&lt;/if> <br>");
		}
		
		sbSql.append(tab+tab+"&lt;/where> <br>");
		sbSql.append(tab+"&lt;/delete><br>"); 
		return sbSql.toString();
	}
	
	private String buildSelectList(MyTable tbInfo,List<MyColumn> columns)
	{
		String tableName = CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name());
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());
		MyColumn myColumn = getPrimaryKeyColumn(columns);
		String primaryKey = myColumn.getColumn_name();
		String primaryKeyUpper = CBStringUtils.getStrUnderlineUpper(primaryKey, primaryKey);
		String primaryKeyJdbcType = CBStringUtils.convertDataTypeToMapperType(myColumn.getData_type());//主键数据类型
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;select id=\"load\" resultType=\""+className +"\" parameterType=\"int\"><br>");
		sbSql.append(tab+tab+"select <br>");
		sbSql.append(tab+tab+"&lt;include refid=\"Base_Column_List\" /> <br>");
		sbSql.append(tab+tab+"from " + tableName + " where " + primaryKey + "=#{" + primaryKeyUpper + ",jdbcType="+primaryKeyJdbcType+"}<br>");
		sbSql.append(tab+"&lt;/select><br>");
		
		return sbSql.toString();
	}
	
	
	private String buildSelectByParam(MyTable tbInfo,List<MyColumn> columns)
	{
		String tableName = CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name());
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;select id=\"loadByParam\" resultType=\""+className +"\" parameterType=\"java.util.Map\"><br>");
		sbSql.append(tab+tab+"select <br>");
		sbSql.append(tab+tab+"&lt;include refid=\"Base_Column_List\" /> <br>");
		sbSql.append(tab+tab+"from " + tableName +"<br>");
		sbSql.append(tab+tab+"&lt;where> <br>");
		sbSql.append(tab+tab + "&lt;!-- 以下查询条件为模拟生成，请大家开发时进行修改--><br>");
		
		for(int i=1;i<4&&i<columns.size();i++)
		{
			String columnName = columns.get(i).getColumn_name();
			String columnNameUpper = CBStringUtils.getStrUnderlineUpper(columnName, columnName);
			String jdbcType = CBStringUtils.convertDataTypeToMapperType(columns.get(i).getData_type());
			sbSql.append(tab+tab+tab+"&lt;if test=\""+columnNameUpper + "!=null\"><br> "+tab+tab+tab+tab+"and "+columnName+"=#{"+columnNameUpper+",jdbcType="+jdbcType+"}<br>"+tab+tab+tab+"&lt;/if> <br>");
		}
		
		sbSql.append(tab+tab+"&lt;/where> <br>");
		sbSql.append(tab+"&lt;/select><br>");
		
		return sbSql.toString();
	}
	
	
	
	private String buildList(MyTable tbInfo)
	{
		String tableName = CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name());
//		String className = CBStringUtils.convertFirstCharToUpper(tbInfo.getTable_name());
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(), tbInfo.getTable_name());
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;select id=\"list\" resultType=\""+className +"\" ><br>");
		sbSql.append(tab+tab+"select <br>");
		sbSql.append(tab+tab+"&lt;include refid=\"Base_Column_List\" /> <br>");
		sbSql.append(tab+tab+"from " + tableName +"<br>");
		sbSql.append(tab+"&lt;/select><br>");
		return sbSql.toString();
	}
	
	
	private String buildListByParam(MyTable tbInfo,List<MyColumn> columns)
	{
		String tableName = CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name());
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name());
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;select id=\"listByParam\" resultType=\""+className +"\" parameterType=\"java.util.Map\" ><br>");
		sbSql.append(tab+tab+"select <br>");
		sbSql.append(tab+tab+"&lt;include refid=\"Base_Column_List\" /> <br>");
		sbSql.append(tab+tab+"from " + tableName +"<br>");
		sbSql.append(tab+tab+"&lt;where> <br>");
		sbSql.append(tab+tab + "&lt;!-- 以下查询条件为模拟生成，请大家开发时进行修改--><br>");
		
		for(int i=1;i<4&&i<columns.size();i++)
		{
			String columnName = columns.get(i).getColumn_name();
			String columnNameUpper = CBStringUtils.getStrUnderlineUpper(columnName, columnName);
			String jdbcType = CBStringUtils.convertDataTypeToMapperType(columns.get(i).getData_type());
			sbSql.append(tab+tab+tab+"&lt;if test=\""+columnNameUpper + "!=null\"><br>"+tab+tab+tab+tab+"and "+columnName+"=#{"+columnNameUpper+",jdbcType="+jdbcType+"}<br>"+tab+tab+tab+"&lt;/if> <br>");
		}
		
		sbSql.append(tab+tab+"&lt;/where> <br>");
		sbSql.append(tab+"&lt;/select><br>");
		return sbSql.toString();
	}
	
	
	private String buildFind(MyTable tbInfo,List<MyColumn> columns)
	{
		String tableName = CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name());
		String className = CBStringUtils.getStrFirstCharAndUnderLineUpper(tbInfo.getTable_name(),tbInfo.getTable_name());
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;select id=\"find\" resultType=\""+className +"\" parameterType=\"java.util.Map\" ><br>");
		sbSql.append(tab+tab+"select <br>");
		sbSql.append(tab+tab+"&lt;include refid=\"Base_Column_List\" /> <br>");
		sbSql.append(tab+tab+"from " + tableName +"<br>");
		sbSql.append(tab+tab+"&lt;where> <br>");
		sbSql.append(tab+tab + "&lt;!-- 以下查询条件为模拟生成，请大家开发时进行修改--><br>");
		
		for(int i=1;i<4&&i<columns.size();i++)
		{
			String columnName = columns.get(i).getColumn_name();
			String columnNameUpper = CBStringUtils.getStrUnderlineUpper(columnName, columnName);
			String jdbcType = CBStringUtils.convertDataTypeToMapperType(columns.get(i).getData_type());
			sbSql.append(tab+tab+tab+"&lt;if test=\""+columnNameUpper + "!=null\"><br>"+tab+tab+tab+tab+"and "+columnName+"=#{"+columnNameUpper+",jdbcType="+jdbcType+"}<br>"+tab+tab+tab+"&lt;/if> <br>");
		}
		
		sbSql.append(tab+tab+"&lt;/where> <br>");
		
		sbSql.append(tab+tab+"&lt;if test=\"sort!= null\"><br>");
		sbSql.append(tab+tab + tab+"order by ${sort}<br>");
		sbSql.append(tab+tab + tab+"&lt;if test=\"order!= null\"> ${order} &lt;/if><br>");
		sbSql.append(tab+tab+"&lt;/if><br>");
		
		sbSql.append(tab + tab+"&lt;if test=\"pageOffset!= null\"> limit #{pageOffset},#{pageSize} &lt;/if><br>");
		
		sbSql.append(tab+"&lt;/select><br>");
		return sbSql.toString();
	}
	
	private String buildFindCount(MyTable tbInfo,List<MyColumn> columns)
	{
		String tableName = CBStringUtils.handlerNumbersInStr(tbInfo.getTable_name());
		StringBuilder sbSql = new StringBuilder();
		sbSql.append(tab+"&lt;select id=\"findCount\" resultType=\"int\" parameterType=\"java.util.Map\" ><br>");
		sbSql.append(tab+tab+"select count(*) from "+ tableName +"<br>");
		sbSql.append(tab+tab+"&lt;where> <br>");
		sbSql.append(tab+tab + "&lt;!-- 以下查询条件为模拟生成，请大家开发时进行修改--><br>");
		
		for(int i=1;i<4&&i<columns.size();i++)
		{
			String columnName = columns.get(i).getColumn_name();
			String columnNameUpper = CBStringUtils.getStrUnderlineUpper(columnName, columnName);
			String jdbcType = CBStringUtils.convertDataTypeToMapperType(columns.get(i).getData_type());
			sbSql.append(tab+tab+tab+"&lt;if test=\""+columnNameUpper + "!=null\"><br>"+tab+tab+tab+tab+"and "+columnName+"=#{"+columnNameUpper+",jdbcType="+jdbcType+"}<br>"+tab+tab+tab+"&lt;/if> <br>");
		}
		
		sbSql.append(tab+tab+"&lt;/where> <br>");		
		
		sbSql.append(tab+"&lt;/select><br>");
		return sbSql.toString();
	}
}
