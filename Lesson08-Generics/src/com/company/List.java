package com.company;

/**
 * Created by hackeru on 2/14/2017.
 */
//עוד שימוש לאינטרפייס
public interface List<T> {

    void add(T x);
    void add(T x, int index);//להוסיף איבר במקום מסוים
    void remove(int index);
    void set(int index, T x);
    T get(int index);
    int size();

    /**
     * finds an element in the list
     * @param x the element we're looking
     * @return the first position in the list, zero based. return -1 if not found.
     */
    int indexOf(T x);
    T[] toArray();


}

