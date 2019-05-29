package com.gupao.self.sqlsession;

import com.gupao.self.config.SelfConfiguration;
import com.gupao.self.executor.SelfExecutor;

import java.lang.reflect.Method;

/**
 * 默认的SqlSession
 * @author pj_zhang
 * @create 2019-03-31 11:04
 **/
public class SelfDefaultSqlSession implements SelfSqlSession {

    private SelfConfiguration configuration;

    private SelfExecutor executor;

    public SelfDefaultSqlSession(SelfConfiguration configuration, SelfExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    // SelfDefaultSqlSession.getMapper
    public <T> T getMapper(Class<?> clazz) {
        return configuration.getMapper(clazz, this);
    }

    @Override
    // SelfDefaultSqlSession.selectList
    public Object selectList(Method method) {
        // 通过Executor执行器获取结果集
        return executor.execute(method);
    }
}
