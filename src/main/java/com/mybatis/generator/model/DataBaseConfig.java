package com.mybatis.generator.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DataBaseConfig {
	  //
    private Integer id;	
    //列表显示名称
    private String showName;	
    //数据库ip
    private String url;	
    //数据库名称
    private String databaseName;	
    //用户名
    private String username;	
    //密码
    private String pwd;	
    //是否分库分表
    private Integer state;	


    /**
     * 获取的值 
     * @return :
     */
    public Integer getId(){ 
        return id;
    }

    /**
     * 设置的值 
     * @param id
     */
    public void setId(Integer id){ 
        this.id = id;
    }

    /**
     * 获取列表显示名称的值 
     * @return :
     */
    public String getShowName(){ 
        return showName;
    }

    /**
     * 设置列表显示名称的值 
     * @param showName
     */
    public void setShowName(String showName){ 
        this.showName = showName;
    }

    /**
     * 获取数据库ip的值 
     * @return :
     */
    public String getUrl(){ 
        return url;
    }

    /**
     * 设置数据库ip的值 
     * @param url
     */
    public void setUrl(String url){ 
        this.url = url;
    }

    /**
     * 获取数据库名称的值 
     * @return :
     */
    public String getDatabaseName(){ 
        return databaseName;
    }

    /**
     * 设置数据库名称的值 
     * @param databaseName
     */
    public void setDatabaseName(String databaseName){ 
        this.databaseName = databaseName;
    }

    /**
     * 获取用户名的值 
     * @return :
     */
    public String getUsername(){ 
        return username;
    }

    /**
     * 设置用户名的值 
     * @param username
     */
    public void setUsername(String username){ 
        this.username = username;
    }

    /**
     * 获取密码的值 
     * @return :
     */
    public String getPwd(){ 
        return pwd;
    }

    /**
     * 设置密码的值 
     * @param pwd
     */
    public void setPwd(String pwd){ 
        this.pwd = pwd;
    }

    /**
     * 获取是否分库分表的值 
     * @return :
     */
    public Integer getState(){ 
        return state;
    }

    /**
     * 设置是否分库分表的值 
     * @param state
     */
    public void setState(Integer state){ 
        this.state = state;
    }
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}