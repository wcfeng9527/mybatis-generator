package com.mybatis.generator.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.generator.model.DataBaseConfig;
import com.mybatis.generator.model.MyColumn;
import com.mybatis.generator.model.MyTable;
import com.mybatis.generator.service.db.DBService;
import com.mybatis.generator.service.db.DbListConfig;

@RestController
@RequestMapping(value="/db")
public class DBController {
	
	Logger log = Logger.getLogger(DBController.class);
	
	@Autowired
	private DBService dBService;
	@Autowired
	private DbListConfig dbListConfig;
	
	@RequestMapping(value="/dblist",method=RequestMethod.GET)
	public ModelAndView databases(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		List<DataBaseConfig> dbList = new ArrayList<DataBaseConfig>();
//		dbList = dbListConfig.getList();
		dbList =dBService.getDataBaseList();
		Map<String,Object> map = new HashMap<>();
		map.put("dbList", dbList);
		return new ModelAndView("dblist",map);
	}
	

	

	
	@RequestMapping(value="/tablelist/{dbid}",method=RequestMethod.GET)
	public ModelAndView tableList(@PathVariable String dbid,Model model)
	{
		List<MyTable> tables = dBService.tableList(dbid);
		Map<String,Object> map = new HashMap<>();
		map.put("tables", tables);
		return new ModelAndView("tablelist",map);
	}
	
	
	/**
	 * generator
	 * @param dbid
	 * @param tbName
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/codelist/{dbid}/{tbName}",method=RequestMethod.GET)
	public ModelAndView codeList(@PathVariable String dbid,@PathVariable String tbName,Model model)
	{
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("dbid", dbid);
		paraMap.put("tbName", tbName);
		List<String> codeList = dBService.codeList(paraMap);
		Map<String, Object> map = new HashMap<>();
		map.put("codeList", codeList);
		return new ModelAndView("codelist",map);
	}
	
	/**
	 * table column  message
	 * @param dbid
	 * @param tbName
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/columnlist/{dbid}/{tbName}",method=RequestMethod.GET)
	public ModelAndView columnList(@PathVariable String dbid,@PathVariable String tbName,Model model)
	{
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("dbid", dbid);
		paraMap.put("tbName", tbName);
		List<MyColumn> columns = dBService.columnList(paraMap);
		
		Map<String, Object> map = new HashMap<>();
		map.put("columns", columns);
		return new ModelAndView("columnlist",map);
	}
	
	@RequestMapping(value="/addDB")
	public ModelAndView addDB(){
		return new ModelAndView("addDB");
	}
	@RequestMapping(value="/addDBSubmit")
	public ModelAndView addDBSubmit(HttpServletRequest request,HttpServletResponse response,DataBaseConfig dataBaseEntity){
		log.info("addDBSubmit 入口参数："+dataBaseEntity.toString());
		
		
		dBService.addDBSubmit(dataBaseEntity);
		
		
		return new ModelAndView("redirect:/db/dblist");
	}
	
	

}
