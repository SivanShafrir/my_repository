package com.company;

/**
 * Created by hackeru on 2/27/2017.
 */
public class MyString {

    final char[] arr;//זה שזה מוגדר כפיינל אז זה אומר שמצביע לעלם לא ישתנה אבל הערכים בתוך המערך כן יכולים להשתנות




    public MyString(char[] arrt) {
        char[] temp = new char[arrt.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = arrt[i];
        }
        arr = temp;
    }


    public int indexOf(MyString str) {
        int index = 0;
        int j = 0;
        for (int i = 0; i < this.arr.length-str.arr.length; i++) {
            index = i;
            for (j = 0; j < str.arr.length && i + j < this.arr.length; j++) {
                if (this.arr[i + j] != str.arr[j])
                    break;
            }
            if (j == str.arr.length)
                return index;
        }
        return -1;
    }


    public MyString[] split(char delimiter) {
        int delCounter = 1;
        for (int i = 0; i < this.arr.length; i++) {
            if (this.arr[i] == delimiter)
                delCounter++;
        }
        MyString[] result = new MyString[delCounter];
        if (delCounter == 1) {
            result[0] = new MyString(this.arr);
            return result;
        }
        char[] temp = new char[arr.length];
        int tempCounter = 0, resCounter = 0;
        for (int i = 0; i < this.arr.length; i++) {
            while (i < arr.length && this.arr[i] != delimiter) {
                temp[tempCounter] = this.arr[i];
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

    public MyString toUpper() {
        MyString myString = new MyString(this.arr);
        for (int i = 0; i < this.arr.length; i++) {
           // if((this.arr[i]> 96) && (this.arr[i]<123)){
            if(( myString.arr[i] > 96) && ( myString.arr[i] <123)){
                myString.arr[i] -=32;
            }
        }
        return myString;
    }

    public MyString toLower() {
        MyString myString = new MyString(this.arr);
        for (int i = 0; i < this.arr.length; i++) {
            // if((this.arr[i]> 96) && (this.arr[i]<123)){
            if(( myString.arr[i] > 64) && ( myString.arr[i] <91)){
                myString.arr[i] +=32;
            }
        }
        return myString;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof MyString) {
            MyString other = (MyString) obj;
            if (this.arr.length != other.arr.length)
                return false;
            for (int i=0; i<this.arr.length;i++)
                if(this.arr[i]!= other.arr[i])
                    return  false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
