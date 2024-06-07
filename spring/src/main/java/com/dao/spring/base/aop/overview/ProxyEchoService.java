package com.dao.spring.base.aop.overview;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-01-09 13:41
 **/
public class ProxyEchoService implements EchoService {

    private final EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }
    @Override
    public String echo(String message) {
        long start = System.currentTimeMillis();
        String result = echoService.echo(message);
        long end = System.currentTimeMillis();
        System.out.println("echo 方法执行时间：" + (end - start) + "毫秒");
        return result;
    }
}