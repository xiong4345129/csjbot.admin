package com.csjbot.admin.data;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionTemplate;

import com.csjbot.admin.page.Page;
import com.csjbot.admin.page.PageContainer;
import com.csjbot.admin.util.SqlHelper;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;

public class SqlSessionDaoSupport implements DaoSupport {
    
	private SqlSessionTemplate sqlSession;

	public SqlSessionDaoSupport(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
   
	public int insert(String statement, Object parameter) {
		return sqlSession.insert(statement, parameter);
	}

	public int update(String statement, Object parameter) {
		return sqlSession.update(statement, parameter);
	}

	public <K, V, T> T get(String statement, Map<K, V> parameter) {
		return sqlSession.selectOne(statement, parameter);
	}

	@Override
	public <K, V> Map<K, V> findOne(String statement, Map<K, V> parameter) {
		return sqlSession.selectOne(statement, parameter);
	}

	@Override
	public <K, V> int delete(String statement, Map<K, V> parameter) {
		return sqlSession.delete(statement, parameter);
	}

	@Override
	public <E, K, V> List<E> find(String statement, Map<K, V> parameter) {
		return sqlSession.selectList(statement, parameter);
	}

	@Override
	public <E> List<E> find(String statement) {
		return sqlSession.selectList(statement);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E, K, V> Page<E> page(String pageStatement, Map<K, V> parameter, int current, int pagesize) {
		PageBounds pageBounds = new PageBounds(current, pagesize);
		PageList<E> result = (PageList<E>) sqlSession.selectList(pageStatement, parameter, pageBounds);
		Paginator paginator = result.getPaginator();
		return new PageContainer<E, K, V>(paginator.getTotalCount(), paginator.getLimit(), paginator.getPage(), result, parameter);
	}
	
	@SuppressWarnings("unchecked")
    @Override
	public <E, K, V> Page<E> pageAndSort(String pageStatement, Map<K, V> parameter, int current, int pagesize, String sortString){
    	PageBounds pageBounds = new PageBounds(current, pagesize);
    	if (sortString != null && !"".equals(sortString)) {
    	    pageBounds.setOrders( Order.formString(sortString));
    	}
        PageList<E> result = (PageList<E>) sqlSession.selectList(pageStatement, parameter, pageBounds);
        Paginator paginator = result.getPaginator();
        return new PageContainer<E, K, V>(paginator.getTotalCount(), paginator.getLimit(), paginator.getPage(), result, parameter);
    }

	@Override
	public Connection getConnection() {
		return sqlSession.getConnection();
	}

	@Override
	public Configuration getConfiguration() {
		return sqlSession.getConfiguration();
	}

	@Override
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSession;
	}
	
    public String getMapperSql(String methodName, Object... args){
    	return SqlHelper.getMapperSql(sqlSession, methodName , args);
    }

	@Override
	public String getNamespaceSql(String method) {
		return SqlHelper.getNamespaceSql(sqlSession, method);
	}

	@Override
	public String getBeanSql(String method, Object arg) {
		return SqlHelper.getBeanSql(sqlSession, method, arg);
	}

	
}
