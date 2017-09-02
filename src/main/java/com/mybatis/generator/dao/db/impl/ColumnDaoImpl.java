package com.mybatis.generator.dao.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mybatis.generator.dao.DBUtil;
import com.mybatis.generator.dao.db.ColumnDao;
import com.mybatis.generator.model.DataBaseConfig;
import com.mybatis.generator.model.MyColumn;
@Repository
public class ColumnDaoImpl implements ColumnDao {

	public List<MyColumn> list(DataBaseConfig dbEntity, String tbName) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<MyColumn> colums = new ArrayList<MyColumn>();

		try {
			String sql = "select table_name,table_schema,column_name,ordinal_position,column_default,"
					+ " is_nullable,data_type,column_type,column_key,column_comment from `columns` "
					+ " where table_name=? and table_schema = ? ";
			con = DBUtil.getConnection(dbEntity);
			ps = con.prepareStatement(sql);
			ps.setString(1, tbName);
			ps.setString(2, dbEntity.getDatabaseName());
			rs = ps.executeQuery();
			while (rs.next()) {
				MyColumn c = new MyColumn();
				c.setColumn_comment(rs.getString("column_comment"));
				c.setColumn_default(rs.getString("column_default"));
				c.setColumn_name(rs.getString("column_name"));
				c.setColumn_key(rs.getString("column_key"));
				c.setColumn_type(rs.getString("column_type"));
				c.setData_type(rs.getString("data_type"));
				c.setIs_nullable(rs.getString("is_nullable"));
				c.setOrdinal_position(rs.getInt("ordinal_position"));
				c.setTable_name(rs.getString("table_name"));
				c.setTable_schema(rs.getString("table_schema"));
				colums.add(c);
			}
		} catch (Exception e) {

		}
		finally
		{
			DBUtil.close(ps);
			DBUtil.close(con);
		}

		return colums;
	}
	
}
