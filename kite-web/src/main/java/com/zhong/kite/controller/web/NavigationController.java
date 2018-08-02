package com.zhong.kite.controller.web;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.DO.UserDO;
import com.zhong.kite.UserService;
import com.zhong.kite.controller.VO.UserVO;
import com.zhong.kite.model.UserDTO;
import lombok.extern.java.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/")
@Controller
@Log
public class NavigationController {

    @RequestMapping("/package")
    public ModelAndView toIndex(HttpServletRequest request){
        ModelAndView view = new ModelAndView("myPackage");
        return view;
    }

    @RequestMapping("/index")
    public ModelAndView toIndex(HttpServletRequest request){
        ModelAndView view = new ModelAndView("index");
        return view;
    }

}
