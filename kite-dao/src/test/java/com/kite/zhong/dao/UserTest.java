package com.kite.zhong.dao;

import com.kite.zhong.BaseTest;
import com.zhong.kite.DO.UserDO;
import com.zhong.kite.mapper.UserDAO;
import com.zhong.kite.model.UserDTO;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
//@ContextConfiguration(locations={"classpath:spring/spring-kite-biz.xml"}) //加载配置文件
public class UserTest extends BaseTest{
    @Resource UserDAO userDAO;

    @Test
    public void testAll(){
        List<UserDTO> allUsers = userDAO.findAllUsers();
        System.out.println("数据库中一共有"+allUsers.size()+"条数据");
    }

    @Test
    public void testDelete(){
        int i = userDAO.delUser(4);
        System.out.println("删除操作成功,结果为:"+i);
    }

    @Test
    public void testAdd(){
        UserDO user = new UserDO();
        user.setUserCode("081300336");
        user.setUserName("zhoujingzhi");
        int i = userDAO.addUser(user);
        System.out.println("增加用户记录成功，结果为"+i);
    }

    @Test
    public void testUpdate(){
        UserDO user = new UserDO();
        user.setUserId(23);
        user.setUserName("guofeng");
        int i = userDAO.updateUser(user);
        System.out.println("更新用户成功，结果为"+i);
    }
}
