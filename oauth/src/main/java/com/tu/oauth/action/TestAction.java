package com.tu.oauth.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Classname TestAction
 * @Date 2019/7/25 13:35
 * @Created by tuyongjian
 */
@Controller
public class TestAction {

    @RequestMapping("/sign")
    public String sign(Model model) {
        model.addAttribute("hello","你好");
        return "sign";
    }
}