package com.atguigu.test;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author clh
 * @description
 * @date
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                hashMap.put(UUID.randomUUID().toString().substring(0,8),"王大锤");
                System.out.println(hashMap);
            },String.valueOf(i)).start();
        }
    }
}
   