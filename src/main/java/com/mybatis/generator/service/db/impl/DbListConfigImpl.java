package com.mybatis.generator.service.db.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.mybatis.generator.model.DataBaseConfig;
import com.mybatis.generator.service.db.DbListConfig;

@Service
public class DbListConfigImpl implements DbListConfig{
	
	Logger log = Logger.getLogger(DbListConfigImpl.class);
	
	@Value("${dbxml.url}")
	private String dbxmlUrl;
	
	
	/**
	 * 内部帮助方法 获取xml数据转换为实体列表
	 * @return
	 */
	@Override
	public List<DataBaseConfig> getList() {
		List<DataBaseConfig> dbList = new ArrayList<DataBaseConfig>();
//		FileUtils fileUtil = new FileUtils();
//		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
//		ServletContext servletContext = ; 
		
		
//		File directory = new File("");
//		String path = directory.getAbsolutePath()+dbxmlUrl;
//		log.info("realPath路径："+path);
//		String projectPath = this.getClass().getResource(dbxmlUrl).getPath();
//		String path = "../../../"+projectPath.substring(1, projectPath.length());
		File directory = new File("");
		String path = directory.getAbsolutePath()+dbxmlUrl;
		log.info("path路径："+path);
//		String pathUrl = DbListConfigImpl.class.getClassLoader().getResource("/static/dbxml/dblist.xml").getPath();
//		String path = pathUrl.substring(1, pathUrl.length());
//		log.info("realPath路径："+path);
		File file = new File(path);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			NodeList nl = doc.getElementsByTagName("db");
			for (int i = 0; i < nl.getLength(); i++) {
				DataBaseConfig dbEntity = new DataBaseConfig();
				dbEntity.setDatabaseName(doc.getElementsByTagName("database")
						.item(i).getFirstChild().getNodeValue());
//				dbEntity.setId(doc.getElementsByTagName("id").item(i).getFirstChild().getNodeValue());
				dbEntity.setPwd(doc.getElementsByTagName("password")
						.item(i).getFirstChild().getNodeValue());
				dbEntity.setShowName(doc.getElementsByTagName("showname")
						.item(i).getFirstChild().getNodeValue());
				dbEntity.setUrl(doc.getElementsByTagName("url").item(i)
						.getFirstChild().getNodeValue());
				dbEntity.setUsername(doc.getElementsByTagName("username")
						.item(i).getFirstChild().getNodeValue());
				dbList.add(dbEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dbList;
	}

}
