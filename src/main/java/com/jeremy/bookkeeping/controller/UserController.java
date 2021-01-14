package com.jeremy.bookkeeping.controller;

import com.jeremy.bookkeeping.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: book-keeping
 * @description: user controller
 * @author: Keyang Wang
 * @create: 2021-01-14 16:01
 **/

@RestController
public class UserController {

    /**
     * registration
     *
     * @param user
     * @return return to the registration.html page
     */
    @PostMapping("/regist")
    public String registerUser(User user) {
        return "registration";
    }

    /**
     * login
     *
     * @return to the login page
     */
    @GetMapping({"/login","/"})
    public String loginPage() {
        return "login";
    }
}
