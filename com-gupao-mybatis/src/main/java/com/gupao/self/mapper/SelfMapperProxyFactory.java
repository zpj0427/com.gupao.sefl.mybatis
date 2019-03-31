package com.gupao.self.mapper;

import com.gupao.self.sqlsession.SelfSqlSession;

import java.lang.reflect.Proxy;

/**
 * @author pj_zhang
 * @create 2019-03-31 11:12
 **/
public class SelfMapperProxyFactory<T> {

    private Class<?> clazz;

    public SelfMapperProxyFactory(Class<?> clazz) {
        this.clazz = clazz;
    }

    public <T> T newInstace(SelfSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] {clazz}, new SelfMapperProxy(sqlSession));
    }
}
