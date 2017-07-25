package com.llahn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.llahn.common.controller.BaseController;
import com.llahn.common.persistence.dao.UserMapper;
import com.llahn.common.persistence.vo.User;

/** 
 * @ClassName: LoginController 
 * @Description: 登录控制器
 * @company HPE  
 * @author lilei   
 * @date 2017年7月24日 下午4:24:59 
 *  
 */ 
@Controller
public class LoginController extends BaseController{
	
	@Autowired
    UserMapper userMapper;
	/** 
	 * @Title: index 
	 * @Description: 跳转主页
	 * @param @param model
	 * @param @return    参数 
	 * @return String    返回类型 
	 * @throws 
	 */ 
	@GetMapping("/")
	public String index(Model model) {
		User user = userMapper.selectById(1);
		return "/index.html";
	}
}
