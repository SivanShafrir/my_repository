package com.company;

/**
 * Created by hackeru on 2/21/2017.
 */
//This is a classic example of a Stack with its general functions
public interface Stacky<T> {
    T pop(); //get the top of stack by LIFO
    T peek(); //view top of stack without extracting
    void push(T obj); //push to stack
    void remove(T obj); //remove item from stack
    boolean isEmpty(); //returns if stack is empty
    void printStack(); //prints stack
}
