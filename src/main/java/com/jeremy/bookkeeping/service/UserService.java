package com.jeremy.bookkeeping.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jeremy.bookkeeping.bean.User;

/**
 * @program: book-keeping
 * @description: user service
 * same like the repository implementation to implement the real methods by using @Service annotation
 * @author: Keyang Wang
 * @create: 2021-01-14 16:01
 **/
public interface UserService extends IService<User> {
    public Boolean login(User user);
}
