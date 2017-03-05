package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Exercise02.Node list2=
                new Exercise02.Node(21,
                        new Exercise02.Node(20,
                                new Exercise02.Node(2
                                     )));//new Exercise02.Node(18)


        Exercise02.Node sorted=Exercise02.bubbleSortLinkedList(list2);
        while (sorted!=null) {
            System.out.print(sorted.value + " ");
            sorted = sorted.next;
        }
    }
}
