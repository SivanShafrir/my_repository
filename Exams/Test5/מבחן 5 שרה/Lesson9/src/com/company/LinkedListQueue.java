package com.company;

/**
 * Created by hackeru on 2/23/2017.
 */
public class LinkedListQueue<T> implements Queue<T> {
    Node<T> head, tail;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){return head == null;}

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T front() {
        return null;
    }

    @Override
    public T rear() {
        return null;
    }

    public void push(T x){
        if(isEmpty()) {
            tail = new Node<T>(null, x, null);
            head = tail;
            return;
        }
        Node<T> toAdd=new Node<T>(null,x,tail);
        tail.next=toAdd;
        tail=tail.next;
    }

    public T pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        T res = head.value;
        if (head.next != null) {
            head.next.previous = null;
        }
        head = head.next;
        return res;
    }
    public void printQ (){
        Node<T> temp=head;
        while(temp!=null){
            System.out.print(temp.value+"  ");
            temp=temp.next;
        }
        System.out.println();
    }
    public boolean isFull(){
        return false;
    }

}
