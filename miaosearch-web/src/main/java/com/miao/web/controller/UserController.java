package com.miao.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.miao.common.util.CookieUtils;
import com.miao.common.vo.SysResult;
import com.miao.web.pojo.User;
import com.miao.web.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/service/user/doRegister")
	@ResponseBody
	public SysResult doRegister(User user){
		//可以添加异常逻辑判断成功失败,后台sso返回的200/201判断
		try{
			userService.doRegister(user);
			return SysResult.oK(user.getUsername());
		}catch(Exception e){
			return SysResult.build(201, "失败", user.getUsername());
		}
	}
	
	@RequestMapping("service/user/doLogin")
	@ResponseBody
	public SysResult doLogin(String username,
			String password,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String ticket=userService.doLogin(username,password);
		//用sso返回的ticket,传给页面一个cookie值,JT_TICKET
		//有可能是空字符串""
		if(StringUtils.isNotEmpty(ticket)){//null,""都表示empty
			//登录成功,ticket放到cookie-JT_TICKET
			CookieUtils.setCookie(request, response,
					"JT_TICKET", ticket);
			//CookieUtils.deleteCookie(request, response, cookieName);
			return SysResult.oK();
		}
		return SysResult.build(201, "账号密码错误");
	}
	
}



























