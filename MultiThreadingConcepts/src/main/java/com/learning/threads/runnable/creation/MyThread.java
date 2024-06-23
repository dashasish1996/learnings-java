package com.learning.threads.runnable.creation;

public class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod"));
    }

    /*
        If we add a start method this doesn't impact the program as it is not getting called from anywhere
    */
    public static void main(String[] args) {
        MyThread classObject = new MyThread();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(1)"));
        Thread th = new Thread(classObject);
        th.start();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(2)"));
    }
}
