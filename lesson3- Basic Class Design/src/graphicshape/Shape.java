package graphicshape;

/**
 * Created by hackeru on 2/5/2017.
 */
//אבסטרקט לא יכול במפורש ליצור אובייקטים ממחלקה אבסטרקטית
//כל מי שיורש ממנו חייב לממש את כל פונקציות האבסטרקטיות
//אם המחלקה היורשת עצמה היא גם אבסטרקטית אז לא חייבת לממש את הפונקציות שלו החובה עוברה למחלקה שיורשת ממנו
public abstract class Shape {
    public final void refresh(){//פיינל לפני פונקציה אומר שלא יהיה אפשר לדרוס את המתודה הזאת
        System.out.println("refreshing");
    }

    //
    public abstract double area();


    public abstract double perimeter();
}
