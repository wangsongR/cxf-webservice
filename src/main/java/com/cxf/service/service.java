package com.cxf.service;

import javax.jws.WebService;

/**
 * Description:webservice接口
 * Created by WangSong on 2017/7/26.
 */
@WebService
public interface service {
    String sayHello(String username);
}
