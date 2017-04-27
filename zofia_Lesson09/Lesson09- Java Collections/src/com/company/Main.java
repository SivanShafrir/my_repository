package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        //כל אלא אינטרפייסים
	    // Important Abstract Classes and Interfaces regarding Collections:
        // Iterable
        // Collection- קבוצה אין חשיבות לסדר
        // List- רשימה יש חשיבות לסדר
        // Set-אין משמעות למקום או שאתה נמצא בקבוצה או שאתה לא נמצא בקבוצה - לא מעניין האינדקס ,קבוצה בלי כפיליות
        // SortedSet- סט ממוין
        // NavigableSet- אם נשאל האם איבר קיים אז אפר להגדיר תנאים של בערך אם איבר נמצא והוא ימצא את זה
        // Queue- תור, פיפו
        // Dequeue- מחסנית, ליפו
        // Map- אוסף של זוגות קי ווליו ככה שבאוסף אין 2 זוגות עם אותו קי וכן יכול להיות 2 זוגות עם אותו וליו
        // Map<Integer, User> map- שכלול של סט כי יש גם ווליו להבדיל מסט שזה רק הקיאים
        // SortedMap, NavigableMap


        //מחלקות שמממשות את האינטרפייסים הנ"ל
        // ArrayList
        // LinkedList
        // HashSet
        // TreeSet
        // HashMap
        // TreeMap- יכול לתת לך את הדברים ממויינים אבל לא ממיין אותו
        // PriorityQueue- תור קדימיות

        Set<Point> points=new HashSet<>();
        Point p1= new Point(4,5);
        Point p2= new Point(3,4);
        points.add(p1);
        points.add(p2);
    }
}

class User{
    String userName;
    String password;

    @Override
    public int hashCode() {
        return userName.hashCode();
    }


}
