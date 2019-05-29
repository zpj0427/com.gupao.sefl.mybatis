package com.gupao.self.mapper;

import com.gupao.self.sqlsession.SelfSqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义Mapper注册类
 * @author pj_zhang
 * @create 2019-03-31 11:08
 **/
public class SelfMapperRegister {

    private Map<Class<?>, SelfMapperProxyFactory<?>>  knowsMapper = new ConcurrentHashMap<>();

    // 添加mapper
    // SelfMapperRegister.addMapper
    public void addMapper() throws ClassNotFoundException {
        knowsMapper.put(Class.forName(SelfMapperMap.NAME_SPACE), new SelfMapperProxyFactory(Class.forName(SelfMapperMap.NAME_SPACE)));
    }

    // 获取mapper, 通过
    // SelfMapperRegister.getMapper
    public <T> T getMapper(Class<?> clazz, SelfSqlSession sqlSession) {
        SelfMapperProxyFactory selfMapperProxyFactory = knowsMapper.get(clazz);
        if (null == selfMapperProxyFactory) {
            throw new RuntimeException("the execute mapper is not exists");
        }
        return (T) selfMapperProxyFactory.newInstace(sqlSession);
    }

    public static class SelfMapperMap {
        public static final String NAME_SPACE = "com.gupao.self.text.TestMapper";

        public static final Map<String, String> statement2Sql = new ConcurrentHashMap<>();

        static {
            statement2Sql.put("selectData", "select username as name, password as word from user_t");
        }

    }

}
