package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int ASCII_0 = 48;//לפי הטבלת אסקיי
    public static final int ASCII_9 = 57;
    public static final int ASCII_MINUS = 45;


    public static void main(String[] args) {
        LinkedList<Dog> linkedList=new LinkedList<Dog>();
        linkedList.add(new Dog());
        LinkedList<Cat> cats=new LinkedList<>();//אפשר להשאיר פה את הסוגריים המשולשים ריקים כי הוא מבין שצריך לשים קאט

        //linkedList.add(new Cat());//אי אפשר להפעיל את האדד עם קאט כי הוא יכול לקבל רק דוג

        Pair<Dog,Cat> pair=new Pair<>(new Dog(),new Cat());
        Pair<Dog,Dog> pair2=new Pair<>(new Dog(),new Dog());

        List list=new LinkedList();//לא נתנו לאובייקט טיפוס גנרי ר=אז שניהם נוצרו מסוג אובגיקט
        //List<Object> list1=new LinkedList<Object>();//אם היינו כותבים ככה במקום השורה הקודמת הוא לא היה מקבל את ההמרה אחכ לסטרינג
        //List<String> strings=list //אם היינו עושים המרה לאובגקט הוא כן היה מקבל את זה
        list.add("First");
        list.add("Second");
        list.add(123);
        List<String> strings=list;//עשינו שהפויינטר יצביע לאותו מקום בזיכרון אבל הפעם זה ליסט של סטרינגים במקום ליסט של אובגקטים
        //String s1=strings.get(2);//פה הוא יפול כי זה לא מסןג סטרינג אלא מסוג אינט
        String s1=strings.get(0);
        System.out.println(s1);

        Animal a=new Dog();
        Dog d=(Dog)a;//יודע שהכל יהיה מסוג דוג כי עשנו המרה מאנימל לדוג

        LinkedList<Animal> animals=new LinkedList<>();//אם לא כותבים כלום בסוגריים המושלשות הוא יודע שזה מסוג אנימל כי המצביע מסוג אנימל
        animals.add(new Dog());
        animals.add(new Dog());
        //LinkedList <Dog> dogs = animals;//את זה אי אפשר לעשות אלא צריך ליצור רישמה חדשה כמו בשורות הבאות
        LinkedList<Dog> dogs= new LinkedList<>();//אם רוצים שזה יהיה בתור דוג צריך לבנות רשיהמ חדשה ולא מספיק לעשות קאסטינג
        for(int j=0;j<animals.size(); j++){
            dogs.add((Dog)animals.get(j));//קיבלתי פויינטר לאובייקט מסוג אנימל ועושים קאסטינג לאובייקט מסוג דוג
        }
        //מטרה: לאפשר שהמשתנה ליסט2 יוכל להצביע לכל אובייקט מסוג ליסט וגם רוטייפס מאפשר את זה\
        //אבל רוטייפס יכול לקלקל את האחידות של הנתונים וסימן שאלה לא
        List<?> list2=animals;//סימן שאלה אומר כל טיפוס מהשהוא לא ידוע
        //list2.add(new Animal());//לא מוכן לקבל את זה
        System.out.println(list2.get(0));//את זה הוא נותן אבל הוספה הוא לא נותן לעשות כל אלא שמקבלות פרמטר הוא לא נותן
        //ניתן למשוך איבר אבל לא להכניס איבר
        // Pair<?,?> pair1=new Pair<Integer,Integer>();
        //אילו המתודות שניתן לכתוב עם קאסט
        //Integer integer=(Integer) pair1.getObject1();
        //pair1.setObject1(integer);//זה לא אפשרי


        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));//עוזר לקבל קלט מהמשתמש
        System.out.println("please enter your name:");
        try {
            //String name=bufferedReader.readLine();
            //System.out.println("your name is: "+name);
            String ageAsString= bufferedReader.readLine();
            int age=Integer.valueOf(ageAsString);
            System.out.println("your age is: "+ age);
        } catch (IOException e) {
            System.out.println("error reading...");
        } catch (NumberFormatException exception){
            System.out.println("must enter an integer");
        }

        String s="hello";
        byte[] sBytes= s.getBytes();
        char c=(char)sBytes[0];
        System.out.println(sBytes[0]);




        // BufferedReader bufferedReader1=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please enter number :");
        String s2=null;
        try {
            s2=bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean b= isInt(s2);
        System.out.println(b);
        System.out.println(toInt(s2));

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean isInt(String num) {
        if (num == null || num.length() == 0)
            return false;
        byte[] numBytes = num.getBytes();
        int i = 0;
        if(numBytes[0]== ASCII_MINUS)
            i++;
        for (; i < numBytes.length; i++) {
            if (numBytes[i] < ASCII_0 || numBytes[i] > ASCII_9) {
                return false;
            }
        }
        return true;
    }

    public static int toInt(String s) {
        int h = 0;
        byte[] sBytes = s.getBytes();
        int length = s.length();
        int i = 0;
        int sign = 1;
        if (sBytes[0] == ASCII_MINUS) {
            i++;
            sign = -1;
        }
        for (; i < length; i++) {
            h = h * 10 + (sBytes[i] - ASCII_0);//כיון שהקודים בטבלת אסקיי מתחילים ב48 עד 57
        }

        return h * sign;
    }




//מתודה גנרית
    public static <T> void fill(List<T> list, int quantity,T obj){
        //מקבלת רשימה, כמות ואיזה שהוא אובייקט ומוסיפה את אוביגי לרשימה
        for (int i = 0; i <quantity ; i++) {
            list.add(obj);
        }
    }

}
class Animal{

}

class Dog extends Animal{

}

class Cat extends Animal{

}
