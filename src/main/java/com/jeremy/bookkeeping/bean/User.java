package com.jeremy.bookkeeping.bean;

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
public class User {
    private Long user_id;
    private String user_account;
    private String user_name;
    private String user_email;
    private String user_gender;
    private String user_password;
}
