package org.icec.web.sys.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.icec.web.sys.model.SysArea;
import org.icec.web.sys.model.SysUser;

import java.util.Date;
import java.util.List;

import org.icec.common.utils.TreeBuild;
import org.icec.web.sys.dao.SysAreaDao;

/*
* 
* gen by icec  2017-10-27
*/
@Service
public class SysAreaService   {
	@Autowired
	private SysAreaDao  sysAreaDao ;
	
	/**
	*
	*保存
	*/
	@Transactional
	public void save(SysArea sysArea,SysUser user){
		if(StringUtils.isEmpty(sysArea.getParentId())) {
			sysArea.setParentId(0);
			sysArea.setParentIds("0,");
		}else {
			SysArea pArea=sysAreaDao.single(sysArea.getParentId());
			sysArea.setParentIds(pArea.getParentIds()+pArea.getId()+",");
		}
		sysArea.setCreateBy(user.getId());
		sysArea.setCreateDate(new Date());
		sysArea.setDelFlag(SysArea.DEL_FLAG_NORMAL);
		sysArea.setUpdateBy(user.getId());
		sysArea.setUpdateDate(new Date());
		sysAreaDao.insert(sysArea);
	}
	
	/**
	 * 根据主键id查询
	 * @param id
	 * @return
	 */
	public SysArea findById(Integer id) {
		return sysAreaDao.single(id);
	}
	
	public List<SysArea> query(){
		
		return (List<SysArea>) TreeBuild.buildByRecursive(sysAreaDao.query());
	}
}
