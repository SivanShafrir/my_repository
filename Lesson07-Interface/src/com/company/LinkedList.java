package com.company;

/**
 * Created by hackeru on 2/14/2017.
 */
public class LinkedList implements List {
    private Node anchor;//עוגן
    private int size;

    public LinkedList(){
        anchor=new Node(0);// אנקו הוא נאד פקטיבי, לא מחזירים בשום שלב את הערך הזה עושים את זה כדי שזה יפשט את הקוד שבהמשך
        size=0;
    }

    @Override
    public void add(int x) {
        Node i ;
        for ( i = anchor; i.next!=null; i=i.next);
        i.next=new Node(x);
        size++;
    }

    @Override
    public void add(int x, int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("");
        Node i;
        int j = 0;
        for (i = anchor; j < index; j++, i = i.next) ;
        Node ezer = new Node(x);
        ezer.next = i.next;
        i.next = ezer;
        size++;
    }

    @Override
    public void remove(int index) {
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException("");
        Node i=anchor;
        int j=0;
        while (j<index) {
            i = i.next;
            j++;
        }
        i.next=i.next.next;
        size--;
    }

    @Override
    public void set(int index, int x) {
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException("");
        Node i=anchor;
        int j=0;
        while (j<=index){
            i=i.next;
            j++;
        }
        i.value=x;

    }

    @Override
    public int get(int index) {
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException("");
        Node i=anchor;
        int j=0;
        while (j<=index){
            i=i.next;
            j++;
        }
        return i.value;

    }



    @Override
    public int indexOf(int x) {
        Node node=anchor.next;

        for(int i=0;i<size;node=node.next,i++){
            if(node.value==x)
                return i;
        }
      return -1;
    }

    @Override
    public int[] toArray() {
        int[] arrList=new int[size];
        Node node=anchor.next;
        for (int i = 0; i <size ; i++, node=node.next) {
            arrList[i]=node.value;
        }
        return arrList;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size==0)
            return "{}";
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("{");
        Node node=anchor.next;
        for (int i = 0; i <size-1 ; i++, node=node.next) {
            stringBuilder.append(node.value+",");
        }
        //מאפשר שרשור של סטרינגים בצורה יעילה מבלי ליצור את השרשור כולו כל פעם מחדש
        stringBuilder.append(node.value);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next=null;
        }
    }
}

