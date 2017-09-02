package com.mybatis.generator.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mybatis.generator.model.DataBaseConfig;
@Mapper
public interface DataBaseConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DataBaseConfig record);

    int insertSelective(DataBaseConfig record);

    DataBaseConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DataBaseConfig record);

    int updateByPrimaryKey(DataBaseConfig record);

	List<DataBaseConfig> selectDataBaseList();
}