package com.learning.threads.thread.multiple.tasks;


public class MyThreadMultipleThreadSingleTask  extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod"));
    }

    public static void main(String[] args) {
        MyThreadMultipleThreadSingleTask classObject1 = new MyThreadMultipleThreadSingleTask();
        MyThreadMultipleThreadSingleTask classObject2 = new MyThreadMultipleThreadSingleTask();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(1)"));
        classObject1.start(); // if we directly call run method it is called from main method
        classObject2.start();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(2)"));
    }
}
