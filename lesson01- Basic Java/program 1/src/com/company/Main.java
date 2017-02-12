package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("walcome to hackeru");

        byte myByte; // -128 to 127= 256
        myByte = 100;
        short myShort = 120; //2 bytes
        int myInt; // 4 bytes 32 bit
        long myLong = 4234234L; // 8 bytes שמים L כדי שמההתחלה המספר יחשב כלונג ולא אינט
        myByte = 127;
        myByte++;
        macpela(3,7);
        mana(7,3);
        System.out.println("fib=" +fib(10));

        System.out.println(myByte);

        float myFloat = 123.4f; // 4 bytes

        double myDouble = 123.4; // 8 bytes





        int x = 5;
        x = 5 + 3 + 1;

        char myChar = 'c';
        boolean myBoolean = true;
        myBoolean = 5 <= 7; // מחזיר TRUE
        myBoolean = 5 < 7 && 7 % 2 == 0; // אם התנאי הראשון שקר אז הוא לא ממשיך לבדוק את התנאי שני... לכן כדי לשים את התנאי עם ההסתברות יותר גדולה בהתחלה
        myBoolean = 5 < 7 || 7 % 2 == 0; // אם התנאי הראשון אמת הוא לא ממשיך לבדוק את התנאי הבא
        myBoolean = (5 < 7 && 8 < 10) || 3 != 5; // במקרה כזה עדיף לשים סוגריים על מה שרוצים שיבדק קודם
        //2* (3+4)= 2*3+2*4
        boolean a = false, b = true;
        boolean c = !(a || b); // הביטוי השקול שלו זה עם "וגם" ולא עם "או" הביטוי השקול בשורה הבאה
        c = !a && !b;
        boolean d = !(a && b); // הביטוי השקול שלו זה עם "או" ולא עם "וגם" הביטוי השקול בשורה הבאה
        d = !a || !b;
        if (5 < 7)
            System.out.println("5 is less than 7");
        else
            System.out.println("5 is greater than or equal to 7");

        x = 0;
        while (x < 10) {
            System.out.println("x =" + x);
            x++;
        }

        for (int i = 0; i < 10; i++)
            System.out.println("i =" + i);
        //כל ללואת פור יכול להיות ללואת וויל וכן להפך, אם כמות האיטרציות ידועה מראש עדיף לולאת פור ואם כמות האיטרציות לא ידועה עדיף וויל (כלל אצבע)

        System.out.println("1" + 1);//11
        System.out.println("1" + 1 + 1);//111
        System.out.println(1 + 1 + "1");//21
        System.out.println("1" + (1 + 1));//12


        //מערכים
        int[]h ={4,7,1,3,6,8};
        h[0]=15;
        int[] j =new int[6];
    }

        static int distance (int x, int y){
        int result= x-y;
        if (result<0)
            result *= -1;
        return result;
    }
        static int macpela (int x, int y) {
            int result = 0;
            int small=x;
            int large=y;
            if (x>y)
            {
                small=y;
                large=x;
            }

            for (int i = 0; i < small; i++)
                result += large;
            System.out.println("macpela " + result  );
            return result;
        }
          // מכפלה עם לוג צעדים
        static int product(int x,int y){
            // x*y=2*x*0.5*y=2*0.5*x*y=x*y
            int result =0;
            int counter=0;
            while (y>0){
                counter++;
                if(y%2==0){//בודק את Y זוגי
                    y=y>>1;//מחלק ב2 זה לא משנה את התוצאה כי את X הכפלנו ב2 ואת Y חילקנו ב2
                    x=x<<1;//מכפיל ב2
                }
                else{
                    y--;
                    result+=x;// מקטינים ב1 ומוסיפים בצד את הX ולכן לא שינינו את התוצאה: 7*3 0, 7*2 7, 7*1 14, 7*0 21

                }
            }
            return result;
        }

        static int mana (int x, int y){
            if (y==0)
                return -1;
            int result=0;
            int ezer= y;
            while (ezer < x){
                result++;
                ezer+= y;
            }

            System.out.println("mana= "+ result);
            return result;
        }
        static int sheetit (int x, int y){
            if(y==0)
                return -1;
            return distance(x, macpela(mana(x,y),y));
        }

        static int power (int x, int y){
            if(x==0){
                if(y==0)
                    return -1;
                return 0;
            }
            if(y==0||x==1)
                return 1;
            int result =x;
            for(int i=1;i<y;i++)
                result*=x;
            return result;
        }

        static int power2(int x,int y){
            if(x==0){
                if(y==0)
                    return -1;
                return 0;
            }
            if(y==0||x==1)
                return 1;
            return power2(x,y-1)*x;

        }
        static int power3(int x,int y){
            if(x==0){
                if(y==0)
                    return -1;
                return 0;
            }
            if(y==0||x==1)
                return 1;
            if (y%2==0) {//(y&1)!=1
                int temp=power3(x,y/2);//כשהY זוגי אז כשמחלקים ב2 אין שארית
                return temp*temp;
            }
            else{
                int temp=power3(x,(y-1)/2);//כשY איזוגי אז מורידים 1 ואז מחלקים ב2
                return temp*temp*x;// את ה1 שהורדנו מכפילים בX כי הורדנו 1 מהחזקה
            }

        }
        static int sqrt(int x){
            int result=0;
            while (result*result<x)
                result++;
            return result;
        }

        static int fib(int n){
            if(n==1||n==2)
                return 1;
            //return fib(n-1)+fib(n-2);  לא יעיל חוזר על תתי עצים הרבה פעמים סדר גודל של 2 בחזקת N
            int a=0;// סדר גודל של טטה של N
            int b=1;
            int c;//משתנה זמני
            for (int i = 2; i <= n; i++) {
                c=a+b;
                a=b;
                b=c;
            }
            return b;
        }




}
