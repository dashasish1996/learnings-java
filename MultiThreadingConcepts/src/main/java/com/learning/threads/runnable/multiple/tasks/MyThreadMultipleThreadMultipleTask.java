package com.learning.threads.runnable.multiple.tasks;

public class MyThreadMultipleThreadMultipleTask {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(1)"));
        Thread th1 = new Thread(task1);
        th1.start();
        Thread th2 = new Thread(task2);
        th2.start();
        System.out.println(Thread.currentThread().getName().concat(" --- Inside mainMethod(2)"));
    }

    static class Task1 implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod[Task1]"));
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName().concat(" --- Inside runMethod[Task2]"));
        }
    }
}
