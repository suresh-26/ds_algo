package com.dsalgo.linkedList.single;

public class SingleLinkedList implements LinkedList {
    protected Node start;
    public int size;

    /* Constructor */
    public SingleLinkedList() {
        start = null;
        size = 0;
    }

    public void insertAtStart(int val) {
        Node newNode = new Node(val, null);
        if (start != null) {
            newNode.setLink(start);
        }
        start = newNode;
        size += 1;
    }

    public void insertAtEnd(int val) {
        Node newNode = new Node(val, null);

        if (start == null) {
            start = newNode;
            size++;
        } else if (start.getLink() == null) {
            start.setLink(newNode);
            size++;
        } else {
            Node endNode = null;
            Node nxtNode = start.getLink();
            while (nxtNode != null) {
                endNode = nxtNode;
                nxtNode = endNode.getLink();
            }
            endNode.setLink(newNode);
            size += 1;
        }

    }

    public void insertAtPos(int val, int position) {
        Node newNode = new Node(val, null);
        Node nodeBeforePosition = start;
        for (int i = 1; i < position; i++) {
            if (i == position-1) {
                Node tmp = nodeBeforePosition.getLink();
                newNode.setLink(tmp);
                nodeBeforePosition.setLink(newNode);
                size ++;
            }
            nodeBeforePosition = nodeBeforePosition.getLink();
        }

    }

    public void deleteAtPos(int position) {

        if (position > size) {
            System.out.println("cannot insert at a position greater than existing size");
        } else {

            Node nodeBeforePosition = null;
            int currposition = 0;
            while (currposition < position) {
                nodeBeforePosition = start.getLink();
                currposition++;
            }

            Node nodeAfterPosition = nodeBeforePosition.getLink().getLink();
            nodeBeforePosition.setLink(nodeAfterPosition);
            size--;
        }
    }

    public boolean isEmpty() {
        return null == start;
    }

    public int getSize() {
        return size;
    }

    /* Function to display elements */
    public void display() {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null) {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.print(start.getData() + "->");
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData() + "\n");
    }

}
