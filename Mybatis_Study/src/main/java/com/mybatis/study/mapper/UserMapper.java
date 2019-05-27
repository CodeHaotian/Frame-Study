package com.mybatis.study.mapper;

import com.mybatis.study.model.User;
import com.mybatis.study.vo.UserQueryVO;

import java.util.List;
import java.util.Map;

/**
 * @Author：Haotian
 * @Date：2019/5/27 20:54
 */
public interface UserMapper {
    /**
     * @param user 添加用户
     * @return 受影响的行数
     * @Insert("INSERT INTO user (username,sex,birthday,address) VALUE (#{username},#{sex},#{birthday},#{address})")
     */
    int save(User user);

    /**
     * @param id 根据id查找用户
     * @return
     * @Select("SELECT * FROM user WHERE id = #{id}")
     */
    User findUserById(int id);

    /**
     * @param vo 使用对象模型查询
     * @return
     */
    List<User> findUserByUserQueryVo(UserQueryVO vo);

    /**
     * @param map 使用map查询数据
     * @return
     */
    List<User> findUserByMap(Map<String, Object> map);
}
