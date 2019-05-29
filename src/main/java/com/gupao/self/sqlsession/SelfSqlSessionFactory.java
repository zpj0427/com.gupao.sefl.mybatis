package com.gupao.self.sqlsession;

/**
 * 自定义SqlSessionFactory工厂接口,
 * @author pj_zhang
 * @create 2019-03-31 10:57
 **/
public interface SelfSqlSessionFactory {

    /**
     * 获取SqlSession
     * @return
     */
    SelfSqlSession openSession();

}
