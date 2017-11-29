package org.icec.web.sys.dao;

import java.util.List;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.icec.web.sys.model.SysRole;

public interface SysRoleDao extends BaseMapper<SysRole>{
	public SysRole findById(@Param("id")Integer id);
	public PageQuery<SysRole> queryRole(PageQuery<SysRole> query);
	
	/**
	 * 添加用户角色关系表
	 * @param userId
	 * @param roleId
	 */
	public void insertUserRole(@Param("userId")Integer userId,@Param("roleId")Integer roleId);
	/**
	 * 根据用户删除角色
	 * @param userId
	 */
	public void deleteUserRoleByUserId(@Param("userId")Integer userId);
	/**
	 * 根据用户角色删除
	 * @param userId
	 * @param roleId
	 */
	public void deleteUserRoleByUserIdAndRoleId(@Param("userId")Integer userId,@Param("roleId")Integer roleId);
	
	/**
	 * 根据用户查找角色
	 * @param userId
	 * @return
	 */
	public List<SysRole> findRoleByUserId(@Param("userId")Integer userId);
}
