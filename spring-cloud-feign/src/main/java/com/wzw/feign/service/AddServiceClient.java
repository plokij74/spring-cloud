package com.wzw.feign.service;

import com.wzw.feign.service.impl.AddServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author 吴志伟
 * @Date create by 2018/6/8
 */
@FeignClient(value = "ADDSERVICE",fallback = AddServiceHystrix.class)
public interface AddServiceClient {

    @RequestMapping(value="/add",method = RequestMethod.GET)
    String add(@RequestParam("a") Integer a);

    @RequestMapping(value="/getName",method = {RequestMethod.POST,RequestMethod.GET})
    String getName();
}
