package com.atguigu.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author clh
 * @description 证明数组线程不安全
 * @date
 */
public class ArrayListThreadTest {

    public static void main(String[] args) {






        List<String> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,8));
                    list.add("a");
                System.out.println(Thread.currentThread().getName()+"成功了");
                System.out.println(list);
//                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            },String.valueOf(i)).start();

        }

        
        
        


    }

}
   