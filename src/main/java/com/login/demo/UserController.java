package com.login.demo;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired UserRepository userRepository;

    @Autowired CustomerRepository customerRepository;

    @GetMapping("/getUserList")
    public List<Customer> getUserList(){
        return customerRepository.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        List<User> list =userRepository.findByUsername(username);
        String json;
        if(!list.isEmpty()){
            if(userRepository.findByUsernameAndPassword(username,password).isEmpty()){
                json  = JSON.toJSONString(LoginCode.PASSWORD_NOTFOUND.toString());
            }else{
                json = JSON.toJSONString(LoginCode.LOGIN_SUCCESS.toString());
            }
        }else{
            json = JSON.toJSONString(LoginCode.USERNAME_NOTFOUND.toString());
        }
        return json;
    }

    @PostMapping("/changePass")
    public String changePass(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("newPassword") String newPassword){
        List<User> list = userRepository.findByUsername(username);
        String json;
        if(!list.isEmpty()){
            if(userRepository.findByUsernameAndPassword(username,password).isEmpty()){
                json  = JSON.toJSONString(LoginCode.PASSWORD_NOTFOUND.toString());
            }else{
                json = JSON.toJSONString(LoginCode.PASSWORD_CHANGE_SUCCESS.toString());
            }
        }else{
            json = JSON.toJSONString(LoginCode.USERNAME_NOTFOUND.toString());
        }
        return json;
    }
}
