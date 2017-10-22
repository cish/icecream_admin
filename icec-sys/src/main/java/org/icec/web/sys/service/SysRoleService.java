package org.icec.web.sys.service;

import org.icec.web.sys.dao.SysRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 角色管理
 * @author jinxx
 *
 */
@Service
public class SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
}
