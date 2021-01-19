package com.jeremy.bookkeeping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jeremy.bookkeeping.bean.User;
import org.apache.ibatis.annotations.*;

//same like the repository it has many methods to manipulate the database by using @Mapper annotation
//we can write the SQL on the methods' top by using the annotations
//we can use @Mapper Scan annotation to reduce the @Mapper annotation

public interface UserMapper extends BaseMapper<User> {

    /**
     * this method to login
     *
     * @param user
     * @return
     */
    //find the user
    @Select("select u.id from user u where u.user_account = #{userAccount} and u.user_password = #{userPassword}")
    Integer login(User user);

    /**
     * registration to insert the user information
     *
     * @param user
     */
    @Insert("insert into user values(#{id},#{userAccount},#{userName},#{userEmail},#{userGender},#{userPassword})")
    //use this annotation can check the object's key after save the object
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void register(User user);

    /**
     * find whether the user account is same with the db's account if the account is same it can not be registration
     * "@param(value )" if the value equals the parameter can omit this annotation
     * "@Result" if the column's name equals the property name can omit this annotation
     * @param userAccount
     * @return
     */
    @Select(value = "select u.user_account,u.user_password from user u where u.user_account = #{userAccount}")
    @Results({@Result(property = "userAccount", column = "user_account"),
            @Result(property = "userPassword", column = "user_password")})
    User findUserByAccount(@Param("userAccount") String userAccount);
}
