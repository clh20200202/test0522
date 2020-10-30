package com.atguigu.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//class ShareResource {
//    private int number = 1;//1:A 2:B
//    private int totalLoopNumber = 0;
//    private  char aChar ='A';
//    private Lock lock = new ReentrantLock();   // 锁
//    private Condition c1 = lock.newCondition(); // 钥匙
//    private Condition c2 = lock.newCondition(); // 钥匙
//
//
//    public void print2() {
//        lock.lock();
//        try {
//            //1 判断
//            while (number != 1) {
//                //A 就要停止
//                c1.await();
//            }
//            //2 干活
//            for (int i = 1; i <= 2; i++) {
//                totalLoopNumber++;
////                System.out.println(Thread.currentThread().getName() + "\t totalLoopNumber: " + totalLoopNumber);
//                System.out.print(  "\t" + totalLoopNumber);
//            }
//            //3 通知
//            number = 2;
//            c2.signal();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//            System.out.println("释放锁c1");
//        }
//    }
//
//    public void printChar(int totalLoopNumber)
//    {
//        lock.lock();
//        try
//        {
//            //1 判断
//            while(number != 2)
//            {
//                //A 就要停止
//                c2.await();
//            }
//            //2 干活
//            //for (int i = 1; i <=10; i++)
//            //{
////                System.out.println(Thread.currentThread().getName()+"\t totalLoopNumber: "+aChar);
//                System.out.println(aChar);
//                aChar++;
//           // }
//            //3 通知
//            number = 1;
//            c1.signal();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            lock.unlock();
//            System.out.println("释放锁c2");
//        }
//    }
//
//
//}

class Test1{
    private  int number = 1; //1 a 2 b 3 c
    private  char aChar = 'A';
   private Lock lock=  new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void  printA(){
        lock.lock();
        try {
               while (number!=1) {
                   c1.await();
               }
            System.out.println( Thread.currentThread().getName()+"线程："+aChar++);
                number=2;
                c2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
    }



    public void  printB(){
        lock.lock();

            try {
                while (number!=2) {

                c2.await();
                }

                System.out.println( Thread.currentThread().getName()+"线程："+aChar++);

                number=3;
                c3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }



    public void  printC(){
        lock.lock();
            try {
             while (number!=3) {

                c3.await();
             }
                System.out.println( Thread.currentThread().getName()+"线程："+aChar++);
                  number=1;
                c1.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
          }
    }




}

/**
 * @author clh
 * @description
 * @date
 */
public class LockTest {

    public static void main(String[] args) {
        Test1 test1 = new Test1();

        new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                    test1.printA();
            }
         }, String.valueOf("a")).start();

        new Thread(()->{
                for (int i = 0; i <9; i++) {

                    test1.printB();
                }
        },String.valueOf("b")).start();

         new Thread(()->{
             for (int i = 0; i <8; i++) {
                    test1.printC();
              }
         },String.valueOf("c")).start();


    }


//    public static void main1(String[] args)
//    {
//        ShareResource sr = new ShareResource();
//
//        new Thread(() -> {
//            for (int i = 1; i <=26; i++)
//            {
//                sr.print2();
//            }
//        }, "数字").start();
//        new Thread(() -> {
//            for (int i = 1; i <=26; i++)
//            {
//                sr.printChar(i);
//            }
//        }, "字母").start();
//
//
//
//    }

}
   