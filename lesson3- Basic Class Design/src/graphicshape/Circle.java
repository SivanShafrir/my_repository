package graphicshape;

/**
 * Created by hackeru on 2/5/2017.
 */
public class Circle extends Shape {
    //שדות
    int x;
    protected int y;
    private int radius; // מכיוון שהוא מוגדר כפרייבט אין אפשרות לגשת אליו משום מקום מחוץ למחלקה
    //אם הוא מזהה שלא בנינו קונסטרקטור הוא בונה קונסטרקטור דיפולט שלא עושה כלום (למעט לאפס את השדות)
    public Circle(int x,int y, int radius){
        if (x>=0)
            this.x=x;
        if (y>=0)
            this.y=y;
        setRadius(radius);
    }
    public Circle(int radius){//למי שלא חשוב המיקום של המעגל ורק הגודל
        this(20,20,radius);
    }
    // בנאי שקורא לבנאי אחר- הקריאה לבנאי השני צריכה להיות בשורה הראשונה של הבנאי
    public Circle(){
        this(10);
    }



    @Override //כל מה שמתחיל ב@ זה הוראות לקומפיילר , אומר לקומפיילר שבכוונתי לדרוס
   /* public String toString() {
       return super.toString();// כמו TISH פויינטר לאובייקט עליו הופעלה המתודה אבל במקרה של ירושה סופר מתייחס לאבא ממנו אני יורש
       // מחזיר את הכתובת בזכרון שבו נמצא האובייקט כסטרינג (הכתובת בזיכרון לפעמים מספר בבסיס הקסאדצימלי)
       // בעצם מחזיר פה את מה שהאבא עושה ולכן אין הבדל אם נכתוב ככה או שלא נכתוב בכלל
    }*/
   // דרסתי את ההתנהגות של האבא שמחזיר כתובת בזיכרון ללהחזיר את פרטי המעגל
    public String toString() {
       return "center = (" + x +"," + y + ") and radius "+ radius;
    }
    @Override
    public double area(){//מטודה
        return Math.PI*radius*radius;// נותן את שיטחו של המעגל
    }

    @Override
    public double perimeter() {
        return 2*Math.PI *radius;
    }

    public void fillColor(int red, int green, int blue){// הגדרת צבע ע"י שלושת הצבעים הבסיסיים

    }

    public void fillColor(float hue, float saturation, float brightness){
        //fillcolor float float float חתימה של הפונקציה שלפיה הוא מבדיל בין הפונקציות עם אותו שם
    }

    /**
     *
     * @param radius non negative radius lengh
     */
    public void setRadius(int radius) {
        if (radius>=0)
            return;
        this.radius = radius;
    }
}
