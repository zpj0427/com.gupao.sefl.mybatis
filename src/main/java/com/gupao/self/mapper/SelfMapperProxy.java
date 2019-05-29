package com.gupao.self.mapper;

import com.gupao.self.sqlsession.SelfSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author pj_zhang
 * @create 2019-03-31 11:21
 **/
public class SelfMapperProxy implements InvocationHandler {

    private SelfSqlSession sqlSession;

    public SelfMapperProxy(SelfSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 基层自Object类的方法执行
        if (Object.class.equals(method.getDeclaringClass().getClass())) {
            return method.invoke(this, args);
        }
        SelfMapperMethod mapperMethod = createMapperMethod(method);
        return mapperMethod.execute(sqlSession, method);
    }

    private SelfMapperMethod createMapperMethod(Method method) {
        return new SelfMapperMethod(method);
    }
}
