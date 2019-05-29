package com.gupao.mapper;

import com.gupao.domain.UserVO;
import org.apache.ibatis.annotations.Param;

/**
 * @author pj_zhang
 * @create 2019-03-25 22:35
 **/
public interface UserMapper {

    UserVO selectUserById(@Param("id") Integer id);

    UserVO selectUserByName(@Param("id") Integer id);

}
