package graphicshape;

import java.util.InvalidPropertiesFormatException;

/**
 * Created by hackeru on 2/7/2017.
 */
public class Parallelogram extends Shape {
    private Point p1, p2, p3, p4;



//אנו רוצים לוודא שהנקודות מתקבלות קלוק וויז
    /**
     * make sure that p1p2 is equal in length and parallel to p3p4
     * and  p1p3 is parallel to p2p4
     * throws exception otherwise
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     */
    public Parallelogram(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;

        // בדיקה האם 2 השיפועים מקבילים - האם P1 P2 מקביל ל P3 P4 ולהיפך
        Segment seg1 = new Segment(p1,p2);
        Segment seg2 = new Segment(p3,p4);
        if (seg1.slope() !=seg2.slope()||
                seg1.getLength() != seg2.getLength()) //בדקתי שניתן לבנות פה מקבילית
            throw  new IndexOutOfBoundsException("no a parallelogram");
        Segment seg3 = new Segment(p1,p3);
        Segment seg4 = new Segment(p2,p4);
         if(seg3.slope() != seg4.slope())
             throw  new IndexOutOfBoundsException("no a parallelogram");




        // המחלקה פוייט לא תומכת בקודינאטות מסוג דצימאל
        //אנחנו צריכים לעשות סידרה של בדיקות כדי לדעת איך לבנות את המקבילית מארבע הנקודות האלה
        //
    }


    //לא טוב כי אני לא יודעת למי לחבר את הצלע הרביעית - קונסטרקטור לא טוב
    /* public Parallelogram(Segment seg1, Segment  seg2) {
       if (seg1.slope() != seg2.slope())
            throw new IndexOutOfBoundsException("seg1 and seg2 must be prallel");
            this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }*/


    @Override
    public double perimeter() {
        Segment segt1 = new Segment(p1,p2);
        Segment segt2 = new Segment(p2,p4);
        return  2* (segt1.getLength() + segt2.getLength() );
    }

    @Override
    public double area() {
        return super.area();
    }
}
