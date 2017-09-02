package com.mybatis.generator.dao.db;

import java.util.List;

import com.mybatis.generator.model.DataBaseConfig;
import com.mybatis.generator.model.MyTable;

public interface MyTableDao {

	List<MyTable> tableList(DataBaseConfig dbEntity);

	MyTable loadByName(DataBaseConfig dbEntity, String tbName);

}
