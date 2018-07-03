package com.jdqm.rxjava.chapter3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("模拟一些耗时任务...");
        Thread.sleep(5000);
        return "OK";
    }
}
