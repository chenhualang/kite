package com.zhong.kite;

import com.zhong.kite.model.HaClaimCaseLevelDO;
import com.zhong.kite.model.User;
import com.zhong.kite.model.util.BaseResult;

import java.util.List;

public interface UserService {
    public BaseResult<List<User>> findAllUsers();
}
