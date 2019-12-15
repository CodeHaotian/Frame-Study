package com.vue.mapper;

import com.vue.entity.Girl;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: Haotian
 * @Date: 2019/12/15 18:44
 * @Description: 数据接口
 */
public interface UserMapper {
    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Select("select * from girl limit 0,10")
    List<Girl> findAll();

    /**
     * 根据id查询用户
     *
     * @param id 用户id
     * @return 指定用户数据
     */
    @Select("select * from girl where id = #{id}")
    Girl findById(Integer id);

    /**
     * 更新用户数据
     *
     * @param girl 新用户数据
     */
    @Update("update girl set name=#{name},age=#{age},birthday=#{birthday},cup=#{cup},leg=#{leg},phone=#{phone},address=#{address},status=#{status} where id=#{id}")
    void update(Girl girl);
}
