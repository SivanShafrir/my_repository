package com.company;

/**
 * Created by hackeru on 2/16/2017.
 */
public class Exercise02 {

    public static class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
            next=null;
        }

        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }


    public static Node bubbleSortLinkedList(Node first) {
        boolean isSorted = false;
        int size = 0;
        for (Node p = first.next; p != null; p = p.next) {
            size++;
        }
        while (!isSorted) {
            Node p = first, q = p.next;
            isSorted = true;
            for (int i = 0; p != null && q != null && i < size; p = p.next, q = q = p.next, i++) {//
                if (p.value > q.value) {
                    Node temp = q;
                    p.next = temp.next;
                    q.next = p;
                    first =temp;
                    isSorted = false;
                }

            }
            size--;
        }

        return first;
    }

/*    //מיון בועות- משווה כל נתון עם הנתון שלידו ואם השני קטן יותר אז מחליפים בינהם
    static void bubbleSort(int[] arr){
        int upTo=arr.length-1;
        boolean isSorted=false;
        while(!isSorted){
            isSorted=true;
            for (int i = 0; i <upTo ; i++) {
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    isSorted=false;//אם יש פעם שהוא לא נכנס לעשות שום החלפה אז ז"א שהוא סיים את המיון (ולא סומן הדגל בשקר)
                }
            }
            upTo--;//  פחות האיבר האחרון כיון שבכל איטרציה האיבר האחרון הוא האיבר שנכנס למקום שלו
        }
    }*/



   public static Node insertionSortLinkedList(Node first) {
       int size =0;
       for(Node p =first.next; p!= null ;p=p.next){
           size++;
       }
       for (Node p = first.next; p != null; p = p.next) {
           Node key = p;
           Node q = first;
           for (; q.next != p; q = p.next) ;

           while (q != null && q.value > key.value && size >0) {
               q.next = q;
               size--;
           }
           q.next = key;

       }

       return null;
   }


    //מיון הכנסה- כל מספר שבודקים אותו משובץ במקום הנכון
    // מיון יציב- שומר על הסדר של האיברים, למיון קצר המיון דווקא אידאלי,
    static void insertionSort(int arr[]){
        for (int i = 1; i <arr.length ; i++) {
            int key=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>key){//או שהגעתי לסוף המערך או שמצאתי איבר שיותר גדול מKEY
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}
