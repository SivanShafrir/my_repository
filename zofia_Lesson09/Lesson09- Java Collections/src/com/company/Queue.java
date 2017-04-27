package com.company;

/**
 * Created by hackeru on 2/22/2017.
 */
public class Queue {
    int[] arr;
    int head, tail;

    public Queue() {
        arr = new int[10];//תור מוגבל בקיבולת אנחנו לא רוצים שיהיה יותר מ10 איברים בתור
        head = 0;
        tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void insert(int x) {
        if (isFull())
            throw new IndexOutOfBoundsException();
        arr[tail] = x;
        tail = (tail % arr.length) + 1;
    }

    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        int x = arr[head];
        head = (head % arr.length) + 1;
        return x;
    }

    public boolean isFull() {
        return (tail % arr.length) + 1 == head;
    }

}
