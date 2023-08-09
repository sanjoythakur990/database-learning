package com.example.dbDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.*;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String addUser(UserInfo userInfo){
        userRepository.save(userInfo);
        return "User has been added to the Db successfully.";
    }
    public UserInfo getUserById(Integer userId) throws Exception{
        Optional<UserInfo> optionalUserInfo=userRepository.findById(userId);
        if(!optionalUserInfo.isPresent())
            throw new Exception("user with this id is not present");
        UserInfo userInfo=optionalUserInfo.get();
        return userInfo;
    }
    public String deleteUserById(Integer id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User with id is deleted.";
        }
        else {
            return "userId is not valid.";
        }
    }
    public String updateEmail(Integer userId, String newEmail) throws Exception{
        Optional<UserInfo> optionalUserInfo=userRepository.findById(userId);
        if(!optionalUserInfo.isPresent())
            throw new Exception("user with this id is not present");
        UserInfo userInfo=optionalUserInfo.get();
        userInfo.setEmail(newEmail);
        userRepository.save(userInfo);
        return "Email updated successfully.";
    }
    public List<UserInfo> getUsersAboveAge(Integer age){
        List<UserInfo> allUsers=userRepository.findAll();
        List<UserInfo> ansList=new ArrayList<>();
        for(UserInfo userInfo:allUsers){
            if(userInfo.getAge()>age)
                ansList.add(userInfo);
        }
        return ansList;
    }
}
