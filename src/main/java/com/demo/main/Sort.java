package com.demo.main;

/**
 * @author： 王孝双
 * @date：Create by 2018/7/18 10:23
 */
public class Sort {
    public static void main(String[] args) {
        B b = new B();
        b.getA();
    }
}
class A{
    public A(){
        System.out.println("A的构造方法");
    }
    static {
        System.out.println("A的静态方法");
    }
    public void getA(){
        System.out.println("A方法");
    }
}
class B extends A{
    public B(){
        System.out.println("B的构造方法");
    }
    static {
        System.out.println("B的静态方法");
    }
    public void getB(){
        System.out.println("B方法");
    }
}