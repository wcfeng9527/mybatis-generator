package com.mybatis.generator.action;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RestController//@RestController是@Controller和@ResponseBody的结合体，两个标注合并起来的作用。
@RequestMapping("/role")
public class RoleAction {
	
	  Logger log = Logger.getLogger(RoleAction.class);
	
	
	
	
	@RequestMapping("/viewOne")
	public ModelAndView viewOne(){
		
		log.info("进入 modelAndView   viewOne");
		return new ModelAndView("index2.jsp");
	}
	
	
	@RequestMapping("/viewTwo")
	public String viewTwo(){
		
		log.info("进入 String跳转   viewTwo");
		return "index";
	}
	
	@RequestMapping("/viewThree")
	public ModelAndView viewThree(){
		
		log.info("进入 String跳转   viewThree");
		return new ModelAndView("index");
	}
	
	
	
}
