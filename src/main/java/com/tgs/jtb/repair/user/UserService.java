package com.tgs.jtb.repair.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tgs.tgsit.framework.annotation.jdbc.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by 小五儿 on 2017-08-21
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //@DataSource(DataSource.MASTER)
    @DataSource(DataSource.SLAVE)
    public List<Map> findAllCity() {
        return userMapper.findAllCity();
    }

    public List<Map> pageDemo(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.pageDemo();
    }
}
