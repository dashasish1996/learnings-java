package com.learning.threads.thread.mrthods;

public class MyThreadMethods {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(1)"));
        Thread.currentThread().setName("My Main");
        Task1 t1 = new Task1();
        t1.setName("Task 1-1");
        t1.start();
        Task1 t2 = new Task1();
        t2.setName("Task 1-1");
        t2.start();
        Task2 t3 = new Task2();
        t3.setName("Task 2-1");
        t3.start();
        Task2 t4 = new Task2();
        t4.setName("Task 2-2");
        t4.start();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(2)"));
        System.out.println(t3.isAlive());
    }

    static class Task1 extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod[Task1]"));
        }
    }

    static class Task2 extends Thread {
        @Override
        public void run() {
//            Thread.currentThread().setName("CheckSameName");    // This is possible
            System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod[Task2]"));
        }
    }
}
