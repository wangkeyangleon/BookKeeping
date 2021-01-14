package com.jeremy.bookkeeping.bean;

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
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@TableName("user")
public class User {
    private Integer id;
    private String userAccount;
    private String userName;
    private String userEmail;
    private String userGender;
    private String userPassword;
}
