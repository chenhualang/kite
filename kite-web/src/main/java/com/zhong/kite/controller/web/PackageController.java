package com.zhong.kite.controller.web;

import com.zhong.kite.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/packages")
@RestController
public class PackageController {
    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/query",method = RequestMethod.POST)
//    public BaseResult<List<User>> findAllUsers(){
//      return userService.findAllUsers(pageNumber, pageSize);
//    }
}
