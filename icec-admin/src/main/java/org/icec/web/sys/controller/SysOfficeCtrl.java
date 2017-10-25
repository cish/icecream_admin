package org.icec.web.sys.controller;

import java.util.ArrayList;
import java.util.List;

import org.icec.web.sys.model.SysOffice;
import org.icec.web.sys.service.SysOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sys/office")
public class SysOfficeCtrl {
	@Autowired
	private SysOfficeService sysOfficeService;
	@RequestMapping("list")
	public String list() {
		return "sys/office/officeList";
	}
	/**
	 * 查询逻辑
	 * @param user
	 * @return
	 */
	@RequestMapping("query")
	@ResponseBody
	public List<SysOffice> query() {
		List<SysOffice> query=new ArrayList<SysOffice>();
		 
		  query=sysOfficeService.query();
		   
		return  query;
	}
}
