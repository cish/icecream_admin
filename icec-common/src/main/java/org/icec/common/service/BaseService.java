package org.icec.common.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.db.KeyHolder;
import org.beetl.sql.core.engine.PageQuery;

public class BaseService<T> {
	private Class<T> modelClass;
	private SQLManager sqlManager;

	public BaseService() {
		super();
		if (modelClass == null)
			modelClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void insert(T entity) {
		sqlManager.insert(entity);
	}

	public void insert(T entity, boolean autDbAssignKey) {
		sqlManager.insert(entity, autDbAssignKey);
	}

	public void insertTemplate(T entity) {
		sqlManager.insertTemplate(entity);
	}

	public void insertTemplate(T entity, boolean autDbAssignKey) {
		sqlManager.insertTemplate(entity, autDbAssignKey);
	}

	public void insertBatch(List<T> list) {
		sqlManager.insertBatch(list);
	}

	public KeyHolder insertReturnKey(T entity) {
		return sqlManager.insertReturnKey(entity);
	}

	public int updateById(T entity) {
		return sqlManager.updateById(entity);
	}

	public int updateTemplateById(T entity) {
		return sqlManager.updateTemplateById(entity);
	}

	public int deleteById(Object key) {
		return sqlManager.deleteById(key);
	}

	public T unique(Object key) {
		return sqlManager.unique(key);
	}

	public T single(Object key) {
		return sqlManager.single(key);
	}

	public T lock(Object key) {
		return sqlManager.lock(key);
	}

	public List<T> all() {
		return sqlManager.all();
	}

	public List<T> all(int start, int size) {
		return sqlManager.all(start, size);
	}

	public long allCount() {
		return sqlManager.allCount();
	}

	public List<T> template(T entity) {
		return sqlManager.template(entity);
	}

	public <T> T templateOne(T entity) {
		return (T) sqlManager.templateOne(entity);
	}

	public List<T> template(T entity, int start, int size) {
		return sqlManager.template(entity, start, size);
	}

	public void templatePage(PageQuery<T> query) {
		sqlManager.templatePage(query);
	}

	public long templateCount(T entity) {
		return sqlManager.templateCount(entity);
	}

	public List<T> execute(String sql, Object... args) {
		return sqlManager.execute(sql, args);
	}

	public int executeUpdate(String sql, Object... args) {
		return sqlManager.executeUpdate(sql, args);
	}

}
