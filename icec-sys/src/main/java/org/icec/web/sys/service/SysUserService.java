package org.icec.web.sys.service;


import org.beetl.sql.core.engine.PageQuery;
import org.icec.common.utils.CryptoUtils;
import org.icec.web.sys.dao.SysUserDao;
import org.icec.web.sys.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.StringUtils;

@Service
public class SysUserService {
	@Autowired
	private SysUserDao userDao;
	/**
	 * 新增用户
	 * @param user
	 */
	@Transactional
	public void save(SysUser user) {
		/**
		 * 密码加密
		 */
		user.setPassword(CryptoUtils.bcrypt(user.getPassword()));
		user.setDelFlag(SysUser.DEL_FLAG_NORMAL);
		userDao.insert(user);
	}
	
	/**
	 * 用户更新
	 * @param user
	 */
	@Transactional
	public void update(SysUser user) {
		userDao.updateTemplateById(user);
	}
	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	public SysUser findById(Long id) {

		return userDao.single(id);
	}

	public PageQuery<SysUser> queryUser(PageQuery<SysUser> query) {
		return userDao.queryUser(query);
	}

	/**
	 * 根据登录名查询
	 * @param loginName
	 * @return
	 */
	public SysUser findByUserId(String loginName) {
		if(StringUtils.isNullOrEmpty(loginName)) {
			//不允许为空
			return null;
		}
		SysUser user=new SysUser();
		user.setLoginName(loginName);
		user.setLoginFlag(SysUser.LOGIN_FLAG_NORMAL);
		user.setDelFlag(SysUser.DEL_FLAG_NORMAL);
		return userDao.templateOne(user);
	}

}
