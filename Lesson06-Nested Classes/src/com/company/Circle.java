package com.company;
//2.inner class
//מחלקה מקוננת פנימית אותו דבר כמו המקוננת סטיטית רק בלי המילה סטטי
//ההבדל בינהם הוא עצום
//בלי סטטי עצם קיומה של המחלקה משויך לאינסטנס-אובייקט ספציפי מסוג סירקל
//המחלקה עמצה נוצרה ספציפית בעבור אובייקט מסוג סירקל מסויים כל אובייקט סירקל שיווצר תיווצר מחלקה פויינט משל עצמו
// (לאותו סירקל) בלי קשר אם את יוצרת פוינט או לא
//אם רוצים ליצור במיין אובייקט של פויינט חייב ליצור קודם אובייקט של סירקל
//התועלת בו שאפשר להתייחס לאובייקט המכיל שממנו נוצרה המחלקה ז"א בדוגמא אובייקט מסוג פויינט יכול להתייחס לאובייקט מסוג סירקל שהוא הפוינט שלו
// המחלקה פוינט עצמה נוצרה ספציפית בעבור אובייקט מסוג CIRCLE מסויים כל CIRCLE שיווצר תיווצר מחלקה פוינט משל עצמה לאותו CIRCLE בלי קשר אם את יוצרת אובייקט מסוג פוייט או לא
//פה אפשר להתיחס  מפוינט למשתנים של עיגול כי המחלקה לא סטטית, נוצר לי אובייקט מסוג פויינט לכלל עיגול ולכן יש לי תמיד מצביע מסוג עיגול
//התועל שאפשר להתייחס לאובייקט המכיל שממנו נוצרה המחלקה בדוגמא שלנו: אובייקט מסוג פויינט יכול להתיחס לאובייקט מסוג עיגול שהוא המרכז שלו
//מתוך אובייקט של סירקל אי אפשר לפנות לקלאס פוינט כי לא יודע איזה אובייקט לעומת זאת קלאסס פוטינט יכול להתייחס לאובייקט מסוג סירקל
//אם אין לי אובייקט מסירקל אי  אפשר ליצור אובייקט מסוג פוינט
/**
 * Created by hackeru on 2/12/2017.
 */
public class Circle {

    private Point center;
    private int radius;
    private int z;


    public class Point{
        private int x,y;
        private int z;

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
        public int getRadius(){//אפשר לגשת לרדיוס מתוך הפויינט
            return radius;
        }

        public int getZ(){
            //return z;//הזד של הפויינט
            //return this.z// עדיין הזד של הפויינט
            return Circle.this.z;//עכשיו ילך לזד של הסירקל

        }

        @Override
        public String toString() {
            return "(" + x +","+ y +")";
        }
    }

    public Circle(int x, int y, int r) {
        this.radius = r;
        this.center = this.new Point(x,y);
    }
    public Circle(){
        this(0,0,0);
    }

    @Override
    public String toString() {
        return "radius:" + radius + "center:"+ center;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
