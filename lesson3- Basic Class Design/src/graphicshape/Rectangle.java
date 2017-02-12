package graphicshape;

/**
 * Created by hackeru on 2/6/2017.
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width,int height) {
        setWidth(width);
        setHeight(height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width>=0)
            this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height >= 0)
            this.height = height;
    }
    //שטח
    @Override
    public double area(){
        return width*height;
    }
    //הקף
    @Override
    public double perimeter() {
        return 2*(width+height);
    }
}
