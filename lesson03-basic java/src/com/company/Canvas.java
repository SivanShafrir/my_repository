package com.company;

/**
 * Created by hackeru on 2/1/2017.
 */
public class Canvas {
    private boolean [][] canvas;

    public Canvas(int width, int height){
        canvas=new boolean[height][width];
    }
    // משרטטת את המלבן בזיכרון, משנה במטריצה * במקום TRUE ורווח במקום FALSE
    public void drawRectangle0(int x,int y, int width,int height){
       int col=0, row=0;
        for (int i = 0; i < y; i++)
            //System.out.println();// ירד שורה ולכן צריך במקום זה לקדם שורה
            row++;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < x; j++)
                //System.out.print(" "); כל הדפסה של רווח זה תזוזה ימינה לכן מקדמים את העמודות
                col++;
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1)
                    canvas[row][col] = true;//צריך להתקדם לעמודה הבאה
            col++;//צריך לקדם בין אם מדפיסים * לבין אם מדפיסים רווח
            }
            //System.out.println();במקום ההורדת שורה צריך לקדם את השורות
            row++;
            col=0;// צריך לאפס את העמודות
        }

    }
    // הולך ישר למקומות של ה* בלי המקומות שיש בהם רווח
    public void drawRectangle (int x,int y, int width,int height){
       //מצייר את השורות
        for (int i = 0; i <width ; i++) {
            canvas[y][x+i]=true;//שורה ראשונה
            canvas[y+height][x+i]=true;// שורה אחרונה
        }
       //מצייר את העמודות
        for (int i = 0; i <=height ; i++) {
            canvas[y+i][x]=true;//עמודה ראשונה
            canvas[y+i][x+width]=true;//עמודה אחרונה
        }
    }

    //  אתגר!! עושים בהמשך הקורס פונקציה שמשרטטת מעגל
    public void drawCircle(int a, int b, int radius){//A וB מרכז המעגל
      //(x,y) נקודה כלשהיא במערכת  צירים רוצים לדעת מתי היא נמצאת על המעגל
      // radius^2=(x-a)^2+(y-b)^2 לפי הנוסחא הזאת בודקים את הנקודה לעיל נמצאת על המעגל
      // צריך לאפשר סטיה קלה כי אי אפשר לעשת ממש שווה
    }
    //פונקציה שפולטת למסך
     public void render(){
         for (int i = 0; i <canvas.length ; i++) {
             for (int j = 0; j <canvas[i].length ; j++) {
                 System.out.print(canvas[i][j]?"*": " ");
             }
             System.out.println();
         }
     }

}


