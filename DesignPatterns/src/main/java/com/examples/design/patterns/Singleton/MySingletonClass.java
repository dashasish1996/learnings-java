package com.examples.design.patterns.Singleton;

/**
 * Ensures only one instance of a class is created and provides a global point of access to it.
 * This is useful when exactly one object is needed to coordinate actions across the project
 * @INSTANCE a private static instance of the class to be used across the project
 * @getInstance Method to get the instance if already exists or create new if it does not
 * @constructor there should be a private constructor to override the jvm provided default constructor
 * Lazy vs Eager Loading: Instance is created at class loading (eager) or on demand (lazy)
 *          Below example is of leazy loading because when getInstance method is called then only clas object created
 *          for Eager loading the instance is initialized in the same line where it is declared
 *
 */


public class MySingletonClass {

//    private static MySingletonClass INSTANCE; // <--- Holds the singleton object
    private String mySecret;

    private MySingletonClass() {
        // Empty private constructor to Prevents external instantiation
    }

    // Implementation of singleton using Holder class
    /*
    * private static Holder class makes sure the instance is thread safe without synchronization or volatile.
    * this is lazy loading and When Singleton.getInstance() is called, JVM loads Holder and initializes the
    * static field INSTANCE only once, no matter how many threads are accessing it concurrently.
    */
    private static final class InstanceHolder {
        private static final MySingletonClass instance = new MySingletonClass(); // <--- Holds the singleton object
    }

    public static MySingletonClass getInstance() {
//        System.out.println("[" + Thread.currentThread().getName() + "]Getting Instance MySingletonClass");
        return InstanceHolder.instance;
    }

    public void setMySecret(String sec){
        System.out.println("Before Set Value [" + Thread.currentThread().getName() + "] : " + this.getMySecret());
        this.mySecret = sec;
        System.out.println("After Set Value [" + Thread.currentThread().getName() + "] : " + this.getMySecret());
    }

    public String getMySecret() {
        return this.mySecret;
    }



    // synchronized it to ensure thread safe but is slower
    /*
    public static synchronized MySingletonClass getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MySingletonClass();
        }
        return INSTANCE;
    }
    */


    // Using class lock
    /*
    public static MySingletonClass getInstance() {
        if (INSTANCE == null) {
            synchronized(MySingletonClass.class) {
                if (INSTANCE == null)
                    INSTANCE = new MySingletonClass();
            }
        }
        return INSTANCE;
    }
    */

}
