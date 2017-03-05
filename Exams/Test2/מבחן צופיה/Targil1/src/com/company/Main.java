package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr={5,10,3,4,15,9,8,7};
        System.out.println(targil1(arr,4));

    }

    //לקחתי את מיון הכנסה בהנחה שהמיון קצר (מערך לא גדול)
    static void insertionSort(int arr[]){
        for (int i = 1; i <arr.length ; i++) {
            int key=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    static int targil1(int[]arr,int m){
        int min,max,minezer,maxezer,hefresh,hefreshezer;
        insertionSort(arr);
        min= arr[0];
        max=arr[m-1];
        hefresh=max-min;
        for (int i = 1; i <arr.length-m ; i++) {
            minezer=arr[i];
            maxezer=arr[i+m-1];
            hefreshezer=maxezer-minezer;
            if(hefreshezer<hefresh){
                max=maxezer;//שמרתי אותם כדי שנידע אילו חפיסות צריך להביא לצורך התרגיל לא צריך את זה
                min=minezer;
                hefresh=hefreshezer;
            }
        }
        return hefresh;
    }
    //אלגוריתם
    //בודקים את איברי השורה הראשונה במטריצה עד שמוצאים איבר יותר גדול מהX
    //חוזרים עמודה אחת אחורה אם הערך שלה לא שווה לX בודקים את הערכים שלה עד שמגיעים לאיבר שגדול מהX
    //בודקים אם האיבר הקודם בעמודה שווה לX ומחזירים אמת אם לא
    //עוברים באותה שורה לעמודה משמאל ובודקים שוב לכיוון למטה עד שמוצאים את האיבר
    static boolean targil2(int[][] arr,int x,int n){
        int shura=0;
        int amuda=0;
        for (int i = 0; i <n ; i++) {
            if(arr[0][i]>x&& i<n){
                amuda=i-1;
                if (arr[0][i]==x)
                    return true;
            }

        }
        if (arr[shura][amuda]!=x){
            if(arr[shura][amuda]<x&&amuda<n)//לא הפסקתי לכתוב עדיין תיציאה מהלולאה במקרה שאין X התרגיל לא גמור
                shura++;
            amuda--;
        }
        return true;

    }
}
