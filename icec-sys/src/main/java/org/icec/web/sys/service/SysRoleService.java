package org.icec.web.sys.service;

import java.util.Date;
import java.util.List;

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
	
	@Transactional
	public void update(SysRole role ,SysUser optuser){
		role.setUpdateBy(optuser.getId());
		role.setUpdateDate(new Date());
		sysRoleDao.updateTemplateById(role);
	}
	
	@Transactional
	public void deleteAll(String ids,SysUser optuser) {
		String [] idarr=ids.split(",");
		for(String id:idarr) {
			SysRole role=new SysRole();
			role.setId(Integer.parseInt(id));
			role.setUpdateBy(optuser.getId());
			role.setUpdateDate(new Date());
			role.setDelFlag(SysUser.DEL_FLAG_DELETE);
			sysRoleDao.updateTemplateById(role);
		}
		 
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
	/**
	 * 查询全部角色
	 * @return
	 */
	public List<SysRole> findAll(){
		SysRole role=new SysRole();
		role.setDelFlag(SysRole.DEL_FLAG_NORMAL);
		return sysRoleDao.template(role);
	}
	
	public List<SysRole> findRoleByUserId(Integer userId){
		return sysRoleDao.findRoleByUserId(userId);
	}
}
