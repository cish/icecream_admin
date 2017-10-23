package org.icec.web.sys.service;

import java.util.Date;

import org.beetl.sql.core.engine.PageQuery;
import org.icec.web.sys.dao.SysRoleDao;
import org.icec.web.sys.model.SysRole;
import org.icec.web.sys.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色管理
 * @author jinxx
 *
 */
@Service
public class SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	@Transactional
	public void save(SysRole role ,SysUser optuser) {
		role.setCreateBy(optuser.getId());
		role.setCreateDate(new Date());
		role.setUpdateBy(optuser.getId());
		role.setUpdateDate(new Date());
		role.setDelFlag("0");
		sysRoleDao.insert(role);
	}
	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	public SysRole findById(Integer id) {
		return sysRoleDao.single(id);
	}
	public PageQuery<SysRole> queryRole(PageQuery<SysRole> query) {
		return sysRoleDao.queryRole(query);
	}
}
