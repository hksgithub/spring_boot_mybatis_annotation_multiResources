package com.springboot.multi_resources_mybaits.mapper.map1;

import com.springboot.multi_resources_mybaits.entity.User;
import com.springboot.multi_resources_mybaits.enums.AuthorityEnum;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Mapper
public interface UserMapper1 {

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
