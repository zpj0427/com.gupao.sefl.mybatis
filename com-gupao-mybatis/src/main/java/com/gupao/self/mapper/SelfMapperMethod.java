package com.gupao.self.mapper;

import com.gupao.self.sqlsession.SelfSqlSession;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 自定义MapperMethod, 根据查询方式选择不同的策略
 * @author pj_zhang
 * @create 2019-03-31 12:00
 **/
public class SelfMapperMethod {

    private Method method;

    public SelfMapperMethod(Method method) {
        this.method = method;
    }

    public Object execute(SelfSqlSession sqlSession, Method method) {
        // 获取方法名称
        String methodName = this.method.getName();
        // 区分执行方式, 简易区分
        // 数据查询处理, 源码内部根据Statement标签进行了处理
        if (StringUtils.isNotEmpty(methodName) && methodName.startsWith("select")) {
            Class<?> returnClazz = this.method.getReturnType();
            // 返回List集合
            if (List.class.getName().equals(returnClazz.getName())) {
                // 调用SqlSession查询
                return sqlSession.selectList(method);
            }
        }
        return null;
    }
}
