package com.dao.base.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @project: Dao
 * @description:
 * @author: Mabel.Chen
 * @create: 2024-06-24
 **/
public class CompletableFutureDemo {

    public String doSomething() {
        return "Testing";
    }

    public String execute() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> new CompletableFutureDemo().doSomething());
        future.join();
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

    }
}