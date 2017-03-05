package com.company;

/**
 * Created by hackeru on 2/15/2017.
 */
public class MergeSortLinkList {

    public static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next=null;
        }

        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }

    public static Node merge(Node a, Node b){

        Node anchor= new Node(123);//איבר פקטיבי לא משנה מה הערך שלו
        Node tail=anchor;
        while (true){
            if(a==null){
                tail.next=b;//אם אחת הרשימות הגיעה לקצה שלה אז משתמשים ברשימה השניה
                break;
            }else if (b==null){
                tail.next=a;
                break;
            }
            if(a.value<=b.value){
                tail.next=a;//טייל תמיד מצביע לאחרון
                a=a.next;
            }else {
                tail.next=b;
                b=b.next;
            }
            tail=tail.next;
        }
        return anchor.next;
    }

    public static Node mergeSort(Node first) {
        Node head = first;
        Node middle, last;
        if (head == null || head.next == null)
            return head;
        //שומרים פוינטר לאיבר האמצעי במעבר אחד על האיברים
        middle = head;
        last = head;
        int counter = 0;
        while (last.next != null) {
            last = last.next;
            counter++;
            if (counter % 2 == 0)
                middle = middle.next;//במידל שומרים את האמצע
        }
        //לנתק את החצי הראשון מהחצי השני
        Node temp = middle;
        middle.next = null;
        middle=temp;

        Node headSorted=mergeSort(head);
        Node middleSorted=mergeSort(middle);
        return merge(headSorted,middleSorted);
    }
}
