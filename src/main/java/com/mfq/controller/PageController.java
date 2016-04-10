package com.mfq.controller;

import com.mfq.bean.Product;
import com.mfq.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzhiguo1 on 16/2/18.
 */
@Controller
public class PageController {

    private static final Logger logger = LoggerFactory
            .getLogger(InterViewController.class);

    @Resource
    ProductService service;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response){
        List<Map<String,Object>> list = new ArrayList<>();
        List<Product> pros = service.findByPage(0,8);
        for(int i = 0;i<pros.size();i++){
            Product pro = pros.get(i);
            Map<String,Object> map = new HashMap<>();
            map.put("name",pro.getName());
            map.put("price",pro.getPrice().intValue());
            map.put("desc",pro.getName());
            map.put("marketPrice",pro.getMarketPrice().intValue());
            map.put("pid",pro.getId());
            map.put("butie",pro.getMarketPrice().intValue() - pro.getPrice().intValue());
            map.put("img","http://img1.mfqzz.com/img1/p/20151218/1450431959112BY7.jpg");
            list.add(map);
        }
        request.setAttribute("products",list);
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







