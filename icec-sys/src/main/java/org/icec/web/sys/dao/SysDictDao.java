package org.icec.web.sys.dao;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.icec.web.sys.model.*;

/*
* 
* gen by beetlsql mapper 2017-11-05
*/
public interface SysDictDao extends BaseMapper<SysDict> {
	
	public PageQuery<SysDict> queryDict(PageQuery<SysDict> query);
}
