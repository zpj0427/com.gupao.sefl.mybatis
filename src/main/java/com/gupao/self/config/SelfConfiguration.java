package com.gupao.self.config;

import com.gupao.self.mapper.SelfMapperRegister;
import com.gupao.self.sqlsession.SelfSqlSession;

/**
 * @author pj_zhang
 * @create 2019-03-31 11:01
 **/
public class SelfConfiguration {

    private SelfMapperRegister selfMapperRegister = new SelfMapperRegister();

    // 添加mapper
    // SelfConfiguration.addMapper
    public void addMapper() throws ClassNotFoundException {
        selfMapperRegister.addMapper();
    }

    // 获取mapper
    // SelfConfiguration.getMapper
    public <T> T getMapper(Class<?> clazz, SelfSqlSession sqlSession) {
        return selfMapperRegister.getMapper(clazz, sqlSession);
    }

}
