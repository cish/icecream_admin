package org.icec.web.sys.dao;


import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.icec.web.sys.model.SysUser;

public interface  SysUserDao extends BaseMapper<SysUser>{
	public SysUser findById(@Param("id")Integer id);
	public PageQuery<SysUser> queryUser(PageQuery<SysUser> query);
	public PageQuery<SysUser> queryUnSelectedUser(PageQuery<SysUser> query);
	
}
