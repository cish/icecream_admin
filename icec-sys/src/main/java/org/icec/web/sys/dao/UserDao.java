package org.icec.web.sys.dao;


import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.icec.web.sys.model.SysUser;

public interface  UserDao extends BaseMapper<SysUser>{
	public PageQuery<SysUser> queryUser(PageQuery<SysUser> query);
}
