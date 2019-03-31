package com.gupao.self.config;

/**
 * 全局配置信息构建类
 * @author pj_zhang
 * @create 2019-03-31 11:02
 **/
public class SelfConfigurationBuilder {

    /**
     * 构建有效的配置信息
     * @return
     */
    public static SelfConfiguration createConfiguration() {
        SelfConfiguration configuration = new SelfConfiguration();
        // 解析mapper
        resolveMapper(configuration);
        return configuration;
    }

    /**
     * 解析Mapper
     * @param configuration
     */
    private static void resolveMapper(SelfConfiguration configuration) {
        try {
            configuration.addMapper();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
