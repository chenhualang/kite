package com.zhong.kite.service.user;

import com.zhong.kite.DO.UserDO;
import com.zhong.kite.UserService;
import com.zhong.kite.service.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

//@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
//@ContextConfiguration(locations={"classpath:spring/spring-kite-biz.xml"}) //加载配置文件
public class UserServiceTest extends BaseTest{
    @Resource UserService userService;

//    @Test
//    public void testAll(){
//        List<UserDTO> allUsers = userService.findAllUsers();
//        System.out.println("数据库中一共有"+allUsers.size()+"条数据");
//    }

    @Test
    public void testDelete(){
        int i = userService.delUser(4);
        System.out.println("删除操作成功,结果为:"+i);
    }

    @Test
    public void testAdd(){
        UserDO user = new UserDO();
        user.setUserCode("081300339");
        user.setUserName("guofeng");
        int i = userService.addUser(user);
        System.out.println("增加用户记录成功，结果为"+i);
    }

    @Test
    public void testUpdate(){
        UserDO user = new UserDO();
        user.setUserId(3);
        user.setUserName("guofeng");
        int i = userService.updateUser(user);
        System.out.println("更新用户成功，结果为"+i);
    }
}
