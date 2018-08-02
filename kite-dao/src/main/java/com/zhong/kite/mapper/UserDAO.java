package com.zhong.kite.mapper;

import com.zhong.kite.DO.UserDO;
import com.zhong.kite.model.UserDTO;

import java.util.List;

public interface UserDAO {
    int deleteByPrimaryKey(Integer cuserid);

    int insert(UserDTO record);

    int insertSelective(UserDTO record);

    UserDTO selectByPrimaryKey(Integer cuserid);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);

    List<UserDTO> findAllUsers();

    int getUserCount(UserDTO record);

    List<UserDO> getUserList(UserDTO record);

    int delUser(int id);

    int addUser(UserDO user);

    int updateUser(UserDO userDO);
}