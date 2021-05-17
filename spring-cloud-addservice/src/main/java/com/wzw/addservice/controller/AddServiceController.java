package com.wzw.addservice.controller;

import com.wzw.addservice.util.AesException;
import com.wzw.addservice.util.WXBizMsgCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    //    @Autowired
    DiscoveryClient discoveryClient;

    private String name;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a) {
        ServiceInstance instance = discoveryClient.getInstances(discoveryClient.getServices().get(0)).get(0);
        a++;
        logger.info("/add host:" + instance.getHost() + ",port:" + instance.getPort() + ",service_id:" + instance.getServiceId() + ",result:" + a);
        return String.valueOf(a);
    }

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public String getName() {
        return "/apitest-local";
    }

    @RequestMapping(value = "/messageSend")
    public String messageSend(String msg_signature, String timestamp, String nonce, String echostr) throws AesException {
        String sToken = "loNSttvI1aWowl99u5scy4oU";
        String sCorpID = "wwba3b94c5c0bb7ccf";
        String sEncodingAESKey = "I5rjM4OCyRLYdhkiMolWLSQVmcxj8nskkAHPLbAmoPC";

        WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);

        // 解析出url上的参数值如下：
        // String sVerifyMsgSig = HttpUtils.ParseUrl("msg_signature");
        String sVerifyMsgSig = "5c45ff5e21c57e6ad56bac8758b79b1d9ac89fd3";
        // String sVerifyTimeStamp = HttpUtils.ParseUrl("timestamp");
        String sVerifyTimeStamp = "1409659589";
        // String sVerifyNonce = HttpUtils.ParseUrl("nonce");
        String sVerifyNonce = "263014780";
        // String sVerifyEchoStr = HttpUtils.ParseUrl("echostr");
        String sVerifyEchoStr = "P9nAzCzyDtyTWESHep1vC5X9xho/qYX3Zpb4yKa9SKld1DsH3Iyt3tP3zNdtp+4RPcs8TgAE7OaBO+FZXvnaqQ==";
        String sEchoStr; //需要返回的明文
        try {
            sEchoStr = wxcpt.VerifyURL(msg_signature, timestamp,
                    nonce, echostr);
            System.out.println("verifyurl echostr: " + sEchoStr);
//             验证URL成功，将sEchoStr返回
            return sEchoStr;
        } catch (Exception e) {
            //验证URL失败，错误原因请查看异常
            e.printStackTrace();
        }
        return "";
    }
}
