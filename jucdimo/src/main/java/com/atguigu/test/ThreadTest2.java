package com.atguigu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author clh
 * @description
 * @date
 */
class  Test{



   // public int

}
public class ThreadTest2 {

    static Object o1 =new Object();
    static Object o2 =new Object();

    public static void main(String[] args) {

         new Thread(()->{
             synchronized (o1){
                 System.out.println("得到o1锁，等待o2锁");
                 try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                 synchronized (o2){
                     System.out.println("得到o2锁");
                 }
             }

         },String.valueOf("线程名A")).start();


         new Thread(()->{
             synchronized (o2){
                 System.out.println("得到o2锁，等待o1锁");
                 try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                 synchronized (o1){
                     System.out.println("得到o1锁");
                 }
             }

         },String.valueOf("线程名A")).start();



//        new Thread(()->{
//            synchronized (o1){
//
//                System.out.println(Thread.currentThread().getName() + "我得到A锁了，等待b锁");
//
//                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//                synchronized (o2){
//                    System.out.println(Thread.currentThread().getName() + "我持有b锁");
//                }
//            }
//
//        },String.valueOf("B")).start();
//
//        new Thread(()->{
//            synchronized (o2){
//
//                System.out.println(Thread.currentThread().getName() + "我得到B锁了，等待a锁");
//
//                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
//                synchronized (o1){
//                    System.out.println(Thread.currentThread().getName() + "我持有a锁");
//                }
//            }
//
//        },String.valueOf("A")).start();


    }










}
   