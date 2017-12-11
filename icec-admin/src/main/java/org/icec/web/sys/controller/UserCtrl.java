package org.icec.web.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.beetl.sql.core.engine.PageQuery;
import org.icec.common.web.BaseController;
import org.icec.web.shiro.annotation.CurrentUser;
import org.icec.web.sys.model.SysUser;
import org.icec.web.sys.service.SysRoleService;
import org.icec.web.sys.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("sys/user")
public class UserCtrl extends BaseController{
	Logger logger=LoggerFactory.getLogger(getClass());
	@Autowired
	private SysUserService userService;
	@Autowired
	private SysRoleService sysRoleService;
	/**
	 * 进入添加界面
	 * @return
	 */
	@RequestMapping("add")
	@RequiresPermissions({"user:edit"})
	public String add(Model model) {
		model.addAttribute("roleList", sysRoleService.findAll());
		return "sys/user/userAdd";
	}
	/**
	 * 保存数据逻辑
	 * @param user
	 * @return
	 */
	@RequiresPermissions({"user:edit"})
	@RequestMapping("save")
	@ResponseBody
	public Integer save(SysUser user,Integer[] roleList,@CurrentUser SysUser optuser,@RequestParam(name="file",required=false) MultipartFile multiFile) {
		 
		SysUser temp=userService.findByUserId(user.getLoginName());
		if(temp!=null) {
			logger.debug("用户名已存在，不能新增");
			return 0;
		}
		userService.save(user,optuser,roleList,  multiFile);
		return 1;
	}
	/**
	 * 进入修改界面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions({"user:edit"})
	@RequestMapping("edit/{id}")
	public String edit(@PathVariable Integer id ,ModelMap model) {
		SysUser user = userService.findById(id);
		model.addAttribute("user", user);
		model.addAttribute("roleList", sysRoleService.findAll());
		ObjectMapper mapper = new ObjectMapper(); 
		String myrole="";
		try {
			myrole = mapper.writeValueAsString(sysRoleService.findRoleByUserId(id));
		} catch (JsonProcessingException e) {
			 
			logger.error("json转换错误",e);
		}
		model.addAttribute("myRole", myrole);
		return "sys/user/userEdit";
	}
	/**
	 * 更新数据逻辑
	 * @param user
	 * @return
	 */
	@RequiresPermissions({"user:edit"})
	@RequestMapping("update")
	@ResponseBody
	public Integer update(SysUser user,Integer[] roleList,@CurrentUser SysUser optuser,@RequestParam(name="file",required=false) MultipartFile multiFile) {
		if(user==null||user.getId()==null) {
			return 0;
		}
		userService.update(user,optuser,roleList,multiFile);
		return 1;
	}
	
	@RequiresPermissions({"user:edit"})
	@RequestMapping("deleteAll")
	@ResponseBody
	public Integer deleteAll(String ids,@CurrentUser SysUser optuser) {
		if(ids==null) {
			return 0;
		}
		userService.deleteAll(ids,optuser);
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
		if(StringUtils.isEmpty(user.getCompanyId())) {
			user.setCompanyId(null);
		}
		query.setPageNumber(pageNumber);
		if(pageSize!=null) {
			query.setPageSize(pageSize);
		}
		query.setParas(user);
		  query=userService.queryUser(query);
		   
		return  query;
	}
	
	/**
	 * 个人信息设置
	 * @param optuser
	 * @return
	 */
	@RequestMapping("userSetting")
	public String userSetting(@CurrentUser SysUser optuser,Model model) {
		SysUser user = userService.findById(optuser.getId());
		model.addAttribute("user", user);
		return "sys/user/userSetting";
	}
	@RequestMapping("modifyPasswd")
	public String modifyPasswd() {
		return "sys/user/modifyPasswd";
	}
	
}
