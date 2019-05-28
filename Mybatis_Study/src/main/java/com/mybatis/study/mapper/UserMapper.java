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
     * 添加用户
     *
     * @param user
     * @return 受影响的行数
     * @Insert("INSERT INTO user (username,sex,birthday,address) VALUE (#{username},#{sex},#{birthday},#{address})")
     */
    int save(User user);

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     * @Select("SELECT * FROM user WHERE id = #{id}")
     */
    User findUserById(int id);

    /**
     * 使用对象模型查询
     *
     * @param vo
     * @return
     */
    List<User> findUserByUserQueryVo(UserQueryVO vo);

    /**
     * 使用map查询数据
     *
     * @param map
     * @return
     */
    List<User> findUserByMap(Map<String, Object> map);

    /**
     * 返回用户的个数
     *
     * @param vo
     * @return
     */
    int findUserCount(UserQueryVO vo);

    /**
     * 使用resultMap设置别名返回数据
     *
     * @param userId
     * @return
     */
    User findUserByIdResultMap(int userId);

    /**
     * 讲解mybatis的if和where使用
     *
     * @param vo
     * @return
     */
    List<User> findUserList(UserQueryVO vo);

    /**
     * 查找多个id的用户数据,对象方式
     *
     * @param vo
     * @return
     */
    List<User> findUserByIds(UserQueryVO vo);

    /**
     * 查找多个id的用户数据,数组方式
     *
     * @param ids
     * @return
     */
    List<User> findUserByIds2(List<Integer> ids);

    /**
     * 查询用户信息及用户购买的商品信息
     *
     * @return
     */
    List<User> findUserAndOrderInfo();
}
