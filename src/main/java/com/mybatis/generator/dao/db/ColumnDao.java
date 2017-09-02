package com.mybatis.generator.dao.db;

import java.util.List;

import com.mybatis.generator.model.DataBaseConfig;
import com.mybatis.generator.model.MyColumn;

public interface ColumnDao {

	List<MyColumn> list(DataBaseConfig dbEntity, String tbName);

}
