package com.jeremy.bookkeeping;

import com.jeremy.bookkeeping.bean.User;
import com.jeremy.bookkeeping.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class BookKeepingApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = userMapper.selectById(1);
        log.info("user{}",user.toString());
    }

}
