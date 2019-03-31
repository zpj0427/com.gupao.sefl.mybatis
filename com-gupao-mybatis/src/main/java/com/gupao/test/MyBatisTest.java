package com.gupao.test;

import com.gupao.domain.UserVO;
import com.gupao.mapper.UserMapper;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author pj_zhang
 * @create 2019-03-25 22:39
 **/
@Log4j
public class MyBatisTest {

    public static void main(String[] args) throws IOException {
        // mybatis基础配置文件路径及文件名
        String resource = "mybatis-config.xml";
        // 获取配置文件输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 通过文件输入流进行XML文件解析, 添加配置信息到Configuration
        // Configuration.addMapper()通过调用
        // 直接返回DefaultSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // openSession, 获取DefaultSqlSession
        // 在内部生成Executor, 并同Configuration一同注入到DefaultSqlSession中
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 根据Mapper名称从SqlSession中获取Mapper代理对象
            // 内部通过Configuration.mapperRegistry.knownMappers调用链获取Mapper对象
            // 并通过动态代理获取该Mapper对象的代理对象, MapperProxy
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 通过动态代理invoke()调用
            // 底层通过Executor.query()执行SQL语句获取结果
            // ORM映射通过ResultSetHandler完成
            UserVO userVO = mapper.selectUserById(1);
            System.out.println(userVO);
        } catch (Exception e) {
           log.info(e);
        }
    }

}
