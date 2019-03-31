package com.gupao.self.executor;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 缓存执行器
 * @author pj_zhang
 * @create 2019-03-31 11:36
 **/
public class SelfCachingExecutor implements SelfExecutor {

    private Map<String, List> cacheMap = new ConcurrentHashMap<>();

    private SelfExecutor delegete;

    public SelfCachingExecutor(SelfExecutor executor) {
        this.delegete = executor;
    }

    @Override
    public <T> List<T> execute(Method method) {
        // 拼接缓存key值, 作为SqlSesion级别缓存
        String cacheKey = method.getDeclaringClass().getName() + "." + method.getName();
        if (cacheMap.containsKey(cacheKey)) {
            return cacheMap.get(cacheKey);
        }
        List<T> lstData = delegete.execute(method);
        // 添加结果集到缓存中
        cacheMap.put(cacheKey, lstData);
        return lstData;
    }
}
