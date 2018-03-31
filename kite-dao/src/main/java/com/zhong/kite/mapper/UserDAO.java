package com.zhong.kite.mapper;

import com.zhong.kite.model.User;

import java.util.List;

public interface UserDAO {
    int deleteByPrimaryKey(Integer cuserid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer cuserid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAllUsers();
}