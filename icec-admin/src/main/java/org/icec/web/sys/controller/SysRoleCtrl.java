package org.icec.web.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.beetl.sql.core.engine.PageQuery;
import org.icec.web.shiro.annotation.CurrentUser;
import org.icec.web.sys.model.SysRole;
import org.icec.web.sys.model.SysUser;
import org.icec.web.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys/role")
public class SysRoleCtrl {
	@Autowired
	private SysRoleService sysRoleService;
	/**
	 * 进入添加界面
	 * @return
	 */
	@RequestMapping("add")
	//@RequiresPermissions({"role:edit"})
	public String add() {
		return "sys/role/roleAdd";
	}
	/**
	 * 保存数据逻辑
	 * @param role
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	//@RequiresPermissions({"role:edit"})
	public Integer save(SysRole role,@CurrentUser SysUser user) {
		sysRoleService.save(role,user);
		return 1;
	}
	/**
	 * 进入修改界面
	 * @param id
	 * @param model
	 * @return
	 */
	//@RequiresPermissions({"user:edit"})
	@RequestMapping("edit/{id}")
	public String edit(@PathVariable Integer id ,ModelMap model) {
		SysRole sysRole = sysRoleService.findById(id);
		model.addAttribute("sysRole", sysRole);
		return "sys/user/userEdit";
	}
	/**
	 * 更新数据逻辑
	 * @param user
	 * @return
	 */
	//@RequiresPermissions({"user:edit"})
	@RequestMapping("update")
	@ResponseBody
	public Integer update(SysRole sysRole) {
		if(sysRole==null||sysRole.getId()==null) {
			return 0;
		}
		//sysRoleService.update(sysRole);
		return 1;
	}
	/**
	 * 进入查询界面
	 * @return
	 */
	@RequestMapping("list")
	public String list() {
		return "sys/role/roleList";
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
	public PageQuery<SysRole> query( @RequestParam(defaultValue="1") Integer pageNumber, Integer pageSize, SysRole role) {
		PageQuery<SysRole> query=new PageQuery<SysRole>();
		query.setPageNumber(pageNumber);
		if(pageSize!=null) {
			query.setPageSize(pageSize);
		}
		query.setParas(role);
		  query=sysRoleService.queryRole(query);
		   
		return  query;
	}
}
