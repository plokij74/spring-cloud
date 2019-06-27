package com.wzw.ribbon.controller;

import com.wzw.ribbon.service.ConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 吴志伟
 * @Date create by 2018/5/28
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerServiceImpl consumerService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return consumerService.addService(123);
    }
}
