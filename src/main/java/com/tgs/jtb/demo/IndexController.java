package com.tgs.jtb.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 小五儿 on 2017-08-21
 */
@Controller
public class IndexController {

    @RequestMapping(value={"toIndex","/"})
    public ModelAndView toIndex(HttpServletRequest request) {
        System.out.println(request.getContextPath());
        System.out.println("跳转到首页index。。。。。。。。");
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    /*public String toIndex() {
        System.out.println("跳转到首页index。。。。。。。。");
        return "index";
    }*/
}
