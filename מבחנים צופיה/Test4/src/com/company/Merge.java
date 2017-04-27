package com.company;

/**
 * Created by hackeru on 2/16/2017.
 */
public class Merge {

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

    public static class NodeWithHead{
        Node valueList;
        NodeWithHead nextList;

        public NodeWithHead(Node valueList){
            this.valueList=valueList;
            nextList=null;
        }

        public NodeWithHead(Node valueList, NodeWithHead nextList) {
            this.valueList = valueList;
            this.nextList = nextList;
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


    public static Node sortKlists1(NodeWithHead list) {
        if (list.nextList == null)
            return null;
        Node node1 = list.valueList;
        list = list.nextList;
        Node node2;
        while (list != null) {//(list.valueList!=null)

            node2 = list.valueList;
            node1 = merge(node1, node2);//merge(list.valueList,list.nextList.valueList);
            list=list.nextList;        // list.nextList=list.nextList.nextList

        }
        return node1; //        return list.valueList;
    }

    public static Node sortKlists2(NodeWithHead list){
        if (list.nextList == null)
            return list.valueList;
        Node node1=list.valueList;
        NodeWithHead ezer=list;
        while (list!=null){
            node1=list.valueList;
            Node node2=list.nextList.valueList;
            node1=merge(node1,node2);
            list.valueList=node1;
            list.nextList=list.nextList.nextList;
            list=list.nextList;
            sortKlists2(list);
        }
        return list.valueList;
    }


}



