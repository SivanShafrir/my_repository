package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here
        File file1 = new File("C:\\Users\\hackeru\\Documents\\sivan shafrir\\temp1.txt");
        File file2 = new File("C:\\Users\\hackeru\\Documents\\sivan shafrir\\temp2.txt");
        OutputStream outputStream1 = null;
        OutputStream outputStream2 = null;
        byte[] buffer1 = new byte[4];
        byte[] buffer2 = new byte[4];
        try {
            outputStream1 = new FileOutputStream(file1);
            outputStream2 = new FileOutputStream(file2);
            for (int i = 0; i < 20; i+=2) {
                System.out.print(i);
                System.out.print(",");

                ByteBuffer.wrap(buffer1).putInt(i);
                try {
                    outputStream1.write(buffer1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("");
            for (int i = 1; i < 30; i+=2) {
                System.out.print(i);
                System.out.print(",");
                ByteBuffer.wrap(buffer2).putInt(i);
                try {
                    outputStream2.write(buffer2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            MergeSortFiles(file1,file2);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //תרגיל 2
        System.out.println("");
        System.out.println("Ex2");
        File filet = new File("C:\\Users\\hackeru\\Documents\\sivan shafrir\\temp6.txt");
        OutputStream outputStream = null;
        InputStream inputStream = null;
        byte[] buffer = new byte[4];
        try {
            outputStream = new FileOutputStream(filet);
            inputStream = new FileInputStream(filet);
            Random random = new Random(System.currentTimeMillis());
            for (int i = 0; i < 30; i++) {
                int rnd = random.nextInt(50);
                System.out.print(rnd);
                System.out.print(",");

                ByteBuffer.wrap(buffer).putInt(rnd);
                outputStream.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

        int [] arr= new int[0];
        arr = kSmallest(3,filet);
        System.out.println();
        for (int i = 0; i < 3; i++)
            System.out.print(arr[i]+  ", ");

    }

//תרגיל 1
    static void MergeSortFiles (File file1, File file2) throws IOException {
        File file3 = new File("C:\\Users\\hackeru\\Documents\\sivan shafrir\\temp3.txt");
        OutputStream outputStream = null;
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        byte[] buffer = new byte[4];
        byte[] buffer2 = new byte[4];
        try {
            outputStream = new FileOutputStream(file3);
            inputStream = new FileInputStream(file1);
            inputStream2 = new FileInputStream(file2);
            int actuallyRead, actuallyRead2;
            int temp;
            int temp2;
            while (((actuallyRead = inputStream.read(buffer)) != -1) && ((actuallyRead2 = inputStream2.read(buffer2)) != -1)) {
                if (actuallyRead != 4 || actuallyRead2 != 4)
                    throw new InvalidParameterException();
                temp = ByteBuffer.wrap(buffer).getInt();
                temp2 = ByteBuffer.wrap(buffer2).getInt();
                if (temp < temp2) {
                    byte[] aBytes = new byte[4];
                    ByteBuffer.wrap(aBytes).putInt(temp);
                    for (int j = 0; j < 4; j++) {
                        outputStream.write(aBytes[j]);
                    }
                    System.out.print(temp + ", ");
                }
                    byte[] aBytes = new byte[4];
                    ByteBuffer.wrap(aBytes).putInt(temp2);
                    for (int j = 0; j < 4; j++) {
                        outputStream.write(aBytes[j]);
                    }
                    System.out.print(temp2 + ", ");

            }
            while (((actuallyRead = inputStream.read(buffer)) != -1)) {
                temp = ByteBuffer.wrap(buffer).getInt();
                byte[] aBytes = new byte[4];
                ByteBuffer.wrap(aBytes).putInt(temp);
                for (int j = 0; j < 4; j++) {
                    outputStream.write(aBytes[j]);
                }
                System.out.print(temp + ", ");
            }
            while ((actuallyRead2 = inputStream2.read(buffer2)) != -1) {
                temp2 = ByteBuffer.wrap(buffer2).getInt();
                byte[] aBytes = new byte[4];
                ByteBuffer.wrap(aBytes).putInt(temp2);
                for (int j = 0; j < 4; j++) {
                    outputStream.write(aBytes[j]);
                }
                System.out.print(temp2 + ",");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }





//תרגיל 2
    static int[] kSmallest(int k,File filet) {
        byte[] buffer = new byte[4];
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filet);
            int[] arr = new int[k];
            for (int i = 0; i < k; arr[i++] = Integer.MAX_VALUE) ;
            int actuallyRead;
            while ((actuallyRead = inputStream.read(buffer)) != -1) {
                if (actuallyRead != 4)
                    throw new InvalidParameterException();
                int temp = ByteBuffer.wrap(buffer).getInt();
                int max = Integer.MIN_VALUE;
                int pos = 0;
                for (int i = 0; i < k; i++) {
                    if (arr[i] > max) {
                        max = arr[i];
                        pos = i;
                    }
                }
                if (max > temp) {
                    arr[pos] = temp;
                }
            }
            return arr;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


        }
        return null;
    }


    //תרגיל 3



}



