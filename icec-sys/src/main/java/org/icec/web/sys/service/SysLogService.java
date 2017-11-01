package org.icec.web.sys.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.icec.web.sys.model.SysLog;
import org.icec.web.sys.dao.SysLogDao;

/*
* 
* gen by icec  2017-11-01
*/
@Service
public class SysLogService   {
	@Autowired
	private SysLogDao  sysLogDao ;
	
	/**
	*
	*保存
	*/
	@Transactional
	public void save(SysLog sysLog){
		sysLogDao.insert(sysLog);
	}
}
