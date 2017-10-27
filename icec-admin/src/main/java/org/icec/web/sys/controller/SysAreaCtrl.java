package org.icec.web.sys.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.beetl.sql.core.engine.PageQuery;
import org.icec.web.shiro.annotation.CurrentUser;
import org.icec.web.sys.model.SysArea;
import org.icec.web.sys.model.SysRole;
import org.icec.web.sys.model.SysUser;
import org.icec.web.sys.service.SysAreaService;
import org.icec.web.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys/area")
public class SysAreaCtrl {
	@Autowired
	private SysAreaService sysAreaService;
	/**
	 * 进入添加界面
	 * @return
	 */
	@RequestMapping("add")
	//@RequiresPermissions({"role:edit"})
	public String add() {
		return "sys/area/areaAdd";
	}
	/**
	 * 保存数据逻辑
	 * @param role
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	//@RequiresPermissions({"role:edit"})
	public Integer save(SysArea sysArea,@CurrentUser SysUser user) {
		sysAreaService.save(sysArea,user);
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
		SysArea sysArea = sysAreaService.findById(id);
		model.addAttribute("sysArea", sysArea);
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
	public Integer update(SysArea sysArea) {
		if(sysArea==null||sysArea.getId()==null) {
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
	public String list(ModelMap model) {
		model.addAttribute("areaList", sysAreaService.query());
		return "sys/area/areaList";
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
	public List<SysArea> query( SysArea sysArea) {
		 
		
		   
		return  null;
	}
}
