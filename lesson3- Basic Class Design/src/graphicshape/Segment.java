package graphicshape;

/**
 * Created by hackeru on 2/7/2017.
 */
public class Segment {

    private Point p1,p2;
    private double length;// תשמור את האורך של הסיגמנט
    private boolean isLengthCalculated;//דגל ששומר אם הגדרנו נקודה חדשה בגלל שהפונקציה של חישוב האורך זה פעולה יקרה ולא כל פעם אני מעוניינת לחשב את האורך

    public Segment(Point p1, Point p2) {
       setP1(p1);
       setP2(p2);
    }

    public Point getP1() {
        return new Point(p1) ;//    משתמש בקופי קונטרקטור של פוינט- הגנה מפני אלייסניג - לא ידידותי לזיכרון -מחזיר העתק של P1
    }

   // public Point getP1() {
    // return new Point(p1.getX(),p1.getY());// אם לא היה לפוינט קופי קונסטרקטור אז הקוד היה נראה כך:

    public Point getP2() {
        return p2;
    }//מספר למישהוא מבחוץ מה הערך של הP2

    public void setP1(Point p1) {
        //this.p1 = p1;
        this.p1= new Point(p1);//מגן מפני אלייסינג כי הוא מחייב ללכת לקופי קונסטרקטור של הפוינט
        isLengthCalculated = false;//כל פעם שמגדירים נקודה הדגל שווה לפולס ואז ילך שוב לחישוב המרחק
    }

    public void setP2(Point p2) {
        this.p2 = p2;
        isLengthCalculated = false;// כל פעם שאני מעדכנת את הנקודה משנה את הערך של הדגל ל FALSE כלומר שהנתון של האורך לא מעוכן וכאשר אני כן רוצה את האורך בודקת האם הנתון הזה מעודכן או צריך לחשב אותו
    }

   // מציאת מרחק בין 2 נקודות שבפרט זה הקצוות של סיגמנט
    public void calculateLength(){
        int deltaY=p1.getY()-p2.getY();
        int deltaX=p1.getX()-p2.getX();
        length= Math.sqrt(deltaX*deltaX+deltaY*deltaY);//אפשר להציב אינט בדאבל אין חשש לאיבוד מידע
        isLengthCalculated = true;
    }
    //פונקציה שמחשבת שיפוע
    public double slope(){
        double deltaY=p1.getY()-p2.getY();
        double deltaX=p1.getX()-p2.getX();
        if(deltaX==0) //// על שיפוע אנכי הפונקציה לא עובדת לא ניתן לדבר במתמטיקה על שיפוע אנכי
           return Double.MAX_VALUE;//אם דלתהאיקס שווה ל0 אז הישר עולה בצורה אין סופית ולכן מחזירים ערך גדול מאוד (לא נכון מתמטית)
        return deltaY/deltaX;
    }

    public double getLength() {
        if(!isLengthCalculated)
            calculateLength();
        return length;
    }

    //נקודות למציאת קו ישר A B C
    //y=mX+n נוסחאות ישר
    // -mx+1y-n=0
    //ax+by+c=0
    //מקדם של הX- השיפוע של הקו
    /**
     * the line that goes through the two points p1, p2
     * that determine this segment can be represented
     * as Ax + By + C =0
     * @return returns the A of the equation
     */
    public double A(){
        return -1*slope();// מחזיר שיפוע-M כפול ל-1
    }
    //מקדם של הY
    public double B(){
        return 1;
    }
    // מציאת הN- המרחק מציר הX
    // N = MX-Y
    public double C(){
       return slope()*p1.getX()-p1.getY(); // סלופ זה M כפול הX מינוס הY
    }
    //d= |Ax1+By1+c|/sqrt(A^2+B^2)
    //מציאת מרחק בין נקודה לישר
    public double distanceToPoint(Point point){
        double A=A();//שומרים במשנה כי A מופיע כמה פעמים וA קורא לסלופ (פונקציה מסובכת) לא רוצה שיקרא לה כמה פעמים
        double numerator= A*point.getX()+B()*point.getY()+ C();// מונה של הנוסחא
        if (numerator<0)
            numerator*=-1;//כיוון שהנוסחא זה בערך מוחלט
        double denominator= Math.sqrt(A*A +B()*B());
        //B()*B()==1
        return numerator/denominator;
    }

}
