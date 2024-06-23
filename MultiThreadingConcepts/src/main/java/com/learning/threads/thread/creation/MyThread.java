package com.learning.threads.thread.creation;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod"));
    }

    /*
        If we add a start method this start method gets called instead of the thread.start
        and new thread has no task i.e. it does not get executed
    */
    public void start(){
        System.out.println(Thread.currentThread().getName().concat(" --- Inside startMethod"));
    }
    public static void main(String[] args) {
        MyThread classObject = new MyThread();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(1)"));
        classObject.start();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(2)"));
    }
}
