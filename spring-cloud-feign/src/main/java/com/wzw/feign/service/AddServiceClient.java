package com.wzw.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author 吴志伟
 * @Date create by 2018/6/8
 */
@FeignClient("ADDSERVICE")
public interface AddServiceClient {
    @RequestMapping(value="/add",method = RequestMethod.GET)
    Integer add(@RequestParam("a")Integer a);
}
