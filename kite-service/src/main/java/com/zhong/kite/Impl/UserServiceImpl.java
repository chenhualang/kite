package com.zhong.kite.Impl;

import com.zhong.kite.DO.UserDO;
import com.zhong.kite.UserService;
import com.zhong.kite.model.UserDTO;
import com.zhong.kite.model.util.BaseResult;
import com.zhong.kite.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepo userRepo;

    public Map<String,Object> getUserList(UserDTO user){
//        BaseResult<List<User>> result = new BaseResult<>();
//        List<User> users = userRepo.findAllUsers();
//        result.setResult(users);
//        return result;

        Map<String,Object>map=new HashMap<String, Object>();
        int count = userRepo.getUserCount(user);
        int offset = (user.getPageNo() - 1) * user.getPageSize();
        user.setOffset(offset);
        List<UserDO>ulist=userRepo.getUserList(user);
        map.put("total", count);
        map.put("rows", ulist);
        return map;
    }

    @Override
    public int delUsers(int[] ids) {
        int sum=0;
        int y=0;
        for(int i=0;i<ids.length;i++){
                int x=userRepo.delUser(ids[i]);
                sum+=x;
        }
        if(sum==ids.length){
            y=1;
        }
        return y;
    }

    @Override
    public int addUser(UserDO user) {
        return userRepo.addUser(user);
    }

    @Override
    public int updateUser(UserDO userDO) {
        return userRepo.updateUser(userDO);
    }

//    public BaseResult<List<User>> findUsers(){
//        BaseResult<List<User>> result = new BaseResult<>();
//        List<User> users = userRepo.findUsers();
//        result.setResult(users);
//        return result;
//    }
}
