package com.mybatis.generator.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.generator.model.User;

@RestController
public class LoginController {

	Logger log = Logger.getLogger(LoginController.class);
	
	
	@RequestMapping(value="/login")
	public ModelAndView login(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/submit")
	public ModelAndView submit(HttpServletRequest request,HttpServletResponse response,User user){
		
//		CookieUtil.addCookie(response, "auth", user.getName(), 60*60*24*3);
		log.info("login提交操作！！！");
		
		return new ModelAndView("redirect:/db/dblist");
	}
}
