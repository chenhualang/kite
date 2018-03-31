package com.zhong.kite.repo;

import com.zhong.kite.mapper.UserDAO;
import com.zhong.kite.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRepo {
    @Resource
    private UserDAO userDAO;

    public List<User> findAllUsers(){
         return userDAO.findAllUsers();
    }


}
