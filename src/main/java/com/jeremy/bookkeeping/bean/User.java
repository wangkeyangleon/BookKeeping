package com.jeremy.bookkeeping.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



/**
 * @program: book-keeping
 * @description: user entity
 * @author: Keyang Wang
 * @create: 2021-01-13 14:38
 **/
@NoArgsConstructor
@Data
@ToString
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userAccount;
    private String userName;
    private String userEmail;
    private String userGender;
    private String userPassword;

    public User(String userAccount, String userName, String userEmail, String userGender, String userPassword) {
        this.userAccount = userAccount;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userPassword = userPassword;
    }
}
