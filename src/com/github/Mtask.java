package com.github;

import java.util.concurrent.ExecutorService;

/**
 * Author: 王俊超
 * Time: 2016-03-29 14:56
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Mtask implements Runnable {
    // 任务执行次数
    private final int times;
    // 执行器框架
    private ExecutorService service;
    // 当前执行的次数
    private int tick = 0;

    public Mtask(int times, ExecutorService service) {
        this.times = times;
        this.service = service;
    }

    @Override
    public void run() {
        ++tick;
        System.out.println("Doing work..." + tick);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (times == tick) {
            service.shutdown();
        }
    }

}
