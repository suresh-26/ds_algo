package com.dsalgo.linkedList;

public interface LinkedList {
    public void insertAtStart(int val);
    public void insertAtEnd(int val);
    public void insertAtPos(int val, int pos);
    public void deleteAtPos(int pos);
    public boolean isEmpty();
    public int getSize();
    public void display();

}
