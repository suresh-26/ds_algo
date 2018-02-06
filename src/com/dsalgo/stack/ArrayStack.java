package com.dsalgo.stack;

public class ArrayStack {

    private int[] elements;
    int top, size;

    public ArrayStack(int size){
        this.elements = new int[size];
        this.size = size;
        this.top = -1;
    }

    public boolean isEmpty(){ return top == -1; }

    public int getSize(){return top + 1;}

    public void push(int val) {
        if (top + 1 >= size) {
            System.out.println("stack size exceeded");
        } else {
            top++;
            elements[top] = val;
        }
    }

    public int pop(){
        if(top <= -1){
            System.out.println("empty stack");
            return -1;
        }
        return elements[top--];
    }

}
