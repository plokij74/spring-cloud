package com.wzw.feign.controller;

import com.wzw.feign.service.AddServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 吴志伟
 * @Date create by 2018/6/8
 */
@RestController
public class ConsumerController {
    @Autowired
    AddServiceClient addServiceClient;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Integer add(){
        return addServiceClient.add(20);
    }
}
