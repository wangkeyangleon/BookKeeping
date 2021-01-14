package com.jeremy.bookkeeping.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeremy.bookkeeping.bean.User;
import com.jeremy.bookkeeping.mapper.UserMapper;
import com.jeremy.bookkeeping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: book-keeping
 * @description: implement userService interface
 * @author: Keyang Wang
 * @create: 2021-01-14 17:03
 **/

@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Boolean login(User user) {
        Integer id = userMapper.login(user);
        if (id ==null){
            return false;
        }else {
            return true;
        }
    }
}
