package graphicshape;

/**
 * Created by hackeru on 2/5/2017.
 */
public class Canvas {

    void draw(){
        Circle c= new Circle();
        c.x=120;// בפאקטג אחר לא ניתן לגשת לX כיוון שהוא דיפולט ופה כן ניתן

    }

    void refreshAll(Shape[] shapes){
        for (Shape shape: shapes)
            shape.refresh();
    }
}
