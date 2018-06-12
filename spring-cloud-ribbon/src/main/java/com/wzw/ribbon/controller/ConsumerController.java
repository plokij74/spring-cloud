package com.wzw.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 吴志伟
 * @Date create by 2018/5/28
 */
@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String add(){
        Integer a = 1;
        return restTemplate.getForEntity("http://ADDSERVICE/add?a="+a,String.class).getBody();
    }
}
