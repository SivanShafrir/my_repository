package com.company;

import com.sun.org.apache.bcel.internal.generic.NEW;
//import mypackage.MyClass;
//import mypackage.MyOtherClass;
import mypackage.*; //מביא את כל המחלקות של הפאקט הזה
import static java.lang.Math.PI;//הפאקט שבו נמצאת המחלה MATH כדי שלא שנוכל להשתמש בפאי בלי קידומת לפני

public class Main {

    public static void main(String[] args) {
      /*  
        Dog d = null;//// בגלל שD הוא פויינטר מותר לשים בו נאל אבל כשמריצים תהיה שגיאה לכן אי אפשר להריץ אובייקט על נאל
        handleDog(d);
        System.out.println("end");

        Segment segment1 = new Segment(new Point(4,5),null);
        segment1.setP1(null);
        Segment segment= new Segment(new Point(4,5),null);
        segment.setP1(new Point(6,7));//שני הגרסאות עושות את אותו דבר
        Point p= new Point(2,3);//שני הגרסאות עושות את אותו דבר
        segment.setP2(p);//שני הגרסאות עושות את אותו דבר
        p.setX(17);//שינונו את הX ז"א בעיה של אלייסינג
        System.out.println(segment1);//אם שדה נאל ואת משרשרת אותו לסרינג אז הוא מתייחס אליו כסטרינג נאל
        //פריטלן מדפיס סטרינג ולכן הוא הולך לטוסטרינג ומדפיס NULL_NULL
        System.out.println(segment);// פה מדפיס את הנקודות (6,7)-(2,3)
        System.out.println(d);//מדפיס נאל בלי ללכת לטוסטרינג בתוך הפונקציה פריטלן הוא שואל אם זה נאל ואז לא הולך לטוסטרינג
        d= new Dog();
        p.setX(17);
        System.out.println(d);//אחרי שהגדרנו ניו דוג הוא כן ילך לפונקציה טוסטרינג וידפיס I AM A DOG
       */

        Animal a = new Poodle();//לאובייקט פודל יש באר ורולינג
        //רשימת התמודות שניתן להפעיל על אובייקט נקבעת ע"י סוג המצביע ולא סוג האובייקט וכן אין לי פה את האפשרות ללכת לרולינג ובארק
        Dog d=new Poodle();// פה יהיה לו בארק ולא רולינג אבל שנפעיל את הבארק הוא ילך לבארק של הפודל ולא של הדוג
        d.bark();// מדפיס של פודל כי בזמן ריצה הוא מתייחס לאובייקט עצמו
        handleDog(d);//אפשר לשלוח אובייקט מסוג פודל לפונקציה הזאת של דוג והוא מפעיל את הבארק של פודל

        //נניח שיודעים בוודאות שזה פודל ואם היה מצביע לפודל הייתי יכול להפעיל את הרול
        //Poodle p= d;// אי אפשר לעשות כי כלב הוא לאו דווקא פודל
        // שמות לשורה מתחת קסינג או דאונג קאסט-DOWNCAST כי פודל בהיררכיה פחות מדוג, שם נוסף זה אקספליסט קסט- EXPLICIT CAST באופן מפורש
        Poodle p=(Poodle)d;//לכן נעשה המרה של D להיות פודל ואז הפכנו את המצביע להיות גם פודל פעולת קסטינג-(לשחק תפקיד של) רק משפיעה על ההסתכלות עליו
        //הD משחק תפקיד של פודל רק לצורך הגישה לעיל לזיכרון
        //הכתובת של P וD יש להם אותו כתובת בזיכרון
        //יש 2 מצביעים לאותו אובייקט של פודל רק שהP מצביע מסוג פודל והD מצביע מסוג דוג לP יש את כל הפונקציות של פודל ולD רק את הפונקציות של דוג
        Animal a2=d; //אנקסט- UNCAST הפוינטר מומר מדוג לאינמל עולה בהירארכיה שם נוסף IMPLICIT CAST - באופן מרומז
        p.roll();
      //  d.roll();//נותן שגיאה כי D הוא מסוג DOG
       // ((Poodle) d).roll();//אם עושים רול עם ההשלמה האוטומטית אז הוא עושה המרה לבד, אבל את כותבים לבד כמו השורה הקודמת אז זה עושה שגיאה
        // Cat c=(Cat)d;//פה אין אפשרות לעשות המרה לקאט כייון שקאט לא אבא של דוג
        //Cat c=(Cat)a; //Downcast לא נכון בפועל בזמן ריצה
        //בזמן קומפילציה הוא נותן אפשרות לעשות המרה לקאט בגלל שהוא רואה שהמצביע מסוג אנימל אבל בזמן ריצה רואה שהאובייקט מסוג פודל ומפודל אי אפשר לעשות המרה לקאט ולכן התוכנית נופלת
        // ההמרות לעיל זה המרה על האופן בו אני מסתכל על אובייקט
        //c.howl();
        // אפקאסט תמיד מצליח ודאוןקאסט יכול להיכשל
        int x=5;
        long myLong=x;
        x= (int)myLong;//סוג אחר של קסטינג זה קסטינג שמדבר על המרה בין טיפוסים פרימטיבים (אני מוכנה לאיבוד מידע)

       //אם ורק אם יש בA פודל בזמן ריצה אומר בכתובת A אם בפועל יש פודל
        //אם לא יודעים אם הA פודל אז אפשר לשאול בזמן ריצה כדי שתהיה המרה ולא יפול בזמן ריצה
        // האופרטור אומר האם הקאסטינג יצליח
        if(a instanceof Poodle){
            Poodle p2 =(Poodle)a;
        }
        //אובייקטים שונים שיש להם את אותם שיעורים במישור
        Point p1= new Point(4,5);
        Point p2=new Point(4,5);
        if (p1==p2){
            System.out.println("p1==p2");
        }else {
            System.out.println("p1!=p2");
        }
        //פה ידפיס שהם שונים כיון שהאופרטור == משווה בים הכתובות של הפוינטים
        //אם היינו שמים לפני POINT P2=P1 אז זה כן היה יוצא שהם שווים
        // אורקל רצו להסדיר את העניין הזה אורקל יצרו את EQUALS במחלקה אובגיקט כדי שנוכל לעשות השוואה בין אובייקטים
        //במחלקה אובגקט אין הבדל במימוש בין == וEQUALS כיון שלכל אובייקט יש אפשרות מימוש אחרת
        // אז מה ההבדל בינהם? אילו P1 היה נאל וגם P2 היה נאל הקוד הקודם היה מחזיר TRUE והקוד הזה היה קורס כיון שזה מתודה שמפעילה נאל זה שגיאה
        if (p1.equals(p2)){// אם P1 היה נאל אז היה קורס אבל אם P1 לא היה נאל וP2 היה נאל לא יקרוס וכנראה יחסיר פולס (לא סימטרי)
            System.out.println("p1==p2");
        }else {
            System.out.println("p1!=p2");
        }

       // mypackage.MyClass myClass;// גם אפשרות במקום האינפורט למעלה
        MyClass myClass;
        MyOtherClass myOtherClass;

        //double perimeter=2.0*Math.PI*10.0;
        double perimeter=2.0*PI*10.0;// אפשר להשתמש בפאי ללא הקידומת כיוון שהגדרנו אימפורט למעלה

    }

    public static void handleDog(Dog d){
        if(d!=null)
           d.bark();
    }
    //סכום הספרות של מספר
    public static int sumOfDigits(int num){
       int result=0;
       while (num!=0){
           int lastDigit = num %10;
           num /= 10;
           result +=lastDigit;
       }
       return result;
    }

   // מציאת הספרה הגדולה ביותר
    public static int largesDigit(int num){
        int result=0;
        while (num!=0){
            int lastDigit = num %10;
            num /= 10;
            if(lastDigit>result)
                result =lastDigit;
        }
        return result;
    }

    public static int reverseDigit(int num){
        int result=0;
        while (num!=0){
            int lastDigit = num %10;
            num /= 10;
            result =result*10+lastDigit;
        }
        return result;
    }

    //סכום הספרות הסופי של מספר
    //99 -> 18 ->9
    public static int finalSumOfDigit(int num){
        int result=num;
        while (result>=10)
            result =sumOfDigits(result);
        return result;
    }

    //האם המספר מתחלק ב3 מחברים את סכום הספרות הסופי ואם הוא מתחלק ב9 אז כל המספר מתחלק ב9
    public static boolean isDivisibleBy3(int num){
        int sumOfDigits= finalSumOfDigit(num);
        return sumOfDigits==3||sumOfDigits==6||sumOfDigits==9;
    }


}
class Animal{
    
}

class Dog extends Animal{
    public void goTSleep(){
        System.out.println("going to sleep");
}

    void bark(){
        System.out.println("waf...waf...");
    }


    @Override
    public String toString() {
        return "I am a dog";
    }
}

class Cat extends Animal{
    void howl(){
        System.out.println("miaoooooooooooooooooo");
    }
    
}

class Poodle extends  Dog{
    @Override
    void bark() {
        System.out.println("bfff... bfff...");
    }
    //מתגלגל
    public void roll(){
        System.out.println("rolling");
    }
}
