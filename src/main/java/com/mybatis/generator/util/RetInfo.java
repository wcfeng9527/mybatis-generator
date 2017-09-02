package com.mybatis.generator.util;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

public class RetInfo extends SerializableSerializer{

	private boolean result = true;
	
	private String retInfo;

	public boolean getResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getRetInfo() {
		return retInfo;
	}

	public void setRetInfo(String retInfo) {
		this.retInfo = retInfo;
	}
	
	
}
