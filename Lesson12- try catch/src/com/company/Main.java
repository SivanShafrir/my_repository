package com.company;

public class Main {

    public static void main(String[] args) {

        //מאפשר לקחת קוד שאם היה שגיאת זמן ריצה לא כל התוכנית תקרוס
        //
        try {
            int[] arr = new int[3];
            arr[15] = 90;
            System.out.println("end of try");
        }catch (ArrayIndexOutOfBoundsException ex){//עוברים לפה רק אם היה שגיאה מסמן על שגיאה יותר ספציפית
            System.out.println("there was an error");
            System.out.println(ex.getMessage());//מחזיר את השגיאה במקרה שלנו מחזיר 15 כי מנסים להגיע למקום ה15
        }catch (ClassCastException ex){//הולך לקאצ לפי סוג השגיאה
            System.out.println("there was a casting error");
        }catch (Exception ex){//קאצ כללי

        }
        System.out.println("done");

    }
}
class Animal{

}
