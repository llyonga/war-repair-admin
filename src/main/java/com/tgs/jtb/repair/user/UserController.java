package com.tgs.jtb.repair.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by 小五儿 on 2017-08-21
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "demo")
    public String method(Model model) {
        List<Map> list = userService.findAllCity();
        Map map = list.get(0);
        for (Object o : map.keySet()){
            System.out.println(o+ ":" +map.get(o));
        }
        model.addAttribute("listMap",list);
        return "user/userList";
    }

    @RequestMapping(value = "pageDemo")
    public String pageDemo(HttpServletRequest request,@RequestParam("pageNo") int pageNo,@RequestParam("pageSize") int pageSize, Model model) throws Exception {
        //int pageNo = Integer.valueOf(request.getParameter("pageNo"));
        //int pageSize = Integer.valueOf(request.getParameter("pageSize"));cmd
        List<Map> list = userService.pageDemo(pageNo,pageSize);
        System.out.println(list.size());
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        Page page = (Page) list;
        /*for (int i=0; i<page.size(); i++) {
            Map map = page.get(i);
            for (Object o : map.keySet()){
                System.out.println(o+ ":" +map.get(o));
            }
        }*/
        model.addAttribute("listMap",page);
        return "user/userList";
    }
}
