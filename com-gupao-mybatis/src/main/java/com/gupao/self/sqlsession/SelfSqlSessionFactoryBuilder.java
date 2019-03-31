package com.gupao.self.sqlsession;

import com.gupao.self.config.SelfConfiguration;
import com.gupao.self.config.SelfConfigurationBuilder;

/**
 * 自定义SelfSqlSessionFactoryBuilder, 用来构造SqlSessionFactory
 * @author pj_zhang
 * @create 2019-03-31 10:57
 **/
public class SelfSqlSessionFactoryBuilder {

    public SelfSqlSessionFactory build() {
        // 初始化配置信息, 生成全局配置文件
        SelfConfiguration configuration = SelfConfigurationBuilder.createConfiguration();
        return new SelfDefaultSqlSessionFactory(configuration);
    }

}
