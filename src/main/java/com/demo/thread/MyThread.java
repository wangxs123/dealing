package com.demo.thread;

/**
 * @author： wangxs
 * @date：Create by 2018/7/25 9:18
 */
public class MyThread extends Thread{
    @Override
    public void run(){
        super.run();
        for (int i = 0; i < 99 ; i++) {
            System.out.println("输出"+i);
        }

    }
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
    }
}
