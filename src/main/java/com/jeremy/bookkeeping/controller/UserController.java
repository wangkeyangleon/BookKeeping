package com.jeremy.bookkeeping.controller;

import com.jeremy.bookkeeping.bean.User;
import com.jeremy.bookkeeping.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: book-keeping
 * @description: user controller for login and registration
 * @author: Keyang Wang
 * @create: 2021-01-14 16:01
 **/
@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * login
     *
     * @return to the login page
     */
    @GetMapping(value = {"/login", "/"})
    public String loginPage() {
        return "login";
    }


    /**
     * post the user input to check login information
     *
     * @param user  get the usr information
     * @param model send the wrong message to the web page
     * @return
     */
    @PostMapping("/login")
    public String homePage(User user, Model model) {
        log.info("not change the password {}", user.toString());
        String result = null;
        //change the user password to sha-256
        if (user.getUserPassword() != null) {
            result = stringToHash(user.getUserPassword());
        }
        //update the user password
        user.setUserPassword(result);
        log.info("change the password:{}", user.toString());
        if (userService.login(user)) {
            return "redirect:/homepage.html";
        } else {
            model.addAttribute("message", "wrong password or user account!");
            return "login";
        }
    }

    /**
     * get the homepage
     *
     * @return
     */
    @GetMapping("/homepage.html")
    public String homepage() {
        return "homepage";
    }

    /**
     * get the registration page
     *
     * @return
     */
    @GetMapping("/register")
    public String registration() {
        return "registration";
    }

    /**
     * register an account
     * if the registration is successful return to the login page,maybe it should login immediately
     * if not successful return to registration page, but this should be changed in the future it should check whether the account
     * has been registered when they input, this should search and updated
     * @param userAccount
     * @param userName
     * @param userEmail
     * @param userGender
     * @param userPassword
     * @param passwordRepeat
     * @param model
     * @return
     */
    @PostMapping("/registration")
    public String register(String userAccount,
                           String userName,
                           String userEmail,
                           String userGender,
                           String userPassword,
                           String passwordRepeat,
                           Model model) {
        //check whether the passwords are same
        if (!userPassword.equals(passwordRepeat))
        {
            model.addAttribute("password","sorry the two passwords are not same, please check");
            return "registration";
        }else {
            String password = stringToHash(userPassword);
            User user = new User(userAccount,userName,userEmail,userGender,password);
            log.info("register information {}",user.toString());
            Boolean aBoolean = userService.registration(user);
            if (aBoolean=true){
                model.addAttribute("success","you successfully finished the registration");
                return "login";
            }else {
                model.addAttribute("failure","sorry the account has been used,please try again");
                return "registration";
            }

        }

    }

    /**
     * use SHA-256 to hash the user password
     * I do not know which class should have this method so just put it in the controller class
     *
     * @param input string password
     * @return hashed password
     */
    private String stringToHash(String input) {
        String result = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword;
            //get the code with byte types
            hashedPassword = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
            //change the byte to string types
            StringBuilder stringBuffer = new StringBuilder();
            for (byte b : hashedPassword) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(hex);
            }
            result = stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
}
