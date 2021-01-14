package com.jeremy.bookkeeping.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeremy.bookkeeping.bean.User;
import com.jeremy.bookkeeping.mapper.UserMapper;
import com.jeremy.bookkeeping.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @program: book-keeping
 * @description: implement userService interface
 * @author: Keyang Wang
 * @create: 2021-01-14 17:03
 **/

@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
}
