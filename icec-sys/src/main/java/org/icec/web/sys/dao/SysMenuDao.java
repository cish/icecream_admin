package org.icec.web.sys.dao;

import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.icec.web.sys.model.SysMenu;

public interface SysMenuDao extends BaseMapper<SysMenu>{
	/**
	 * 菜单查询
	 * @param query
	 * @return
	 */
	public PageQuery<SysMenu> query(PageQuery<SysMenu> query);
}
