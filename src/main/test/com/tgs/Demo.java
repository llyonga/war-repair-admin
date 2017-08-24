package com.tgs;

import com.tgs.jtb.repair.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by 小五儿 on 2017-08-21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Demo.class)
public class Demo {

    @Autowired
    UserService userService;

    @Test
    public void method() {
        List<Map> list = userService.findAllCity();
        Map map = list.get(0);
        for (Object o : map.keySet()){
            System.out.println(o+ ":" +map.get(o));
        }
    }


}
