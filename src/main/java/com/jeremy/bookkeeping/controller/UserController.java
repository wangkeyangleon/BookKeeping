package com.jeremy.bookkeeping.controller;

import com.jeremy.bookkeeping.bean.User;
import com.jeremy.bookkeeping.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: book-keeping
 * @description: user controller
 * @author: Keyang Wang
 * @create: 2021-01-14 16:01
 **/
@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * registration
     *
     * @return return to the registration.html page
     */
    @GetMapping("/regist")
    public String registerUser() {
        return "registration";
    }

    /**
     * login
     *
     * @return to the login page
     */
    @GetMapping(value = {"/login", "/"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String homePage(User user,Model model){
        log.info("not change the password {}",user.toString());
        String result = null;
        //change the user password to sha-256
        if (user.getUserPassword() != null){
            try {
                //get the hash type
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte [] hashedPassword;
                // got the code with byte types
                hashedPassword = messageDigest.digest(user.getUserPassword().getBytes(StandardCharsets.UTF_8));
                //change the byte to String type
                StringBuffer strHexString = new StringBuffer();
                for (int i = 0; i <hashedPassword.length ; i++) {
                    String hex = Integer.toHexString(0xff & hashedPassword[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                result = strHexString.toString();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        //update the user password
        user.setUserPassword(result);
        log.info("change the password:{}",user.toString());
        if (userService.login(user)){
            return "redirect:/homepage.html";
        }else {
            model.addAttribute("message","wrong password or user account!");
            return "login";
        }
    }

    @GetMapping("/homepage.html")
    public String homepage(){
        return "homepage";
    }
}
