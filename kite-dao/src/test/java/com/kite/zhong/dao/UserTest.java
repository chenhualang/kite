package com.kite.zhong.dao;

import com.kite.zhong.BaseTest;
import com.zhong.kite.mapper.UserDAO;
import com.zhong.kite.model.User;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
//@ContextConfiguration(locations={"classpath:spring/spring-kite-biz.xml"}) //加载配置文件
public class UserTest extends BaseTest{
    @Resource UserDAO userDAO;

    @Test
    public void testAll(){
        List<User> allUsers = userDAO.findAllUsers();
        System.out.println("数据库中一共有"+allUsers.size()+"条数据");
    }
}
