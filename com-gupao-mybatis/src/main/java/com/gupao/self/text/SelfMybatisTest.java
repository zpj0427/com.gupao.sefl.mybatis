package com.gupao.self.text;

import com.gupao.self.pojo.UserVO;
import com.gupao.self.sqlsession.SelfSqlSession;
import com.gupao.self.sqlsession.SelfSqlSessionFactory;
import com.gupao.self.sqlsession.SelfSqlSessionFactoryBuilder;

import java.util.List;

/**
 * @author pj_zhang
 * @create 2019-03-31 11:31
 **/
public class SelfMybatisTest {

    public static void main(String[] args) {
        // 获取sqlSessionFactory
        SelfSqlSessionFactory sqlSessionFactory = new SelfSqlSessionFactoryBuilder().build();
        // 获取sqlSession
        SelfSqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        // 执行Statement
        List<UserVO> lstData = mapper.selectData();
        // 输出结果
        System.out.println(lstData);
    }

}
