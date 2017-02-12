package com.company;

/**
 * Created by hackeru on 2/8/2017.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "("+x+ ","+ y+")";
    }
     //צריך להחזיר אמת את האובגקט שקיבלנו שווה לאובייקט שהפעיל את המתודה
    @Override
    public boolean equals(Object obj) {
        if (obj==null)
            return false;
        //שואל אם זה אותה כתובת בזיכרון אז ברור שהשדות שוות כי אנחנו אותו אובייקט
        if (obj==this)//הTHIS זה האובייקט שקרא למתודה, סוג של פויינטר לאובייקט בו אני נמצא
            return true;
        if(obj instanceof Point){//עכשיו מדברים ספציפית על אובייקט מסוג פוינט
           Point other= (Point)obj;//אזר וOBJ שני פוינטרים לאותו אובייקט
           return this.x==other.x&&this.y==other.y;
        }
        return false;//בכל מקרה אחר תחזיר שקר
    }
}
