package com.atguigu.test;

/**
 * @author clh
 * @description
 * @date
 */
@FunctionalInterface
interface  Foo{
    public int add(int x,int y);

}
public class lambdaTest {

    public static void main(String[] args) {
        Foo foo=(int x,int y)->{
            System.out.println("x+y");
            return x;
        };
    }
}
   