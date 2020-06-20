package com.dgut.mvc.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DAOjdbc<T> implements DAO<T> {
    private Class<T>type;
    private QueryRunner queryRunner;
    public DAOjdbc()
    {
        type=getSuperClassGenricType(getClass(),0);
        queryRunner=new QueryRunner();
    }
    public T fetch(Connection connection,String sql,Object ...params) throws SQLException
    {
        BeanHandler<T> beanHandler=new BeanHandler<T>(type);
        return queryRunner.query(connection,sql,beanHandler,params);
    }
    public List<T> fetchList(Connection connection,String sql,Object...params)throws SQLException
    {
        BeanListHandler<T> beanListHandler=new BeanListHandler<T>(type);
        return queryRunner.query(connection,sql,params,beanListHandler);
    }
    public void upadate(Connection connection,String sql,Object ...params)throws SQLException
    {
        queryRunner.update(connection,sql,params);
    }
    public <E> E fetchScaler(Connection connection, String sql, Object... objects) throws SQLException {
        ScalarHandler<E> rsh = new ScalarHandler<E>();
        return (E)queryRunner.query(connection, sql, rsh, objects);
    }

    private Class getSuperClassGenricType(Class clazz, int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
