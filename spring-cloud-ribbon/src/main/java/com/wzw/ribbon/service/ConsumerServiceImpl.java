package com.wzw.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 吴志伟
 * @Date create by 2018/6/12
 */
@Service("consumerService")
public class ConsumerServiceImpl implements ConsumerService{
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    @Override
    public String addService(Integer a){
        return restTemplate.getForEntity("http://ADDSERVICE/add?a=" + a, String.class).getBody();
    }

    public String addServiceFallback(Integer a){
        return "error";
    }
}
