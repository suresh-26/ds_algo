package com.dsalgo.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(getFactorial(5));
    }

    public static int getFactorial(int n) {
        System.out.println("function called : f(" + n + ")");
        if (n == 0) {
            return 1;
        }
        int j = n * getFactorial(n - 1);
        System.out.println("computed value : " + j);
        return j;
    }
}
