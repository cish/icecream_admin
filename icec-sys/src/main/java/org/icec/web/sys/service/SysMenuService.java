package org.icec.web.sys.service;

import java.util.Date;
import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.icec.web.sys.dao.SysMenuDao;
import org.icec.web.sys.model.SysMenu;
import org.icec.web.sys.model.SysRole;
import org.icec.web.sys.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	/**
	 * 保存菜单
	 * @param menu
	 * @param optuser  操作人
	 */
	@Transactional
	public void save(SysMenu menu,SysUser optuser) {
		menu.setCreateBy(optuser.getId());
		menu.setCreateDate(new Date());
		menu.setDelFlag(SysMenu.DEL_FLAG_NORMAL);
		sysMenuDao.insert(menu);
	}
	/**
	 * 菜单查询
	 * @param query
	 * @return
	 */
	public List<SysMenu> query() {
		return sysMenuDao.query();
	}
}
