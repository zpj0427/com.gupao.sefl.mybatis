package com.gupao.test;

import java.sql.*;

/**
 * @author pj_zhang
 * @create 2019-03-31 10:47
 **/
public class Test {

    public static void main(String[] args) throws Exception {
        String URL="jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8";
        String USER="root";
        String PASSWORD="123456";
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库链接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        PreparedStatement st=conn.prepareStatement("select username as name, password as word, delete_flag as deleteFlag from user_t");
        ResultSet rs = st.executeQuery();
        //4.处理数据库的返回结果(使用ResultSet类)
        while(rs.next()){
            System.out.println(rs.getString("name")+" "
                    +rs.getString("word"));
        }

        //关闭资源
        rs.close();
        st.close();
        conn.close();
    }

}
