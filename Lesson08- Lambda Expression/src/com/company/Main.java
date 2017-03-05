package com.company;

public class Main {

    public static void main(String[] args) {

        //מקרה קלאסי של מחלקה אנונימית
        Writable writable1 = new Writable() {
            @Override
            public void write(String s) {
                System.out.println(s);
            }
        };
        writable1.write("hello");

        Writable writable2 = s -> System.out.println(s);//ביטוי למדה
        writable2.write("hello");

        BinaryOperator multiplication=(x, y)->x*y; //פטרו אותנו מהמילה רטורנ
        BinaryOperator addition= (x, y) -> x+y;

        int z=multiplication.operate(5,7);//אובייקט נקודה שם הפונקציה
        System.out.println(z);

        BinaryOperator power=(x, y) ->{
           int sum=x;
            for (int i = 0; i <y-1 ; i++) {
                sum*=x;
            }
            return sum;
        } ;

        Point[] points={new Point(3,4), new Point(7,3), new Point(98,1)};
        Point p=new Point(7,3);
        //הפונקציה קונטיינס שולחת את הביטוי למדה בתור פרמטר, הצלחנו להעביר כפרמטר קטע קוד
        System.out.println(contains(points,p,(a, b) -> a.x==b.x&& a.y==b.y));

        //בלי הלמדה הקוד היה נראה ככה
        /*System.out.println(contains(points, p, new Equal() {
            @Override
            public boolean areEqual(Point a, Point b) {
                return  a.x==b.x&& a.y==b.y;
            }
        }));*/

        Button button=new Button();
        button.setListener(obj -> System.out.println("clicked"));


    }

    //מסוגלת לבדוק אם פויינט מסוים נמצא במערך של פויינטים ואתה צריך להגדיר לי מה זה שווה
    public static boolean contains(Point[] arr,Point z, Equal equal){
        for (int i = 0; i <arr.length ; i++) {
            if(equal.areEqual(arr[i],z))
                return true;
        }
        return false;
    }


}


class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

interface Equal{

    boolean areEqual(Point x,Point y);
}



interface Writable{
    void write(String s);
}

interface BinaryOperator{
    int operate(int x,int y);
}

//מקבל פרמטר מי לחץ על הכפתור
interface OnClickListener{
    void onClick(Object obj);
}

class Button{
    private  OnClickListener listener;

    public void setListener(OnClickListener listener){
        this.listener=listener;
    }

}
