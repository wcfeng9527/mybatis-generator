package com.mybatis.generator.model;

import java.util.Date;

public class MyTable {
	private String table_name;
	private String table_schema;
	private String table_comment;
	private Date create_time;
	private int auto_increment;

	private String dbId;

	public String getDbId() {
		return dbId;
	}

	public void setDbId(String dbId) {
		this.dbId = dbId;
	}

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getTable_schema() {
		return table_schema;
	}

	public void setTable_schema(String table_schema) {
		this.table_schema = table_schema;
	}

	public String getTable_comment() {
		return table_comment;
	}

	public void setTable_comment(String table_comment) {
		this.table_comment = table_comment;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public int getAuto_increment() {
		return auto_increment;
	}

	public void setAuto_increment(int auto_increment) {
		this.auto_increment = auto_increment;
	}

	public MyTable(String table_name, String table_schema,
			String table_comment, Date create_time, int auto_increment) {
		this.table_name = table_name;
		this.table_schema = table_schema;
		this.table_comment = table_comment;
		this.create_time = create_time;
		this.auto_increment = auto_increment;
	}

	public MyTable() {

	}

}
