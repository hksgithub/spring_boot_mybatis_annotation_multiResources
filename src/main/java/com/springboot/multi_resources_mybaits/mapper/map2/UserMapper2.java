package com.springboot.multi_resources_mybaits.mapper.map2;

import com.springboot.multi_resources_mybaits.entity.User;
import com.springboot.multi_resources_mybaits.enums.AuthorityEnum;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface UserMapper2 {
    //如果没有返回结果则不需要加Result解析，在Sql语句中必须使用标准的语句，想userName是允许的
//    @Results({
//            @Result(property = "userName",column = "user_name"),
//            @Result(property = "authority",column = "authority",javaType = AuthorityEnum.class)
//    })

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Insert("INSERT INTO user(id,username,password) VALUES(#{id},#{username},#{password})")
    void addOne(User user);

    @Select("SELECT * FROM user WHERE id=#{id}")
    User findOne(String id);

    @Update("UPDATE user SET username = #{username},password = #{password} WHERE id = #{id}")
    void updateOne(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void delOne(String id);
}
