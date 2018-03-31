package com.zhong.kite.controller.web;

import com.zhong.kite.UserService;
import com.zhong.kite.model.User;
import com.zhong.kite.model.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all",method = RequestMethod.POST)
    public BaseResult<List<User>> findAllUsers(){
      return userService.findAllUsers();
    }
}
