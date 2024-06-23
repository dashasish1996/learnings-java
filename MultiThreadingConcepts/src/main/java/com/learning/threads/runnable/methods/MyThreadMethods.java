package com.learning.threads.runnable.methods;

public class MyThreadMethods {
    static class Task1 implements Runnable{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod[Task1]"));
        }
    }
    static class Task2 implements Runnable{
        @Override
        public void run(){
//            Thread.currentThread().setName("CheckSameName");         // This is possible
            System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod[Task2]"));
        }
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(1)"));
        Thread.currentThread().setName("My Main");
        Thread th1 = new Thread(task1, "Task 1-1");
        th1.start();
        Thread th2 = new Thread(task1, "Task 1-1");
        th2.start();
        Thread th3 = new Thread(task2, "Task 2-1");
        th3.start();
        Thread th4 = new Thread(task2, "Task 2-2");
        th4.start();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(2)"));
        System.out.println(th3.isAlive());
    }
}
