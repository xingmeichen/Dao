package com.mabel;

import redis.clients.jedis.Jedis;
import System.out.*;

/**
 * @project: JavaLearning
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-12-29 09:55
 **/
public class RedisConnection {

    public static void connectRedisWithJedis() {
        Jedis jedis = new Jedis(RedisInfo.host, RedisInfo.port);
        jedis.set("name", "Mabel");
        System.out.println(jedis.get("name"));
        jedis.close();
    }

    public static void main(String[] args) {
        connectRedisWithJedis();
    }
}