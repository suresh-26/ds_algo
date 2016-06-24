package com.dsalgo.recursion;

/*
 * Head recursion, in which recursion call lies at the head, i.e. some instructions are left out after each recursion
 * call.
 * In case of tail recursion, recursion call lies at the end of the method.
 * 
 * Both generates different orders.
 */
public class HeadAndTailRecursion {
    public static void main(String[] args) {
        printHeadRecursion(5);
        printTailRecursion(5);
    }

    /**
     * head recursion prints in the order 1, 2, 3...n
     * @param n
     */
    public static void printHeadRecursion(int n) {
        if (n == 0) {
            return;
        }
        printHeadRecursion(n - 1);
        System.out.println("head: " + n);
    }

    /**
     * tail recursion prints in the order n, n-1 ...3, 2, 1
     * @param n
     */
    public static void printTailRecursion(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("tails: " + n);
        printTailRecursion(n - 1);
    }
}
