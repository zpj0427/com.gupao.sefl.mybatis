package com.gupao.self.sqlsession;

import java.lang.reflect.Method;

/**
 *自定义SqlSession接口
 * @author pj_zhang
 * @create 2019-03-31 10:58
 **/
public interface SelfSqlSession {

    /**
     * 获取执行Mapper
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<?> clazz);

    /**
     * 获取结果集
     * @return
     * @param method
     */
    Object selectList(Method method);
}
