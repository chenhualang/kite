package com.zhong.kite.controller.web;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.DO.UserDO;
import com.zhong.kite.UserService;
import com.zhong.kite.controller.VO.UserVO;
import com.zhong.kite.model.UserDTO;
import com.zhong.kite.model.util.BaseResult;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/users")
@Controller
@Log
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getUserList(@RequestBody UserVO userVO){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userVO,userDTO);
        log.info("请求参数为"+JSON.toJSONString(userDTO));
        Map<String,Object> map = userService.getUserList(userDTO);
        log.info("返回结果为:"+ JSON.toJSONString(map));
        return map;
    }


    @ResponseBody
    @RequestMapping("/delUsers.action")
    public int delUsers(@RequestParam("ids")int[] ids){
        int i=userService.delUsers(ids);
        return i;
    }

    @ResponseBody
    @RequestMapping("/addUser.action")
    public int addUser(@RequestBody UserVO userVO){
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userVO,userDO);
        int i=userService.addUser(userDO);
        return i;
    }

    @ResponseBody
    @RequestMapping("/updateUser.action")
    public int updateUser(@RequestBody UserVO userVO){
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userVO,userDO);
        int i=userService.updateUser(userDO);
        return i;
    }

    @RequestMapping("/package")
    public ModelAndView toIndex(HttpServletRequest request){
        ModelAndView view = new ModelAndView("myPackage");
        return view;
    }

//    @RequestMapping(value = "/all",method = RequestMethod.POST)
//    public BaseResult<Map<String,Object>> findAllUsers(@RequestParam(value="pageNumber",defaultValue="0",required=false)int pageNumber,
//                                                       @RequestParam("pageSize")int pageSize){
//        BaseResult<Map<String,Object>> result = userService.findAllUsers(pageNumber, pageSize);
//        return result;
//    }

//    @RequestMapping(value = "/query",method = RequestMethod.POST)
//    public BaseResult<List<User>> queryByCondition(){
//        return userService.findAllUsers(pageNumber, pageSize);
//    }
}
