package com.company;
//ארבעה סוגים של מחלקות מקוננות

public class Main {

    public static void main(String[] args) {

        Shape.Color myColor= new Shape.Color(34,45,100);//מחלקה מקוננת סטטית
        Circle.Point point= new Circle().new Point(4,5);//חייבים ליצור אובייקא מסוג סירקל כדי שנוכל ליצור את הפויינט, מחלקה מקוננת פנימית
        Circle c= new Circle();
        Circle.Point point1= c.new Point(7,8);
        Circle.Point point2=c.new Point(87,32);
        c.setCenter(point1);

        //4.Anonymous inner class

        Dog d= new Dog(){//אומר שיצרתי אובייקט ממחלקה שיורשת מדוג מחלקה ללא שם ונדרוס לה את המתודה בארק

            @Override
            void bark() {
                System.out.println("boof boof");
            }
        };//שמים סוגריים מסולסלים מיד אחרי הגדרת האובייקט כאילו מוגדרת פה מחלקה שיורשת מדוג
        //אין למחלקה שם ז"א שלא ניתן ליצור עוד אובייקט בהמחלקה הזאת... ז"א היא מחלקה חדפעמים
        //כל פעם שנכנסים לפה זה מחלקה אחרת
        d.bark();

        Dog d2=new Dog();
        d2.bark();

        //אובייקט ממחלקה אנונימית שיורש ממאי אבסטרקט קלאסס
        //היתרון שאפשר להגיד אובייקט כביכול ממחלקה אבסטרקטית
        MyAbstractClass myAbstractClass= new MyAbstractClass() {
            @Override
            void myAbstractMethod() {
            }
        };

        Student shira=new Student();
        shira.cityId=Student.JERUSALEM;
        shira.maritalStatus=Student.MARRIED;
        shira.gender=Gender.FEMALE;//שימוש באינם

        PrinterType myPrinterType=PrinterType.LASER;//שימוש באינם מדפסות

        int x5=13;
        if(x5==3) {
        }else if (x5==4){
        }else if (x5==5){
        }else ;

        switch (x5){
            case 3:
                break;
            case 5:
                break;
            default:
                break;
        }

      switch (myPrinterType){
           case DOTMATRIX:
               System.out.println("dotmatrix");
               break;
           case INKJET:
               System.out.println("inkjet");
               break;
           case THERMAL:
               break;
           case LASER:
               break;
           case THREE_DIMENSION:
               break;// כאן לא צריך דיפולט כי עשינו את כל המקרים של האינם
       }

        System.out.println(myPrinterType);//מדפיס כאן ישר את הלאסר ללא צורך לעשות סוויץ

      // Car bmw= new Car(); אי אפשר לגשת לקונסטרקטור כי הוא פרייבט


    }
    //אילוף כלבים
    static Dog trainDog(Dog d){
        //מחלקה אנונימית
        class TrainedDog extends Dog{
            @Override
            void bark() {
                System.out.println("abcdefghijklmnop...");
            }
        }
        TrainedDog trainedDog=new TrainedDog();
        trainedDog.name=d.name;
        return trainedDog;
    }
}

class Dog{
    String name;
    void bark(){
        System.out.println("waf waf..." +name);
    }
}
//אם קוד של מחלקה נראה כמו המחלקה קאט עם אותו שם זה לא אותו אובייקט! זה לא מאותה מחלקה

class Cat{
    String name;
}

abstract class MyAbstractClass{
    abstract void myAbstractMethod();
}

//enum
//קבועים מקובל לכתוב באותיות גדולות ואם יש 2 מילים שמים קו תחתי
//כשמגדירים אינם זה כאילו הגדרנו קלאסס- טיפוס, אפשר ליצור ממנו אובייקטים
enum Gender{
    MALE, FEMALE, OTHER
}

class Student{

    public static final int KFAR_SAVA=43;
    public static final int RAANANA=56;
    public static final int JERUSALEM=23;

    public static final int MARRIED=45;
    public static final int DIVORCED=13;
    public static final int SINGEL=14;
    public static final int WIDOW=2;


    String firstName;
    String lastName;
    int cityId;
    int maritalStatus;
    Gender gender;
}

//משתנה שמגדיר סוג מדפסת
//נניח שלכל סוג מדפסת יש קיבולת נייר
//נגדיר שדה
//אם מגדירים קונסטרקטור שהוא פרייבט אי אפשר להגדיר טיפוס מבחוץ

enum PrinterType{
   // DOTMATRIX, INKJET, LSER, THREE_DIMENSION, THERMAL;// שקול ליצירת אובייקטים מהמחלקה הזאת
   DOTMATRIX(4, "dotmatrix"), INKJET(3,"inkjet"), LASER(10, "laser"), THREE_DIMENSION(1, "3D"), THERMAL(20, "thermal");

    private int pageCapacity;
    private String name;

    private PrinterType(int pageCapacity, String name){//קונסטרקטור
        this.pageCapacity=pageCapacity;
        System.out.println("in PrinterType constractor ");//מדפיס את זה 5 פעמים כי עצם ההשמה למשתנה מסוג אינם זה יצירת אובייקט יוצר את 5 האובייקטים
        // היכולת להצמיד מידע נוסף לכל ערך אפשרי של האינם
        this.name=name;
    }

    public void setPageCapacity(int pageCapacity) {
        this.pageCapacity = pageCapacity;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Car{
    private Car(){

    }
}