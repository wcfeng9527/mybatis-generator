package com.mybatis.generator.dao.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mybatis.generator.dao.DBUtil;
import com.mybatis.generator.dao.db.MyTableDao;
import com.mybatis.generator.model.DataBaseConfig;
import com.mybatis.generator.model.MyTable;

@Repository
public class MyTableDaoImpl implements MyTableDao{
	
	@Override
	public List<MyTable> tableList(DataBaseConfig dbEntity) {
		List<MyTable> tables = new ArrayList<MyTable>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select table_name,table_schema,table_comment,create_time,auto_increment from `tables` where table_schema = ? ";
			con = DBUtil.getConnection(dbEntity);
			ps = con.prepareStatement(sql);
			ps.setString(1, dbEntity.getDatabaseName());
			rs = ps.executeQuery();
			while (rs.next()) {
				MyTable t = new MyTable();
				t.setAuto_increment(rs.getInt("auto_increment"));
				t.setCreate_time(rs.getDate("create_time"));
				t.setTable_comment(rs.getString("table_comment"));
				t.setTable_name(rs.getString("table_name"));
				t.setTable_schema(rs.getString("table_schema"));
				t.setDbId(dbEntity.getId()+"");
				tables.add(t);
			}
		} catch (Exception e) {

		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return tables;
	}
	
	@Override
	public MyTable loadByName(DataBaseConfig dbEntity,String tbName)
	{
		MyTable t = new MyTable();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select table_name,table_schema,table_comment,create_time,auto_increment "
					+" from `tables` where table_schema = ? and table_name = ? ";
			con = DBUtil.getConnection(dbEntity);
			ps = con.prepareStatement(sql);
			ps.setString(1, dbEntity.getDatabaseName());
			ps.setString(2, tbName);
			rs = ps.executeQuery();
			while (rs.next()) {
				t.setAuto_increment(rs.getInt("auto_increment"));
				t.setCreate_time(rs.getDate("create_time"));
				t.setTable_comment(rs.getString("table_comment"));
				t.setTable_name(rs.getString("table_name"));
				t.setTable_schema(rs.getString("table_schema"));
			}
		} catch (Exception e) {

		} finally {
			DBUtil.close(ps);
			DBUtil.close(con);
		}
		return t;
	}

}
