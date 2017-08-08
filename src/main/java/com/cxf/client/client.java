package com.cxf.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

/**
 * Description:静态调用需要依赖service类，
 * 因为客户端调用cxf,webservice接口的过程中需要服务器端提供service，
 * 很不方便，如果同一个项目中则没有区别。
 * Created by WangSong on 2017/7/26.
 */
public class client {
//    public static void main(String[] args) {
//        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//        factory.setAddress("http://localhost:8080/service");
//        factory.setServiceClass(service.class);
//        service service = (service) factory.create();
//        System.out.println(service.sayHello("cxf"));
//    }

    /**动态调用完全不依赖service类，
     * 服务器端只要提供接口名和路径就可以方便的调用 */
    public static void main(String[] args) {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        /**url为调用webService的wsdl地址*/
        Client client = dcf.createClient("http://localhost:8080/service?wsdl");

        /**namespace是命名空间（wsdl文件中的targetNamespace属性），localPart是需要调用的方法名*/
        QName name = new QName("http://service.cxf.com/", "sayHello");
        /**方法需要的参数*/
        String xmlStr = "cxf";
        Object[] objects;
        try {
            /**调用方法并获得返回值*/
            objects = client.invoke(name, xmlStr);
            System.out.println(objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**动态调用2*/
//    public  static void main(String[] args){
//        JaxWsDynamicClientFactory dynamicClientFactory=JaxWsDynamicClientFactory.newInstance();
//        Client client=dynamicClientFactory.createClient("http://localhost:8888/serivce?wsdl");
//        try {
//            Object[] objects=client.invoke(new QName("http://service.cxf.com/","Hello"),"world");
//            System.out.print(objects[0].toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
