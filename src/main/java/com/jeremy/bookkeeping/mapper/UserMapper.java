package com.jeremy.bookkeeping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeremy.bookkeeping.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//same like the repository it has many methods to manipulate the database by using @Mapper annotation
//we can write the SQL on the methods' top by using the annotations
//we can use @Mapper Scan annotation to reduce the @Mapper annotation

public interface UserMapper extends BaseMapper<User> {

    //find the user
    @Select("select u.id from user u where u.user_account = #{userAccount} and u.user_password = #{userPassword}")
    Integer login(User user);
}
