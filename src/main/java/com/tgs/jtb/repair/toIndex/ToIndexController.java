package com.tgs.jtb.repair.toIndex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 小五儿 on 2017-08-23
 */
@Controller
public class ToIndexController {

    @RequestMapping(value="toIndex")
    public String toIndex() {
        return "index";
    }
}
