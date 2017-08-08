package com.cxf.service;

import javax.jws.WebService;

/**
 * Description:webservice接口实现
 * Created by WangSong on 2017/7/26.
 */
@WebService
public class serviceimpl implements service {
    public String sayHello(String param) {
        System.out.println(param+"正在调用sayHello()方法...");
        return "Hello->"+param;
    }
}
