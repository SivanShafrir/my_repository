package com.company;

import graphicshape.Circle;

/**
 * Created by hackeru on 2/5/2017.
 */
public class Ball extends Circle{

    void bounce(){// פונקציית קפיצה
        //System.out.println(x);// אי אפשר לגשת כיוון שזה דיפולט
        System.out.println(y);// הY מוגדר כפרוטקטד ולכן הוא מזהה אותו פה (כיון שהוא חושף את עצמו לירושה מפאקטג אחר

    }
}
