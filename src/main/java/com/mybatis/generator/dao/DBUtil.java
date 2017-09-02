package com.mybatis.generator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mybatis.generator.model.DataBaseConfig;


public class DBUtil {

	public static Connection getConnection()
	{
		return getConnection(null,null,null);
	}
	
	public static Connection getConnection(DataBaseConfig dbEntity)
	{
		return getConnection(dbEntity.getUrl(),dbEntity.getUsername(),dbEntity.getPwd());
	}
	
	public static Connection getConnection(String url,String username,String password) {
		if(url == null || url.equals(""))  url = "jdbc:mysql://192.168.0.12:3306/information_schema";
		if(username== null || username.equals(""))  username = "root";
		if(password==null || password.equals("")) password = "xunzhi";
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
			con = DriverManager.getConnection(url, username, password);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	public static void close(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
