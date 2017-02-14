package com.company;
//1.Static nested class
//מחלקה מקוננת סטטית אפשר במיין ליצור אובייקט מסוג קולור
//Shape.Color myColor= new Shape.Color(34,45,100);
//לא נותן כלום למעט אירגון וסדר
//פה אי אפשר להתייחס למשתנים של שייפ מתוך המחלקה קולור כי הם לא קשורות בעצם
/**
 * Created by hackeru on 2/12/2017.
 */
public class Shape {

    private Color color=new Color(4,6,2);//בתוך המחלקה אפשר להשתמש ללא הנקודה שייפ לפני הקולור

    public static class Color{
        private int red, green, blue;

        public Color(int red, int green, int blue) {
            this.red = red;
            this.green = green;
            this.blue = blue;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getGreen() {
            return green;
        }

        public void setGreen(int green) {
            this.green = green;
        }

        public int getBlue() {
            return blue;
        }

        public void setBlue(int blue) {
            this.blue = blue;
        }
    }
}
