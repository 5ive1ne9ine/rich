package com.oldduck.home.rich.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：boom
 * @description：goto
 * @date ：Created in 2020/10/29 20:36
 */
public class GotoController {

    @RequestMapping("/")
    public String gotoIndex() {
        return "index";
    }

}
