package com.company;

/**
 * Created by This_user on 22/02/2017.
 */
public class Node<T> {
    Node<T> next;
    Node<T> previous;
    T value;

    public Node() {}

    public Node(Node<T> previous) {
        this.previous = previous;
    }

    public Node(Node<T> next, T value, Node<T> previous) {
        this.next = next;
        this.value = value;
        this.previous=previous;
    }
}
