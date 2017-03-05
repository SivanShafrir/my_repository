package com.company;

/**
 * Created by hackeru on 2/21/2017.
 */
public class ArrStack<T> implements Stack<T> {
    private T arr[];
    private int size;

    @Override
    public void push(T element) {
        if(arr.length==size){
            T[] temp=(T[]) new Object[arr.length*2];
            for(int i=0;i<size;i++)
                temp[i]=arr[i];
            this.arr=temp;
        }
        arr[size++]=element;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("stack is empty");
        return arr[size--];
    }

    @Override
    public T peek() {
        return arr[size-1];
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }


}
