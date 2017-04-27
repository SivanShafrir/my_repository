package com.company;

/**
 * Created by hackeru on 2/16/2017.
 */
public class Sorting {

    /*static void bubbleSortLinkedList(Merge.Node list){
        int upTo=0;
        Merge.Node listezer=list;
        Merge.Node ezer=list;
        while(listezer.next!=null){
            upTo++;
            listezer=listezer.next;
        }
        boolean isSorted=false;
        while (!isSorted){
            isSorted=true;
            for (int i = 0; i <upTo-2 ; i++,list=list.next) {
                if(list.next.value>list.next.next.value){
                    Merge.Node temp=list.next;
                    list.next=list.next.next;
                    ezer=list.next.next;
                    list.next.next=temp;
                    temp.next=ezer;
                    isSorted=false;
                }
            }
            upTo--;
        }
    }*/
}
