package com.multithreading.deadlock;

public class DeadlockRunner {

    public static void main(String[] args) throws InterruptedException {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        AObject oObject = new AObject();
        BObject bObject = new BObject();

        Runnable t1 = () -> {
            try {
                resourceA.doSomething(oObject, bObject);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable t2 = () -> {
            try {
                resourceB.doSomething(oObject, bObject);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(t1).start();
        new Thread(t2).start();

        // resourceA.doSomething(oObject, bObject);
        // resourceB.doSomething(oObject, bObject);
    }

}
