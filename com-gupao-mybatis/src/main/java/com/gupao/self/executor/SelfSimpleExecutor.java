package com.gupao.self.executor;

import com.gupao.self.mapper.SelfMapperRegister;
import com.gupao.self.pojo.UserVO;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 标准执行器
 * @author pj_zhang
 * @create 2019-03-31 11:36
 **/
public class SelfSimpleExecutor implements SelfExecutor {
    @Override
    public <T> List<T> execute(Method method) {
        List<UserVO> lstData = new ArrayList<>();
        try {
            // 获取数据库连接
            Connection connection = getConnection();
            // 连接数据库查询数据
            if (method.getDeclaringClass().getName().equals(SelfMapperRegister.SelfMapperMap.NAME_SPACE)) {
                String sql = SelfMapperRegister.SelfMapperMap.statement2Sql.get(method.getName());
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                // 进行ORM映射
                while (resultSet.next()) {
                    UserVO userVO = new UserVO();
                    // 数据库元数据
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnCount; i++) {
                        // 映射到VO的属性名
                        String attrName = metaData.getColumnLabel(i);
                        // 数据类型
                        String className = metaData.getColumnClassName(i);
                        // 获取数据值
                        Object value = findValue(attrName, className, resultSet);
                        // 使用BeanUtils填充
                        BeanUtils.setProperty(userVO, attrName, value);
                    }
                    lstData.add(userVO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (List<T>) lstData;
    }

    private Object findValue(String attrName, String className, ResultSet resultSet) {
        // 此处需要根据className, 对每一种情况进行识别,
        if (String.class.getName().equals(className)) {
            try {
                return resultSet.getString(attrName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            String URL="jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8";
            String USER="root";
            String PASSWORD="123456";
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库链接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
