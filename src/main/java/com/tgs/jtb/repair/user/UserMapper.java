package com.tgs.jtb.repair.user;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by 小五儿 on 2017-08-21
 */
@Mapper
public interface UserMapper {

    List<Map> findAllCity();

    List<Map> pageDemo();
}
