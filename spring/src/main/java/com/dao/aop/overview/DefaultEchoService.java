package com.dao.aop.overview;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-01-09 13:39
 **/
public class DefaultEchoService implements EchoService {

    @Override
    public String echo(String message) {
        return "[Echo] " + message;
    }
}