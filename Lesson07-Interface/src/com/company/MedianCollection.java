package com.company;

/**
 * Created by hackeru on 2/15/2017.
 */

//מציאת החציון באו של 1 בכל רגע נתון
    //ע"י 2 ערימות אחד של מינימום שהו יהיה את כל האיברים הגדולים ואחד של מקסימום שבו יהיה את כל האיברים הקטנים
    //הכנסת איבל בלוג אן
    //החציון נמצא בראש הערימת מקסימום (שבה נמצאים האיברים הקטנים)
    //תמיד מוסיפים איבר לסוף הערימת מקסימום וכאשר מכניסים עוד איבר ונהיה שבעירמת המקסימום יש 2 איברים יותר
    //מוצאים את האיבר הגדול ומעבירים אותו לערימת המינימום
    //נהייה בו 2 איברים יותר כיון שמותר או ששני העצים שווים בגודלם או שהמקסימום גדול ב1
    //כאשר יש כבר 2 איברים יותר חייב להעביר את הגדול לערימת המינימום
    //אם האיבר החדש שמכניסים לערימת מקסימום גדול מאיבר שנמצא בערימת מינימום אז
    //מוציאים מערימת המקסימום את האיבר הגדול ומעבירים לערימת המינימום
// ומוציאים את המינימלי במינימום ומעבירים לערימה המקסימלית
public class MedianCollection {
    private MinHeap minHeap;
    private MaxHeap maxHeap;

    public MedianCollection(){
        minHeap=new MinHeap();
        maxHeap=new MaxHeap();
    }

    public int getMedian(){
        if (minHeap.getSize()==0)
            throw new IndexOutOfBoundsException("collection is empty, how...");
        return maxHeap.getMax();
    }

    public void insert(int num){

        
        maxHeap.insert(num);

        if(maxHeap.getMax()>minHeap.getMin()){
            minHeap.insert(maxHeap.extractMax());
            maxHeap.insert(minHeap.extractMin());
        }
        if (maxHeap.getSize()-minHeap.getSize()==2)
            minHeap.insert(maxHeap.extractMax());
    }

}
