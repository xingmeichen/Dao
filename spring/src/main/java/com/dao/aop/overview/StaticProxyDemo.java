package com.dao.aop.overview;

/**
 * @project: Dao
 * @description: 静态代理示例
 * 静态代理通过继承和组合的方式实现
 * @author: Mabel.Chen
 * @create: 2021-01-09 13:36
 **/
public class StaticProxyDemo {

    public static void main(String[] args) {
        EchoService echoService = new ProxyEchoService(new DefaultEchoService());
        echoService.echo("Hello world");
    }
}