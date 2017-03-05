package com.company;

/**
 * Created by hackeru on 2/15/2017.
 */
public class MinHeap extends Heap {

    public MinHeap() {
        super(false);
    }

    public MinHeap(int[] arr){
        super(arr, false);
    }

    public int getMin(){
        return getTop();
    }

    public int extractMin(){
        return extractTop();
    }
}

