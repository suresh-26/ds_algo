package com.dsalgo.recursion;

public class Fibonanci {

    public static void main(String[] args) {
        System.out.println("5th no in fib: " + printFibo(5));
    }

    public static int printFibo(int n) {
        if (n <= 1) {
            return 1;
        }
        return printFibo(n - 1) + printFibo(n - 2);
    }

}
