package org.icec.web.sys.controller;


import org.icec.web.shiro.annotation.CurrentUser;
import org.icec.web.sys.model.SysUser;
import org.icec.web.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCtrl {
	@Autowired
	private UserService userService;
	@GetMapping({"/","/index"})
	public String index(@CurrentUser SysUser user,ModelMap model) {
		model.addAttribute("user", user);
		return "sys/index";
	}
}
