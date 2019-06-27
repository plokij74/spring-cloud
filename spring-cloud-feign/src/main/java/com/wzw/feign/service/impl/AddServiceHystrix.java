package com.wzw.feign.service.impl;

import com.wzw.feign.service.AddServiceClient;
import org.springframework.stereotype.Component;

/**
 * @Author 吴志伟
 * @Date create by 2019/6/27
 */
@Component
public class AddServiceHystrix implements AddServiceClient {
    @Override
    public String add(Integer a) {
        return "method add is faild";
    }
}
