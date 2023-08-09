package com.example.dbDemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getById")
    public ResponseEntity getUserById(@RequestParam("id")Integer id){
        try{
            UserInfo userInfo=userService.getUserById(id);
            return new ResponseEntity(userInfo, HttpStatus.OK);
        }catch (Exception e){
            log.error("this is an error and "+e.getMessage());
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add")
    public String addUserInfo(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }
    @DeleteMapping("/deleteById")
    public String deleteById(@RequestParam("id")Integer id){
        return userService.deleteUserById(id);
    }
    @PutMapping("/updateUser")
    public String updateUser(@RequestParam("id")Integer id, @RequestParam("email")String email){
        try{
            String msg=userService.updateEmail(id,email);
            return msg;
        }catch(Exception e){
            log.error("this is an error and "+e.getMessage());
            return e.getMessage();
        }
    }
    @GetMapping("/findUsersAboveAge")
    public List<UserInfo> getUserInfoList(@RequestParam("age")Integer age){
        return userService.getUsersAboveAge(age);
    }
}
