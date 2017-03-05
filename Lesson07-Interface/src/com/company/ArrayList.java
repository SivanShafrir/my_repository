package com.company;

/**
 * Created by hackeru on 2/14/2017.
 */
public class ArrayList implements List {

    int[] arr;
    int size;

    public ArrayList(int[] arr, int size) {
        arr = new int[10];
        size = 0;
    }

    //קונסטרקטור במקרה שמישהוא שם לי מערך בנוי
    public ArrayList(int[] arr){
        this.arr=arr;
        this.size=arr.length;
    }

    @Override
    public void add(int x) {
        makeRoom();
        arr[size]=x;
        size++;
    }
    //להגדיל את המערך אם חסר מקום
    public void makeRoom(){
        if(size==arr.length){
            int[] temp= new int[size*2];
            for (int i = 0; i <size ; i++) {
                temp[i]=arr[i];
            }
            this.arr=temp;
        }
    }

    @Override
    public void add(int x, int index) {
        if (index > size)
            throw new IndexOutOfBoundsException("  האינדקס גדול מהסייז");
        makeRoom();
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = x;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index>size)
            throw new IndexOutOfBoundsException(" האינדקס גדול מהסייז");
        for (int i = index; i <size-1 ; i++) {
            arr[i]=arr[i+1];
        }
        size--;
    }

    @Override
    public void set(int index, int x) {
        if (index > size)
            throw new IndexOutOfBoundsException(" האינדקס גדול מהסייז");
        arr[index] = x;
    }

    @Override
    public int get(int index) {
        if (index>size)
            throw new IndexOutOfBoundsException(" האינדקס גדול מהסייז");
        return arr[index];
    }


    @Override
    public int indexOf(int x) {
        for (int i = 0; i <size ; i++) {
            if (arr[i]==x)
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        if (size==0)
            return "{}";
        String s="{";
        for (int i = 0; i <size-1 ; i++) {
            s+= arr[i]+",";
        }
        s+=arr[size-1];
        s+="}";
        return s;
    }

    @Override
    public int[] toArray() {
       int[] newArr=new int[size];
        for (int i = 0; i <size ; i++) {
            newArr[i]=arr[i];
        }
        return newArr;//פותר גם את בעיית האלייסניג כיוון שמחזיר עותק
    }
    @Override
    public int size() {
        return size;
    }



}
