package com.dsalgo.queue;

public class CircularArrQueue {

    int front, rear, size;
    int[] elements;

    public CircularArrQueue(int size){
        this.size = size;
        this.front = 0;
        this.rear = 0;
        this.elements = new int[size];
    }

    public void enqueue(int val){
        if((rear == size && front == 0) || (front == size && rear == 0)){
            System.out.println("no space left for new element");
        }else{
            if(rear == size -1){
                elements[rear] = val;
                rear = 0;
            }else{
                elements[rear++] = val;
            }
        }
    }

    public int dequeue() {
        if (front == 0 && rear == 0) {
            System.out.println("queue is empty");
        }
        int result = 0;
        if (front == size - 1) {
            result  = elements[front];
            front = 0;
        } else {
            result = elements[front++];
        }
        return result;
    }
}
