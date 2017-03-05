package com.company;

/**
 * Created by hackeru on 2/21/2017.
 */
public class ArrStacky<T> implements Stacky<T> {
    //implementation with an array of type T
    T arr[];
    int size;

    public ArrStacky(T[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }
    public ArrStacky() {
        arr=(T[])new  Object[10];
        size=0;
    }
    @Override
    public T pop() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Empty Stack!");
        return arr[--size];
    }
    @Override
    public T peek() {
        if(isEmpty())
            throw new IndexOutOfBoundsException("Empty Stack!");
        T retVal=pop();
        push(retVal);
        return retVal;
    }
    @Override
    public void push(T obj) {
        if(size >= arr.length)
            fixOverflow();
        arr[size++]=obj;
    }
    //help function to make stack bigger when needed
    private void fixOverflow(){
        T[] newA = (T[])new Object[size*3];
        int j=0;
        for (int i = 0; i < arr.length; i++)
            newA[j++]=arr[i];
        size+=3;
        arr=newA;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void printStack() {
        while (!this.isEmpty())
              System.out.print(this.pop()+ " ");
    }
    //Class exercise: Function to reverse stack
    public void reverseStack(){
        ArrStacky<T> temp=new ArrStacky<T>();
        while(!isEmpty())
            temp.push(this.pop());
        this.arr=temp.arr;
    }
    @Override
    public void remove(T x){
        ArrStacky<T> temp1=new ArrStacky();
        while (!isEmpty()){
            T temp=pop();
            if(temp!=x)
                temp1.push(temp);
            else{
                while(!temp1.isEmpty())
                    push(temp1.pop());
            }
        }
        while(!temp1.isEmpty())
            push(temp1.pop());
    }


}
