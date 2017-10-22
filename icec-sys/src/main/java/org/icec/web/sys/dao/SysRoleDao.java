package org.icec.web.sys.dao;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.icec.web.sys.model.SysRole;

public interface SysRoleDao extends BaseMapper<SysRole>{
	public PageQuery<SysRole> queryRole(PageQuery<SysRole> query);
}
