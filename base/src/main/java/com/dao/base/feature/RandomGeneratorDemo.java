package com.dao.base.feature;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-20
 **/
public class RandomGeneratorDemo {

    public static void main(String[] args) {
        RandomGeneratorFactory<RandomGenerator> factory = RandomGeneratorFactory.of("");
        RandomGenerator randomGenerator = factory.create(System.currentTimeMillis());
        System.out.println(randomGenerator.nextInt());
    }
}