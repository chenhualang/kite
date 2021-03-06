package com.zhong.kite.controller.web;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.DO.UserDO;
import com.zhong.kite.UserService;
import com.zhong.kite.controller.VO.UserVO;
import com.zhong.kite.model.UserDTO;
import com.zhong.kite.model.util.BaseResult;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/users")
@Controller
@Slf4j
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

    /**
     * 删除用户
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/delUser.action")
    public int delUser(@RequestParam("uid")int id){
        int i=userService.delUser(id);
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

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/getUserById.action")
//    public Map<String,Object> queryUserById(@RequestParam("uid")int id){
//        Map<String,Object>map=new HashMap<String, Object>();
//        List<DeptBean> dlist=deptService.getDeptList();
//        UserBean user=userService.queryUserById(id);
//        map.put("user", user);
//        map.put("dept", dlist);
//        return map;
//    }


//    @RequestMapping(value = "/all",method = RequestMethod.POST)
//    public BaseResult<Map<String,Object>> findAllUsers(@RequestParam(value="pageNumber",defaultValue="0",required=false)int pageNumber,
//                                                       @RequestParam("pageSize")int pageSize){
//        BaseResult<Map<String,Object>> result = userService.findAllUsers(pageNumber, pageSize);
//        return result;
//    }
//
//    @RequestMapping(value = "/query",method = RequestMethod.POST)
//    public BaseResult<List<User>> queryByCondition(){
//        return userService.findAllUsers(pageNumber, pageSize);
//    }
}
