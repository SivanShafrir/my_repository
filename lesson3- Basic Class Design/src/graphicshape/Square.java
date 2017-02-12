package graphicshape;

/**
 * Created by hackeru on 2/6/2017.
 */
//אם שמים פיינל ז"א שאף מחלקה לא יכולה לרשת ממנה
public final class Square extends Rectangle {

    public Square(int side) {
        //לא בודק שהסייד גדול מ0 כי הקונסטרקטור של האבא בודק את זה
        super(side, side);//הפעלנו את הקונסטרקטור של האבא- המלבן חייב להיות שורה ראשונה
    }

    public void setSide(int side) {
        super.setHeight(side);
        super.setWidth(side);
    }

    public int getSide() {
        return getHeight();
    }

    @Override
    public void setWidth(int width) {
        setSide(width);
    }

    @Override
    public void setHeight(int height) {
        setSide(height);
    }


}
