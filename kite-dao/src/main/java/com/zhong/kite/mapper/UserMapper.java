package com.zhong.kite.mapper;

import com.zhong.kite.DO.UserDO;

public interface UserMapper {
    int deleteByPrimaryKey(Integer cuserid);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer cuserid);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);
}