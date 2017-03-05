package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("/Users/eladlavi/");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        File[] files = file.listFiles();
    /*    for(File f : files){
            System.out.println(f.getAbsolutePath());
        }*/
        System.out.println( biggestFile("C:\\Users\\hackeru\\Documents"));

    }


    static void getFromUser() {
        File file = new File("C:\\");
        Integer choice=-1;
        do {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println(i + ": " + files[i].getName());
            }
            System.out.println("choose file/directory number: ");
            Scanner scanner = new Scanner(System.in);

            choice = Integer.valueOf(scanner.next());
            //try - catch for string input
            while (choice == -1) {
                if (file.getParentFile() == null) {
                    System.out.println("No parent found, exiting function");
                    return;
                }
                file = file.getParentFile();
                files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    System.out.println(i + ": " + files[i].getName());
                }
                System.out.println("choose file/directory number: ");
                choice = Integer.parseInt(scanner.next());
            }
            while (choice > files.length || choice < -1) {
                System.out.println("Please retry: ");
                choice = Integer.parseInt(scanner.next());
            }
            if (files[choice].isFile()) {
                System.out.println("Your file: " + files[choice].getAbsolutePath());
                return;
            }
            file = files[choice];
        }
        while (file.isDirectory());
    }

    static File biggestFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile())
                    file = file.length()>files[i].length()? file : files[i];
            }
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    File res = biggestFile(files[i].getPath());
                    file = res.length() > file.length() ? res : file;
                }
            }
        }
        return file;
    }

}