package com.multithreading.deadlock;

public class ResourceA {

    public void doSomething(AObject objecta, BObject objectb) throws InterruptedException {
        synchronized (objecta) {
            // do something
            Thread.sleep(1000);
            int i = 0;
            // synchronized (objectb) {
            i = objectb.getData();
            // }
            System.out.println(i);
        }

    }

}
