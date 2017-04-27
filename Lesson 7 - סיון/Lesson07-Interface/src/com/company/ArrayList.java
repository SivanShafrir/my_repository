package com.company;

/**
 * Created by hackeru on 2/14/2017.
 */
public class ArrayList implements List {

    int[] arr;
    int size;
    public ArrayList(int [] arr){
        this.arr = arr;
        this.size =arr.length;
    }

    public ArrayList(int[] arr, int size) {
        arr = new int[10];
        size = 0;
    }

    @Override
    public void add(int x) {
        arr[size]=x;
        size++;
    }

    @Override
    public void add(int x, int index) {
        int i = 0;
        if (index > size)
            throw new IndexOutOfBoundsException("y is out of Bounds");
        while (i <index)
            i++;
        int [] ezer= new  int [size -index];
        for ( int j = i; j<size;j++)
            ezer[j] = arr[j];
        arr[i]=x;
        size++;
        for ( int j = i+1; j<size;j++)
            arr[j]= ezer[j];
    }

    @Override
    public void remove(int index) {
        if (index > size)
            throw new IndexOutOfBoundsException("index is out of Bounds");
        int[] ezer= new  int[size-index];
        for ( int j = index+1; j<size;j++)
            ezer[j] = arr[j];
        size--;
        for ( int j = index; j<size;j++)
            arr[j]= ezer[j];

    }

    @Override
    public void set(int index, int x) {
        if (index > size)
            throw new IndexOutOfBoundsException("index is out of Bounds");
        arr[index] = x;
    }

    @Override
    public int get(int index) {
        if(index>size)
            throw new IndexOutOfBoundsException("index is out of Bounds");
        return arr[index];
    }

    @Override
    public int indexOf(int x) {
        int i;
        for ( i = 0; i < size; i++) {
            if (arr[i]==x)
                return i;
        }
        return  -1;
    }

    @Override
    public int[] toArray() {
        int [] newArr= new int[size];
        for (int i=0;i<size;i++)
            newArr[i]=arr[i];
        return newArr;
    }
}
