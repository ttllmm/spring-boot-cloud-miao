package com.miao.web.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miao.common.service.HttpClientService;
import com.miao.common.vo.HttpResult;
import com.miao.common.vo.SysResult;
import com.miao.web.pojo.User;

@Service	
public class UserService {
	@Autowired
	private HttpClientService client;
	public void doRegister(User user) throws Exception {
		//httpclient调用sso系统的数据,存储注册
		String url="http://sso.miao.com/user/register";
		//map保存请求体中的参数 username=**&pasword=**...
		//封装参数param
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("username", user.getUsername());
		param.put("password", user.getPassword());
		param.put("phone", user.getPhone());
		//email,数据库有唯一性校验,""
		param.put("email", user.getUsername());
		client.doPost(url, param);
	}
	public String doLogin(String username, String password) throws Exception {
		String url="http://sso.miao.com/user/login";
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("u", username);
		param.put("p", password);
		HttpResult response = client.doPost(url, param);
		String dataJson = response.getBody();//sysresult的json字符串
		//从dataJson中解析出来ticket的值
		ObjectMapper mapper=new ObjectMapper();
		SysResult data=mapper.readValue(dataJson, 
				SysResult.class);
		String ticket=(String)data.getData();
		//12345这个字符串,"12345" null "null"
		return ticket;
	}
	
	
}
