package org.icec.web.sys.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.icec.web.sys.model.SysOffice;

import java.util.List;

import org.icec.web.sys.dao.SysOfficeDao;

/*
* 
* gen by icec servicegen 2017-10-24
*/
@Service
public class SysOfficeService   {
	@Autowired
	private SysOfficeDao  sysOfficeDao ;
	
	/**
	*
	*保存
	*/
	@Transactional
	public void save(SysOffice sysOffice){
		sysOfficeDao.insert(sysOffice);
	}
	/**
	 * 查詢
	 * @return
	 */
	public List<SysOffice> query(){
		return sysOfficeDao.query();
	}
}
