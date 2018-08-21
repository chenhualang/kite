package com.zhong.kite;

import com.zhong.kite.DO.UserDO;
import com.zhong.kite.model.UserDTO;
import com.zhong.kite.model.util.BaseResult;

import java.util.Map;

public interface UserService {
    public Map<String,Object> getUserList(UserDTO userDTO);

    int delUsers(int[] ids);

    int addUser(UserDO user);

    int updateUser(UserDO userDO);

    int delUser(int id);
}
