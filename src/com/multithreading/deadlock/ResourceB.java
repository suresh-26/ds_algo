package com.multithreading.deadlock;

public class ResourceB {
    public void doSomething(AObject objecta, BObject objectb) throws InterruptedException {
        synchronized (objectb) {
            // do something
            Thread.sleep(5000);
            int i = 0;
            synchronized (objecta) {
                i = objecta.getData();
            }
            System.out.println(i);
        }

    }
}
