package org.icec.web.sys.dao;

import java.util.List;

import org.beetl.sql.core.mapper.BaseMapper;
import org.icec.web.sys.model.SysMenu;

public interface SysMenuDao extends BaseMapper<SysMenu>{
	/**
	 * 菜单查询
	 * @param query
	 * @return
	 */
	public List<SysMenu> query();
}
