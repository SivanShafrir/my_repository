package com.company;

public class Main {

    public static void main(String[] args) {

        /*//כל אחד משמונת הפרימטיבים הוא לא אובייקט ולכן אין לו שדות ואין לו מתודות
        //לכל משתנה פרימיטבי יש בןדוד
        int x=5;
        Integer y= new Integer(6);// כן אובייקט ולכן יש לו מתודות (זה מחלקה)
    // כל משתנה פרימיטיבי שכותבים אותו עם אות גדולה זה מחלקה
        //מותר לבצע השמה של אינט פרימיטיבי לתוך אובייקט אפשר לעבור חופשי בין השניים
        System.out.println(y+3);// גם תהליך של בוקסים
        int z=y;

        z=x;
        x++;
        System.out.println(z);

        // אפילו שהאינטגר הוא אובייקט הוא מתנהג כמו הפרימיטיבי הוא עובר כמו BYVALUE
        //אובייקטים שחיים במחסנית- כל מי שחי במחסנית עובר BYVALUE

        Integer a=5;
        Integer b=a;
        a++;
        System.out.println(b);
        */

        byte b=9;
        aMethod(b);// יופעל הSHORT כי BYTE הכי קרוב לSHORT
        aMethod(9);// יופעל INT אם כותבים סתם ככה מספר מופעל INT
        Integer i=9;
        aMethod(i);// יופעל האובגקט ואם לא היה האובגקט הוא היה הולך לINT
        aMethod("9");//הולך לסטרינג ואם לא היה סטרינג הוא היה הולך לאובגקט כי סטרינג זה אובגקט

        //aMethod1(9);//  שגיאת קומפילציה כי זה אינט ויש חשש לאיבוד מידע כיון שיש לו אפשרות ללכת רק לשורט ובית

        //aMethod2(9,10);// שגיאת קומפילציה אין חשש לאיבוד מידע אבל הוא לא יודע לאן ללכת לכן זה שגיאה

    }


    //מתודה סטטית ז"א שלא צריך ליצור אובייקט מהמחלקה בכדי להפעיל אותה למעשה המתודה שייכת למחלקה
    public static void aMethod(int val){System.out.println("int");}
    public static void aMethod(short val){System.out.println("short");}
    public static void aMethod(Object val){System.out.println("object");}
    public static void aMethod(String val){System.out.println("string");}

    public static void aMethod1(short val){System.out.println("short");}
    public static void aMethod1(byte val){System.out.println("byte");}
    //כשמזמנים במיין זה יוצר שגיאת קומפילציה כי 2 הפונקציות האלה מקבלות LOMG ו INT , אם הייתה רק אחת מהם הוא היה הולך אליה, כי אין חשש לאיבוד מידע אבל בגלל שישי 2 הוא לא יודע במי לבחור
    public static void aMethod2(long val1, int val2){System.out.println("long, int");}
    public static void aMethod2(int val1, long val2){System.out.println("int, long");}
}
