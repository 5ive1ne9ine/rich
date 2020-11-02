package com.oldduck.home.rich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author £ºboom
 * @description£ºgoto
 * @date £ºCreated in 2020/10/29 20:36
 */
@Controller
public class GotoController {

    @RequestMapping("/")
    public String gotoIndex() {
        return "index";
    }

}
