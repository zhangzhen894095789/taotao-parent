package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    /**
     * 返回到WEB-INF下的主页
     * @return
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
    /**
     * 展示其他页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showOtherPage(@PathVariable String page){
        return page;
    }
}
