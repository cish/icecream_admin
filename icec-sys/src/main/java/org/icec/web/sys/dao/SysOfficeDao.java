package org.icec.web.sys.dao;
import java.util.List;

import org.beetl.sql.core.annotatoin.*;
import org.beetl.sql.core.db.KeyHolder;
import org.beetl.sql.core.engine.PageQuery;
import org.beetl.sql.core.mapper.BaseMapper;
import org.icec.web.sys.model.*;

/*
* 
* gen by beetlsql mapper 2017-10-24
*/
public interface SysOfficeDao extends BaseMapper<SysOffice> {
	public SysOffice findById(@Param("id") Integer id);
	public List<SysOffice> query();
	/**
	 * 根据parentIds 查询区域
	 * @param parentIds
	 * @return
	 */
	public List<SysOffice> findByParentIdsLike(@Param("parentIds") String parentIds);
}
