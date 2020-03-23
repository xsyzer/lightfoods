import com.antake.ssm.dao.UserDao;
import com.antake.ssm.pojo.Permission;
import com.antake.ssm.pojo.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class Test {
    @Autowired
    UserDao userDao;
    @org.junit.Test
    public void testFindPermissionByUsername(){
        User superadmin = userDao.getUser("superadmin");
        System.out.println(superadmin);
        List<Permission> permissions = userDao.findPermissionByUsername("superadmin");
        for (Permission permission : permissions) {
            System.out.println(permission);
        }
    }
}

