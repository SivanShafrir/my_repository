package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.security.InvalidParameterException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        File file=new File("C:\\New folder\\MyFile.txt");//הנתיב לקובץ או לתקייה כל שהיא
        // קיומו של אובייקט מסוג פייל לא אומר שקיים באמת קובץ כזה במערכת הקבצים במחשב
        String s="hello \nworld";// ירידת שורה בהדפסה
        String s1="hello \\word";// אם רוצים להדפיס קו נטוי צריך לשים פעמיים קו נטוי
        System.out.println(s);
        //System.out.println(file.exists());//אומר אם הקובץ קיים
        OutputStream outputStream=null;
        try {
            outputStream= new FileOutputStream(file);//יוצר קובץ מחדש
            //כותב לקובץ שבנתיב שלמעלה וכל פעם שעושים מחדש הוא כותב מחדש
            outputStream.write("zofiya".getBytes());//יש לו מתודה של כתיבה, יצירת אובייקט, כל תו בסטרינג הוא בית
            outputStream.write(" ".getBytes());
            outputStream.write("shuker".getBytes());//הגודל של הקובץ טקסט הוא כמספר הבתים בקובץ

        } catch (FileNotFoundException e) {//אם הקובץ לא נמצא
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream!=null)//למה שהוא יהיה נאל אם יצרנו חדש, כיוון שאם התהליך נכשל הוא נאל
                try {
                    outputStream.close();//כי הסגירה עצמה יכולה להיכשל
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }


        //קריאה מהקובץ
        InputStream inputStream=null;
        try{
            inputStream=new FileInputStream(file);
            //הבעיה שקוראים שלא יודעים מראש כמה בתים יש בקובץ
            byte[] buffer= new byte[4];//לבחור באפר שהוא 2 בחזקת משהוא
            //ריד קורא כל עוד יש משהוא בקובץ, כותבת לתוך המערך
            //אבל יש בעיה אי אפשר לתת לה בדיוק בגודל שרוצה לכתוב כי לא יודעים כמה יש
            //הפונקציה ריד מחזירה אינט- כמה היא כתבה בפועל במערך
            /*int actuallyRead= inputStream.read(buffer);//אמרוה לתת מערך של בייתים ומבקשת לקבל מערך של בייתים שתכתוב עליו
            if(actuallyRead!=-1){
                String s2=new String(buffer, 0, actuallyRead);//הופך בייטים לסטרינג ואומרים לו מאיפה להשתמש
                System.out.println(s2);
            }*/

            //כאן מגדירים אקטואלריד שיגדל כל פעם ביחס לגודל הקובץ
            int actuallyRead;
            StringBuilder stringBuilder=new StringBuilder();
            while ((actuallyRead=inputStream.read(buffer))!=-1){
                //בונה סטרינג על סמך הבאפר
                stringBuilder.append(new String(buffer,0,actuallyRead)); //יהיה לנו סטרינג שהוא בדיוק מה שחסר
            }
            System.out.println(stringBuilder.toString());//מדפיס את מה שהיה בקובץ
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            whiteInTxtInt();
            reverseWords(file);
        }

        int [] arr= new int[0];
        try {
            arr = kBiggest(3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
        for (int i = 0; i < 3; i++)
            System.out.print(arr[i]+  ", ");

    }

/*1.	לכתוב פונקציה סטטית שלא מקבלת פרמטרים, שיוצרת קובץ במחשב שלי שבמקום לכתוב בו סטרינג תכתוב בו אינטים,
הפונקציה תכתוב לקובץ כמות אקראית וגדולה שלא אינטים והמספרים יהיו אקראיים (random)
    בין מאה אלף ל200 אלף אינטים*/


    public static void whiteInTxtInt() {
        int num;
        int num1;
        File file1 = new File("C:\\New folder\\MyFile1.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file1);
            Random random = new Random(System.currentTimeMillis());
            num1 = random.nextInt(10000) + 10000;//מחזיר מספר בין 100000 ל20000 כיון שמגריל מספר בין 0 ל10000 ועליו מוסיף עוד 10000
            for (int i = 0; i < num1; i++) {
                num = random.nextInt(10000);
                byte[] aBytes = new byte[4];
                ByteBuffer.wrap(aBytes).putInt(num);
                for (int j = 0; j < 4; j++) {
                    outputStream.write(aBytes[j]);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();

                }
        }
        System.out.println(maxInt(file1));
    }



/*2.	פונקציה נוספת סטטית תקרא את הקובץ ותחזיר אינט שהוא האינט הכי גדול בקובץ, מה המספר הכי גדול בקובץ*/
    public static int maxInt(File file) {
        byte[] buffer = new byte[4];
        int b;
        int actuallyRead;
        int max = 0;
        try {
            InputStream inputStream = new FileInputStream(file);
             //input strem.read=מכניסה לתוך הבאפר ומחזירה לאינט כמה קראה
            while ((actuallyRead = inputStream.read(buffer)) != -1) {
                if(actuallyRead!=4)
                    throw new InvalidParameterException("עבדת עלי זה בכלל לא מספרים");//אם הוא לא כפולות של 4 אז בסוף אם הוא יתן פחות מ4 זה אומר שזה לא אינט
                b = ByteBuffer.wrap(buffer).getInt();
                if (b > max)
                    max = b;
            }
            return max;

        } catch (IOException e) {
            e.printStackTrace();
        }

//לכתוב פןנקציה סטטית ויוד שלא מקבלת פרמטרים שיוצרת קובץ במחשב שלי במקום לכתוב בו סטרינג לכתוב בו אינטים הפונקציה תכתוב לקובץ כמות אקראים וגדולה של אינטים והאינטים עצמם הם מספרים אקראים בין 100 אלף ל200 אלף
//פונקציה סטטית שתקר את הקובץ ותחזיר אינט למס הכי גדול בקובץ
//הפונקציה תקבל פרמטר ק ותצטרך להחזיר מערך של ק האיברים הכי גדולים בקובץ
//פונקציה שמקבלת סטרינג וכותבת אותה לקובץ
        return 1;
    }


/*3.	הפונקציה תקבל פרמטר k ותצתרך להחזיר מערך של k האינטים הכי גדולים בקובץ.*/
static int[] kBiggest(int k) throws FileNotFoundException {
    File filet = new File("C:\\Users\\hackeru\\Documents\\sivan shafrir\\temp6.txt");
    OutputStream outputStream = null;
    InputStream inputStream = null;
    byte[] buffer=new byte[4];
    try{
        outputStream=new FileOutputStream(filet);
        inputStream=new FileInputStream(filet);
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 30; i++) {
            int rnd = random.nextInt(50);
            System.out.print(rnd);
            System.out.print(",");

            ByteBuffer.wrap(buffer).putInt(rnd);
            outputStream.write(buffer);
        }
        int []arr= new int[k];
        for (int i = 0; i < k;  arr[i++] = 0);
        int actuallyRead;

        while ((actuallyRead=inputStream.read(buffer))!=-1){
            if(actuallyRead!=4)
                throw new InvalidParameterException();
            int temp=ByteBuffer.wrap(buffer).getInt();
            int min = Integer.MAX_VALUE;
            int pos = 0;
            for (int i = 0; i < k; i++) {
                if(arr[i]<min){
                    min = arr[i];
                    pos = i;
                }
            }
            if(min < temp){
                arr[pos] = temp;
            }
        }
        return arr;
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if(outputStream != null)
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    return null;
}


   /* 4.	פונקציה שמקבלת סטרינג וכותבת אותו לקובץ, ונכתוב עוד פונקציה בעבור אותו קובץ שתהפוך את הסדר של הסטרינג.*/
    //רוורס לכל מילה בקובץ
    //בוואן בית יש ערך של בית אחד כל פעם
    //בצאר סי יש כל פעם את התו הבא
    //עושים עוד פור בשורה בסוף הטראי כדי שיכניס לנו גם את המילה האחרונה
    public static void reverseWords(File file){
        File tempFile = new File("C:\\New folder\\temp.txt");
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(tempFile);
            char[] chars = new char[50];
            int wordLength = 0;
            int oneByte;
            while((oneByte = inputStream.read()) != -1){
                byte b = (byte)oneByte;
                char c = (char)b;
                if(c == ' '){
                    for (int i = wordLength-1; i >= 0; i--) {
                        outputStream.write(chars[i]);
                    }
                    outputStream.write(' ');
                    wordLength = 0;

                }else{
                    chars[wordLength] = c;
                    wordLength++;
                }
            }
            for (int i = wordLength-1; i >= 0; i--) {
                outputStream.write(chars[i]);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    }


