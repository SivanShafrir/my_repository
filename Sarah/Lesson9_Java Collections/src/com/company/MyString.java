package com.company;

/**
 * Created by hackeru on 2/27/2017.
 */
public class MyString {
    final char[] arr;

    public MyString(char[] arrt) {
        char[] temp=new char[arrt.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=arrt[i];
        }
        arr=temp;
    }

    public int indexOf (MyString balonzo) {
        int k, j = 0;
        for (int i = 0; i < this.arr.length; i++) {
            k = i;
            while (arr[k++] == balonzo.arr[j++] && k<this.arr.length && j<balonzo.arr.length);
            if(j == balonzo.arr.length)
                return i;
            j=0;
        }
        return -1;
    }

    public MyString[] split (char delimiter) {
        int delCounter = 1;
        for (int i = 0; i <this.arr.length ; i++) {
            if(this.arr[i] == delimiter)
                delCounter++;
        }
        MyString[] result = new MyString[delCounter];
        if(delCounter == 1){
            result[0] = new MyString(this.arr);
            return result;
        }
        char[] temp = new char[arr.length];
        int  tempCounter = 0, resCounter = 0;
        for (int i = 0; i < this.arr.length; i++) {
            while (i<arr.length && this.arr[i] != delimiter) {
                temp [tempCounter] = this.arr[i];
                tempCounter++;
                i++;
            }
            result[resCounter++] = new MyString(temp);
            for (int l = 0; l < temp.length; l++)
                temp[l] = ' ';
            tempCounter = 0; // for the next time
        }
        return result;
    }

}
