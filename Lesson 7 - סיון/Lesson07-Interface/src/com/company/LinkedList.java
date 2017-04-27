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
        Node p = anchor;
        for ( ;p.next != null;p = p.next);
        p.next = new Node(x);
        size++;
    }

    @Override
    public void add(int x, int index) {
        if (index > size)
            throw new IndexOutOfBoundsException("index is out of Bounds");
        Node p = anchor;
        Node q = new Node(x);
        int j = 0;
        while (j < index ) {
            p = p.next;
            j++;
        }
        q.next = p.next;
        p.next = q;
    }


    @Override
    public void remove(int index) {
        if (index > size)
            throw new IndexOutOfBoundsException("index is out of Bounds");
        Node p = anchor;
        int j=0;
        while (j < size) {
            p = p.next;
            j++;
            if(j==index-1) {
                p.next = p.next.next;
                size--;
            }
        }

    }

    @Override
    public void set(int index, int x) {
        if (index > size)
            throw new IndexOutOfBoundsException("index is out of Bounds");
        Node p = anchor;
        int j=0;
        while (j <= index) {
            p = p.next;
            j++;
        }
        p.value =x;
    }

    @Override
    public int get(int index) {
        if (index > size)
            throw new IndexOutOfBoundsException("index is out of Bounds");

        Node p = anchor;
        int j=0;
        while (j <= index) {
            p = p.next;
            j++;
        }
        return p.value;
    }

    @Override
    public int indexOf(int x) {
        Node p = anchor.next;
        int j=0;
        while (j <= size) {
            if(p.value==x)
                return j;
            p = p.next;
            j++;

        }
        return -1;
    }

    @Override
    public int[] toArray() {
        Node p = anchor.next;
        int [] arr = new  int[size];
        for (int i =0;i<size;i++,p=p.next)
            arr[i]= p.value;
        return arr;
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
