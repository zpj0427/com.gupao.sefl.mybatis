package com.gupao.self.text;

import com.gupao.self.pojo.UserVO;

import java.util.List;

/**
 * @author pj_zhang
 * @create 2019-03-31 11:10
 **/
public interface TestMapper {

    /**
     * 查询结果集
     * @return
     */
    List<UserVO> selectData();

}
