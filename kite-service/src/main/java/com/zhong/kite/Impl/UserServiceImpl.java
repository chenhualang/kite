package com.zhong.kite.Impl;

import com.zhong.kite.UserService;
import com.zhong.kite.model.HaClaimCaseLevelDO;
import com.zhong.kite.model.User;
import com.zhong.kite.model.enums.ErrorCodeEnum;
import com.zhong.kite.model.util.BaseResult;
import com.zhong.kite.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepo userRepo;

    public BaseResult<List<User>> findAllUsers(){
        BaseResult<List<User>> result = new BaseResult<>();
        List<User> users = userRepo.findAllUsers();
        result.setResult(users);
        return result;
    }
}
