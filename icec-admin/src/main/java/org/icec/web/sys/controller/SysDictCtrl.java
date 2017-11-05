package org.icec.web.sys.controller;

import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.icec.web.shiro.annotation.CurrentUser;
import org.icec.web.sys.model.SysDict;
import org.icec.web.sys.model.SysUser;
import org.icec.web.sys.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 字典管理
 * @author jinxx
 *
 */
@Controller
@RequestMapping("sys/dict")
public class SysDictCtrl {
	@Autowired
	private SysDictService sysDictService;
	
	@RequestMapping("add")
	public String add() {
		return "sys/dict/dictAdd";
	}
	@RequestMapping("save")
	@ResponseBody
	public String save(SysDict sysDict,@CurrentUser SysUser currUser) {
		sysDictService.save(sysDict, currUser);
		return "1";
	}
	
	/**
	 * 进入查询界面
	 * @return
	 */
	@RequestMapping("list")
	public String list() {
		return "sys/dict/dictList";
	}
	@RequestMapping("query")
	@ResponseBody
	public PageQuery<SysDict> query( @RequestParam(defaultValue="1") Integer pageNumber, Integer pageSize, SysDict sysDict) {
		PageQuery<SysDict> query=new PageQuery<SysDict>();
		query.setPageNumber(pageNumber);
		if(pageSize!=null) {
			query.setPageSize(pageSize);
		}
		query.setParas(sysDict);
		  query=sysDictService.queryDict(query);
		   
		return  query;
	}
	
	
	@RequestMapping("getDictValue")
	@ResponseBody
	public List<SysDict> getDictValue(Integer typeId){
		return sysDictService.getDictValue(typeId);
	}
}
