package com.atguigu.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author clh
 * @description
 * @date
 */
public class CountDownTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch downLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"同学离开教室");

                    downLatch.countDown();


            },String.valueOf(i)).start();
        }
        downLatch.await();
        System.out.println("我锁门走人了");
    }
}
   