package graphicshape;

/**
 * Created by hackeru on 2/7/2017.
 */
public class Point {

    //לא יכולה להיות במחלקה הזאת בעיה של אלייסים כיון שהמשנים שלה פרימיטיבים וזה BYVALUE

    private int x;
    private int y;

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }
    // בנאי העתקה נותנים לו פוינט הוא משכפל אותו
    //הפויינט החדש שנוצר זהה בערכיו לפוינט שנשלח
    public Point(Point other){
        this.x=other.x;
        this.y=other.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }//מעתיק את הX לX של המחלקה

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + commaSeparated()+ ")";
    }
    //מופרד עי פסיק
    //מטפל בתוך הסוגריים
    protected  String commaSeparated(){
        return  x + "," + y;
    }
}
