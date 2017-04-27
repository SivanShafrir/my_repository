package com.company;

public class Main {

    public static void main(String[] args) {

        int[] arr={9,8,7,6,5};
        System.out.println(targil1a(arr));
        int[] arr2={1,2,3,5,7};
        System.out.println(ezer(arr2));

        int[] arr3={1,4,3,5,8,10,7,8,3};
        targil2(arr3);
        for (int i = 0; i <arr3.length ; i++) {
            System.out.print(arr3[i]+",");
        }

    }

    public static boolean targil1a(int[] arr){
        boolean isUp= true;
        for (int i = 0; i <arr.length-1 ; i++) {
            if(!(arr[i]<arr[i+1])){
                isUp=false;
            }
            if (!(arr[i]>arr[i+1]) && isUp==false){
                return false;
            }

        }
        return true;
    }

    public static int ezer(int[] arr){
        int x;
        if(arr[arr.length-1]>arr[arr.length-2]){
            return arr.length-1;
        }
        x=targil1b(arr,0,arr.length-1);
        return x;
    }



    public static int targil1b(int[] arr, int left, int right){
        if(right >= left){
            int middle = left + (right-left)/2;
            if(arr[middle] <arr[middle+1]&& arr[middle+1]> arr[middle+2])
                return middle+1;
            if(arr[middle] < arr[middle+1])
                return targil1b(arr, middle+1, right);
            return targil1b(arr, left, middle-1);
        }
        return left;
    }



    static void targil2(int[] arr){
        int pivot=arr.length-1;
        int i=0;
        while( i <=pivot ) {
            while (arr[pivot]%2==0){
                int temp=arr[pivot];
                arr[pivot]=arr[i];
                arr[i]=temp;
                i++;
            }
            pivot--;
        }

    }

}
