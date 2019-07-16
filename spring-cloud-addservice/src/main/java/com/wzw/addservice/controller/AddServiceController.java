package com.wzw.addservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 吴志伟
 * @Date create by 2018/5/28
 */
@RestController
public class AddServiceController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    DiscoveryClient discoveryClient;

    @Value("${name}")
    private String name;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a) {
        ServiceInstance instance = discoveryClient.getInstances(discoveryClient.getServices().get(0)).get(0);
        a++;
        logger.info("/add host:" + instance.getHost() + ",port:" + instance.getPort() + ",service_id:" + instance.getServiceId() + ",result:" + a);
        return String.valueOf(a);
    }

    @RequestMapping(value = "/getName", method = {RequestMethod.POST,RequestMethod.GET})
    public String getName(){
        return name;
    }
}
