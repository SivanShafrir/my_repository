package com.company;

import java.security.InvalidParameterException;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    static boolean searchInSortedMatrix(int[][] mat,int x){
        int n=mat.length;
        int i=0, j=n-1;//מיקומו של האיבר מימין למעלה
        while (i<n&&j>=0){
            if(mat[i].length!=n)
                throw new  InvalidParameterException("row "+ i+ "is not length"+ n);
            if(mat[i][j]==x)
                return true;
            if(mat[i][j]>x)
                j--;
            else
                i++;
        }
        return false;
    }


}
