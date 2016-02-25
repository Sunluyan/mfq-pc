package com.mfq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liuzhiguo1 on 16/2/18.
 */
@Controller
public class PageController {

    private static final Logger logger = LoggerFactory
            .getLogger(InterViewController.class);

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String aboutUs(){
        return "about";
    }

    @RequestMapping(value = "/hospitals",method = RequestMethod.GET)
    public String hospitals(){
        return "hospitals";
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String search(){

        return "search";
    }
    @RequestMapping(value = "/product/{proId}",method = RequestMethod.GET)
    public String product(@PathVariable int proId){

        return "product";
    }

}
