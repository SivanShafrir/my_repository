package com.company;

import java.util.Objects;

/**
 * Created by hackeru on 2/22/2017.
 */
public class ArrQueue<T> implements Queue<T> { // FIFO

    T[] arr;
    int front, rear, size;

    public ArrQueue() {
        arr = (T[]) new Object[10];
        front = 0;
        rear = arr.length - 1;
        size = 0;
    }


    public int size() {
        if (rear > front)
            return rear - front + 1;
        else
            return arr.length - front + rear + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;//front == rear
    }

    public void push(T x) {
        if (isFull())
            throw new IndexOutOfBoundsException();
        rear = (rear + 1) % arr.length;
        arr[rear] = x;
        size++;
    }

    public T pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        T x = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return x;
    }

    public T front() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return arr[front];
    }

    public T rear() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return arr[rear];
    }

}
