package com.company;

// 23/02/17

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(SumOfAllTatArrays(arr));
        System.out.println(subArraySum2(arr));
    }


    public static long SumOfAllTatArrays(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * (arr.length - i) * (1 + i);
        }
        return sum;
    }

    public static  long subArraySum2(int []arr){
        long result = 0;
        final  int n = arr.length;
        for (int i=0; i<n ;i++){
            for (int j=i; j<n; j++)
                for (int k=i; k<=j; k++)
                    result += arr[k];
        }
        return result;
    }
}