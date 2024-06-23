package com.learning.threads.thread.multiple.tasks;

public class MyThreadMultipleThreadMultipleTask {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(1)"));
        Task1 t1 = new Task1();
        t1.start();
        Task2 t2 = new Task2();
        t2.start();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(2)"));
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
            System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod[Task2]"));
        }
    }
}
