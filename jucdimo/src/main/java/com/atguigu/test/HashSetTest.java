package com.atguigu.test;

import java.util.HashSet;
import java.util.UUID;

/**
 * @author clh
 * @description
 * @date
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Object> hashSet = new HashSet<>();

        for (int i = 0; i <15 ; i++) {
            new Thread(()->{
                hashSet.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(hashSet);
            },String.valueOf(i)).start();
        }
    }
}

   