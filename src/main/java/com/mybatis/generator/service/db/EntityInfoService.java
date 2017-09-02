package com.mybatis.generator.service.db;

import java.util.List;

import com.mybatis.generator.model.DataBaseConfig;
import com.mybatis.generator.model.MyColumn;
import com.mybatis.generator.model.MyTable;

public interface EntityInfoService {

	String buildEntityInfo(MyTable tb, List<MyColumn> columns);

	String buildIDaoInfo(MyTable tb);

	String buildMapperInfo(MyTable tb, List<MyColumn> columns);

	String buildServiceInfo(MyTable tb);

	String buildServiceImplInfo(MyTable tb);

	String buildControllerInfo(MyTable tb);

	String buildIDaoInfoSpecial(MyTable tb, DataBaseConfig dbEntity, List<MyColumn> columns);

	String buildFeignServiceInfo(MyTable tb);
	
	
	

}
