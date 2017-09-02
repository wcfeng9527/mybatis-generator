package com.mybatis.generator.service.db;

import java.util.List;
import java.util.Map;

import com.mybatis.generator.model.DataBaseConfig;
import com.mybatis.generator.model.MyColumn;
import com.mybatis.generator.model.MyTable;

public interface DBService {

	List<MyTable> tableList(String dbid);

	List<String> codeList(Map<String, Object> paraMap);

	List<MyColumn> columnList(Map<String, Object> paraMap);

	void addDBSubmit(DataBaseConfig dataBaseEntity);

	List<DataBaseConfig> getDataBaseList();

}
