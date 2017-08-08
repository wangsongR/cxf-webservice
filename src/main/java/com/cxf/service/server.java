package com.cxf.service;


import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Description:webservice启动
 * 启动后webservice对外暴露地址为:http://localhost:8080/service?wsdl
 * Created by WangSong on 2017/7/26.
 */
public class server {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(serviceimpl.class);
        factory.setAddress("http://localhost:8080/service");
        Server server = factory.create();
        server.start();
    }
}
