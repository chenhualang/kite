package com.zhong.kite.controller.web;

import com.alibaba.fastjson.JSON;
import com.zhong.kite.DO.UserDO;
import com.zhong.kite.UserService;
import com.zhong.kite.controller.VO.UserVO;
import com.zhong.kite.model.UserDTO;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RequestMapping("/")
@Controller
@Slf4j
public class NavigationController {

    @RequestMapping("/packageinfo")
    public ModelAndView toIndex(HttpServletRequest request){
        ModelAndView view = new ModelAndView("packageinfo");
        return view;
    }

    @RequestMapping("/login.action")
    public String getMenuByUserId(HttpServletRequest request){
        return "redirect:index.jsp";
    }

    /**
     * 退出登陆
     * @param request
     * @return
     */
    @RequestMapping("/quit.action")
    public String quitLogin(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:login.jsp";
    }

    @RequestMapping("/goWarehouse.action")
    public String goWarehousePage(){
        return "warehouse";
    }

    @RequestMapping("/goPackageInfo.action")
    public String goPackageInfoPage(){
        return "packageinfo";
    }

    @RequestMapping("/goCommodity.action")
    public String goCommodityPage(){
        return "commodity";
    }
}
