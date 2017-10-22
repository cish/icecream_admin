package org.icec.web.sys.controller;

import java.util.ArrayList;
import java.util.List;

import org.icec.web.shiro.annotation.CurrentUser;
import org.icec.web.sys.model.SysMenu;
import org.icec.web.sys.model.SysUser;
import org.icec.web.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys/menu")
public class SysMenuCtrl {
	@Autowired
	private SysMenuService sysMenuService;
	/**
	 * 进入添加界面
	 * @return
	 */
	@RequestMapping("add")
	public String add() {
		return "sys/menu/menuAdd";
	}
	/**
	 * 保存数据逻辑
	 * @param role
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public Integer save(SysMenu menu,@CurrentUser SysUser user) {
		sysMenuService.save(menu,user);
		return 1;
	}
	/**
	 * 进入查询界面
	 * @return
	 */
	@RequestMapping("list")
	public String list() {
		return "sys/menu/menuList";
	}
	/**
	 * 查询逻辑
	 * @param pageNumber
	 * @param pageSize
	 * @param user
	 * @return
	 */
	@RequestMapping("query")
	@ResponseBody
	public List<SysMenu> query() {
		List<SysMenu> query=new ArrayList<SysMenu>();
		 
		  query=sysMenuService.query();
		   
		return  query;
	}
}
