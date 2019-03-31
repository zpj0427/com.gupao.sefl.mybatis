package com.gupao.self.sqlsession;

import com.gupao.self.config.SelfConfiguration;
import com.gupao.self.executor.SelfCachingExecutor;
import com.gupao.self.executor.SelfExecutor;
import com.gupao.self.executor.SelfSimpleExecutor;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

/**
 * @author pj_zhang
 * @create 2019-03-31 11:00
 **/
public class SelfDefaultSqlSessionFactory implements SelfSqlSessionFactory {

    private SelfConfiguration configuration;

    public SelfDefaultSqlSessionFactory(SelfConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    // SelfDefaultSqlSessionFactory.openSession
    public SelfSqlSession openSession() {
        // 获取执行器, executor
        SelfExecutor executor = createExecutor();
        return new SelfDefaultSqlSession(configuration, executor);
    }

    private SelfExecutor createExecutor() {
        SelfExecutor executor = new SelfSimpleExecutor();
        executor = new SelfCachingExecutor(executor);
        return executor;
    }
}
