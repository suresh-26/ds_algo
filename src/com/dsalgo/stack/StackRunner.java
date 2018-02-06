package com.dsalgo.stack;

public class StackRunner {

    public static void main(String[] arr){
        ArrayStack as =new ArrayStack(5);
        as.push(1);
        as.push(2);
        as.push(3);
        as.push(4);
        as.push(5);
        as.push(6);

        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
    }

}
