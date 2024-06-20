package com.dao.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2021-12-29 09:55
 **/
public class RedisConnectionPool {

    public static JedisPool pool = null;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        pool = new JedisPool();
    }

    public static Jedis getConnection() {
        return pool.getResource();
    }

    public static void main(String[] args) {
        Jedis connection = getConnection();
        connection.set("name", "Mabel Chen");
        System.out.println(connection.get("name"));
        // 思考：这里需要手动释放连接吗？
    }
}