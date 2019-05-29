package com.gupao.self.executor;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author pj_zhang
 * @create 2019-03-31 11:37
 **/
public interface SelfExecutor {

    /**
     * 初步执行
     * @param <T>
     * @return
     */
    <T> List<T> execute(Method method);

}
