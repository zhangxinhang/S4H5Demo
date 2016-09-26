package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Page;
import com.biz.UserBiz;
import com.entity.User;

@Controller
@RequestMapping("/")
public class MainController {
	@Resource
	private UserBiz userBiz;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String index() {
		return "world";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Page<User> list(HttpServletRequest request) {
		return userBiz.getUserPage(10, 1);
	}
}
