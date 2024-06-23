package com.learning.threads.runnable.multiple.tasks;

public class MyThreadMultipleThreadSingleTask implements Runnable {
    /*
        If we add a start method this doesn't impact the program as it is not getting called from anywhere
    */
    public static void main(String[] args) {
        MyThreadMultipleThreadSingleTask classObject = new MyThreadMultipleThreadSingleTask();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(1)"));
        Thread th1 = new Thread(classObject);
        th1.start();
        Thread th2 = new Thread(classObject);
        th2.start();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(2)"));
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod"));
    }
}
