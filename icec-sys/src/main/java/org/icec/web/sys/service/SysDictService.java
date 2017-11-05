package org.icec.web.sys.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.icec.web.sys.model.SysDict;
import org.icec.web.sys.model.SysUser;

import java.util.Date;
import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.icec.web.sys.dao.SysDictDao;

/*
* 
* gen by icec  2017-11-05
*/
@Service
public class SysDictService   {
	@Autowired
	private SysDictDao  sysDictDao ;
	
	/**
	*
	*保存
	*/
	@Transactional
	public void save(SysDict sysDict,SysUser optUser){
		sysDict.setCreateBy(optUser.getId());
		sysDict.setCreateDate(new Date());
		sysDict.setUpdateBy(optUser.getId());
		sysDict.setUpdateDate(new Date());
		sysDictDao.insertTemplate(sysDict);
	}
	
	public PageQuery<SysDict> queryDict(PageQuery<SysDict> query) {
		return sysDictDao.queryDict(query);
	}
	/**
	 * 查询字典项
	 * @param typeId
	 * @return
	 */
	public List<SysDict> getDictValue(Integer typeId){
		SysDict dict=new SysDict();
		dict.setDelFlag(SysDict.DEL_FLAG_NORMAL);
		dict.setParentId(typeId);
		return sysDictDao.template(dict);
	}
}
