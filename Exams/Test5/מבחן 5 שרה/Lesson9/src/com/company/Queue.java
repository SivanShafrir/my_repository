package com.company;

/**
 * Created by hackeru on 2/23/2017.
 */
public interface Queue<T> {
   void push(T x);
   T pop();
   boolean isFull();
   boolean isEmpty();
   int size();
   T front();
   T rear();

}
