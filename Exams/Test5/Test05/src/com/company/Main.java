package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4};
     //   System.out.println(varIsMiddle(arr));
        OrderArr(arr);

    }

//תרגיל 1
    public static boolean varIsMiddle(int[] arr) {
        int n = arr.length;
        boolean isBig = true;
        boolean isSmall = true;
        for (int i = 0; i < n - 1 ; i++) {
            if (arr[i] >= arr[i + 1]) {
                isBig = false;
            }
            if(i-1>0) {
                if (isBig && arr[i] <= arr[i - 1])
                    isSmall = false;
            }
        }
        if (isBig && isSmall)
            return true;
        return false;
    }

    public  static int varI (int [] arr){

        return 1;
    }



 //תרגיל 2

/*    //פונקצית עזר למיון מהיר שאומרת לכל מערך אני אקח איבר אחד (לדוג האחרון)
    //ובסוף העבודה האיבר ימוקם במקום הנכון כל האיברים שקטנים ממנו יהיה לשמאלו וכל הגדולים ממנו יהיו לימינו
    //שומרים במשתנה עזר כמה איברים קטנים מאיבר הציר
    static int partition(int[] arr,int low,int high){
        int pivot= arr[high]; //בתחילה האיבר ציר הוא האיבר האחרון
        //לולאה שעוברת על ערכי המערך
        // אם אתה קטן או שווה מהאיבר ציר רוצים להדביק אותו הכי שמאלה
        //נקדם את I הוא גדל שמצאתי איבר קטן יותר מהאיבר ציר
        //מחליף בין האיברים
        //מקדמים את הI שוב ומסדרים את מיקומו הסופי של איבר הציר
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }*/

    public  static void OrderArr(int[] arr){
        boolean isZugi =true;
        int pivot= arr[arr.length-1]; //בתחילה האיבר ציר הוא האיבר האחרון
        int i = arr.length-1;
        if(pivot%2!=0)
            isZugi=false;
        for (int j=0; j<arr.length;j++){
            if (arr[j]%2==0) {//זוגי
                if (isZugi == false&& i < j ) {//
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i ++;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i = j;
            }
            else{//אי זוגי
                    if(isZugi==true&&i>j){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        i= j;
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
}
