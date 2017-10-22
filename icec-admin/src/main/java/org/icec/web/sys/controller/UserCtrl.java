package org.icec.web.sys.controller;

import org.beetl.sql.core.engine.PageQuery;
import org.icec.web.common.BaseController;
import org.icec.web.sys.model.SysUser;
import org.icec.web.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys/user")
public class UserCtrl extends BaseController{
	
	@Autowired
	private SysUserService userService;
	/**
	 * 进入添加界面
	 * @return
	 */
	@RequestMapping("add")
	public String add() {
		return "sys/user/userAdd";
	}
	/**
	 * 保存数据逻辑
	 * @param user
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public Integer save(SysUser user) {
		userService.save(user);
		return 1;
	}
	/**
	 * 进入修改界面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("edit/{id}")
	public String edit(@PathVariable Long id ,ModelMap model) {
		SysUser user = userService.findById(id);
		model.addAttribute("user", user);
		return "sys/user/userEdit";
	}
	/**
	 * 更新数据逻辑
	 * @param user
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public Integer update(SysUser user) {
		if(user==null||user.getId()==null) {
			return 0;
		}
		userService.update(user);
		return 1;
	}
	/**
	 * 进入查询界面
	 * @return
	 */
	@RequestMapping("list")
	public String listInit() {
		return "sys/user/userList";
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
	public PageQuery<SysUser> query( @RequestParam(defaultValue="1") Integer pageNumber, Integer pageSize, SysUser user) {
		PageQuery<SysUser> query=new PageQuery<SysUser>();
		query.setPageNumber(pageNumber);
		if(pageSize!=null) {
			query.setPageSize(pageSize);
		}
		query.setParas(user);
		  query=userService.queryUser(query);
		   
		return  query;
	}
	
}
