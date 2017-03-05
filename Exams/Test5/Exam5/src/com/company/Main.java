package com.company;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6, 7, 8, 10};//רק עולה
        System.out.println(isMountain(arr));
        int[] arr1 = {6, 5, 4};//סדר יורד
        System.out.println(isMountain(arr1));
        int[] arr2 = {6, 3, 5, 7, 4, 2, 1, 4};
        arrangeAllEvenAtStart(arr2);


        //בודק אוטומטי ל 2
        int[] arr3;

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 1000; i++) {
            arr = new int[1 + random.nextInt(100)];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(1000)-500;
            }
            arrangeAllEvenAtStart2(arr);
            if(!isEvenFirst(arr)){
                System.out.println("your code is wrong");
                break;
            }
        }


        Station[] stations = {
                new Station(2, 3),
                new Station(3, 1),
                new Station(1, 2)

        };
        System.out.println(findStartingStation(stations));


    }


    //תרגיל 1
    //סעיף א
    public static boolean isMountain(int[] arr) {
        boolean foundPeak = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                if (foundPeak)
                    return false;
            } else if (arr[i] > arr[i + 1]) {//אם מצאתי ירידה
                foundPeak = true;
            } else {
                return false;
            }
        }
        return true;
    }


    //סעיף ב
    static int findPeak(int[] arr, int from, int to) {
        if (from == to)
            return from;
        if (to - from == 1) {
            if (arr[from] > arr[to])
                return from;
            return to;
        }
        // int middle =(from+to)/2;//יש פה סכנת אוברפלן לכן לא נעשה ככה אלא כמו השורה הבאה
        int middle = from + (to - from) / 2;
        boolean greaterThanMyLeft = arr[middle] > arr[middle - 1];
        boolean greaterThanMyRight = arr[middle] > arr[middle + 1];
        if (greaterThanMyLeft && greaterThanMyRight)
            return middle;
        if (greaterThanMyLeft && !greaterThanMyRight)
            return findPeak(arr, middle + 1, to);
        else
            return findPeak(arr, from, middle - 1);
    }
    //זמן ריצה:
    // T(n) = T(n/2) + O(1)
    // T(n) = T(n/4) + O(1) + O(1)
    // T(n) = T(n/8) + O(1) + O(1) + O(1)
    // T(n) = T(n/2^k) + O(1) + O(1) +....
    //  n/2^k > 1
    //  n>2^k
    //  log2(n)>k
    // O(log2(n)) זמן הריצה:


    //תרגיל 2
    // לא יציב
    static void arrangeAllEvenAtStart(int[] arr) {
        int i=-1, temp =0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j]%2==0) {
                i++;
                if(j!=i) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
       printArray(arr);
    }

    static void printArray(int[] arr){
        System.out.print("{");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]);
            if (i<arr.length-1)
                System.out.print(",");
        }
        System.out.println("}");
    }

    static boolean isEvenFirst(int[] arr){
        boolean found = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] % 2 == 0){
                if(found)
                    return false;
            }else{
                found = true;
            }
        }
        return true;
    }


    static void arrangeAllEvenAtStart2(int[] arr){
        int i=-1, temp = 0;
        int j=arr.length;
        while(true) {
            do {
                j--;
            } while (j > -1 && arr[j] % 2 != 0);
            do {
                i++;
            } while (i < arr.length && arr[i] % 2 == 0);

            if (i < j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            } else {
                return;
            }

        }
    }

    //תרגיל תחנה
// פתרון נאיבי
    public static int findStartingStation(Station[] stations){
        boolean validPath;
        for (int i = 0; i < stations.length; i++) {
            int sum = 0;
            int j=i;
            validPath = true;
            do {
                sum += stations[j].charge;
                sum -= stations[j].distanceToNext;
                if(sum<0){
                    validPath = false;
                    break;
                }
                j++;
                if(j==stations.length)
                    j=0;
            }while(j != i);
            if(validPath)
                return i;
        }
        return -1;
    }

    // פתרון נועה
    public static int findStartingStation2(Station[] stations) {

        int sum=0,position=0;
        for (int i = 0; i <stations.length ; i++) {
            sum += stations[i].charge;
            sum -= stations[i].distanceToNext;
            if(sum<0){
                position=i+1;
                sum=0;
            }
        }
        return position;
    }



}

class Station{

    int charge;
    int distanceToNext;

    public Station(int charge, int distanceToNext) {
        this.charge = charge;
        this.distanceToNext = distanceToNext;
    }
}

