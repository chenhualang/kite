package com.zhong.kite.repo;

import com.zhong.kite.DO.UserDO;
import com.zhong.kite.mapper.UserDAO;
import com.zhong.kite.model.UserDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRepo {
    @Resource
    private UserDAO userDAO;

    public List<UserDTO> findAllUsers(){
         return userDAO.findAllUsers();
    }


    public int getUserCount(UserDTO userDTO) {
        return userDAO.getUserCount(userDTO);
    }

    public List<UserDO> getUserList(UserDTO userDTO){
        return userDAO.getUserList(userDTO);
    }

    public int delUser(int id) {
        return userDAO.delUser(id);
    }

    public int addUser(UserDO user){
        return userDAO.addUser(user);
    }

    public int updateUser(UserDO userDO) {
        return userDAO.updateUser(userDO);
    }
}
