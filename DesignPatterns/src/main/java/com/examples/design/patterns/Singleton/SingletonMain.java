package com.examples.design.patterns.Singleton;

public class SingletonMain {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            MySingletonClass config = MySingletonClass.getInstance();
            String threadName = Thread.currentThread().getName();
            config.setMySecret("Mode set by " + threadName);
            System.out.println(threadName + ": " + config.getMySecret());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");
        Thread t4 = new Thread(task, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(200);
        MySingletonClass config = MySingletonClass.getInstance();
        System.out.println(">>>" + config.getMySecret());
    }
}
