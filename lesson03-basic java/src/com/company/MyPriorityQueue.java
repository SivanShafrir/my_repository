package com.company;

import java.security.InvalidParameterException;

/**
 * Created by hackeru on 2/2/2017.
 */
// מחלקה שמייצגת תור קדמויות
    public class MyPriorityQueue {
       private int[]arr;
       private int size;// כמה איברים בפועל השתמשנו במערך

    public MyPriorityQueue(){
        arr=new int[10];
        size=0;
    }

    //קונסטרקטור עם מערך שקיבלנו
    public MyPriorityQueue(int[] arr){
        this.arr = arr;//שמנו את הכתובת שנתנו במשתנה ARR
        size=arr.length;
        for (int i = size/2; i >=0 ; i--) {//לולאה שהולכת מהאמצע אחורה כיוון שמSIZE/2 כולם עלים וגם ככה הם ערימה חוקית
            heapify(i);
        }
    }

    //מתקנת פגם בתנאי שהפגם מוגבל- פגם בערימות מקסימום
    // הIF בודק אם הבן השמאלי גדול ממני אם כן הוא הגדול עכשיו
    // םIF השני אם הבן הימני גדול ממנו ז"א שהוא גדול משניהם
    //הIF השלישי האם אחד מהבנים שלי גדול ממני אני מתחלף עם הבן הגדול
    //זמן הריצה זה לוג N
    private void heapify(int i){//מתקן כלפי מטה את העץ
        int largest = i;
        int l = leftChild(i);//מטעמי נוחות מגדירים משתנה עזר
        int r = rightChild(i);
        if(l<size && arr[l] > arr[largest])
            largest = l;
        if(r<size && arr[r] > arr[largest])
            largest = r;
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(largest);
        }
    }
    //הפוך מהיפיפייל יש פה איבר שהוא גדול מאביו וההנחה היא שאח שלו ערימת מקסימום חוקית
    private void bubbleup(int i){//מתקן כלפי מעלה את העץ
        int p;//אבא
        //  כל עוד לא הגעתי לשורש וגם (מותר לבצע השמה בתוך הביטוי הבוליני) שמים בP את הערך של PARENT-I ושואלים אם האבא קטן מהבן(יש כאן הפרה של חוקי ערימת מקסימום)
        while (i!=0&& arr[(p=parent(i))]<arr[i]) {
            int temp=arr[i];
            arr[i]=arr[p];
            arr[p]=temp;
            i=p;
        }
    }
    //הבן השמלי של איבר I
    private int leftChild(int i){
        return 2*i+1;
    }

    private int rightChild(int i){
        return 2*i+2;
    }
    //מציאת האבא
    private int parent(int i){
        return (i-1)/2;
    }

    // מקבלת מיקום של איבר קיים ומגדילה את ערכו
    // פבליק מאפשר שירות כלפי חוץ- רוצים בעודו בתור והמצב החמיר רוצים לעדכן את מקומו למקום יותר טוב
    public void increase(int i, int addition){// הI זה המיקום הישן ואדישיין זה ההוספה הנצרכת
       if(addition<0|| i>=size|| i<0)//אם זה לא הגדלה ואו I גדול מהגודל
          throw new InvalidParameterException();//אומר שאחד הפרמטרים לא בסדר
       arr[i]+=addition;
       bubbleup(i);
    }

     //פונקציה שתקבל מקום של איבר קיים ותמחק אותו מהמערך
    public void delete(int i){
        increase(i, Integer.MAX_VALUE- arr[i]);// קובעים את ערכו של האיבר במקום הI להיות מאקס וכתוצאה מכך קפץ להתחלה
        // השתמשנו בחיסור כדי שלא תהיה גלישה כיון שמוסיפים את המספר המקסימלי למספר קיים ולכן כדי שלא תהיה גלישה מורידים
        extractMax();// הוצאנו אותו מהרשימה
    }

    //פונקציית הוספת איברים (ותאים) למערך
    // אם אין מקום יותר במערך, אז אני יוצרת מערך חדש ומגדילה אותו בצורה פרופורציונלית
    //  הזמן ריצה שלו זה o(1
    //לא נכנסים ללואה הרבה כי זה גדל באופן פרןפורציונלי
    public void insert(int x){
        if (size==arr.length){
            int[] temp= new int[size*2];//גדילה פורפורציונאלית יחסית למה שהשתמשנו
            for (int i = 0; i <size ; i++) {
                temp[i]=arr[i];
            }
            arr=temp;// משנים שהARR יצביע גם על המערך TEMP שהגדלנו
        }
        // arr[size++]=x; //כיוון שSIZE מכיל כמה איברים תפוסים במערך אז שמים במקום הפנוי הבא ומקדמים למקום הבא
        int i=size;//סייז מצביע על המקום שלפני הפנוי במערך/עץ
        size++;
        arr[i]=x;//צריך לבדוק אם הוא גדול מהאבא שלו
        bubbleup(i);//מתקן את העירמה מעלה את האיבר שהוספנו למקום שאמור להיות כל עוד הוא גדול מהאבא שלו בערימה
    }
    //מחזירה את המקסימלי בתור
    public int getMax(){
        if(size==0)
            throw  new IndexOutOfBoundsException();
        int result= arr[0];
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] > result)
                result = arr[i];
        }
        return result;
    }

    //פונקציה שמוציאה את המאקס מהתור וגם אומרת מי המקסימום
    public int extractMax(){
        if(size==0)
            throw  new IndexOutOfBoundsException();
       /*int indexOfMax=0;
        int result= arr[0];
        for (int i = 0; i <size ; i++) {
            if (arr[i] > result) {
                result = arr[i];
                indexOfMax=i;
            }
        }
        for (int i = indexOfMax; i <size-1 ; i++) {//דורסת את האיבר המקסימלי ומעתיקה את כל האיברים מהמיקום של המקס עד הסוף
            arr[i]= arr[i+1];
        }
        size--;//כי הורדנו את המקסימום
        return result;*/
       //
       if(size==1){// אם המערך בגודל 1 אז מחזירה את האיבר הראשון ומקטינה את המערך ל0.
            size--;
            return arr[0];
        }
        int max=arr[0];//הוצאנו את האיבר הראשון שהוא האיבר הגדול ביותר במערך בערימה חוקית
        arr[0]=arr[size-1];//העברנו את האיבר האחרון להיות הראשון ובעצם קילקלנו את הערימה
        size--;// הקטנו את הגודל של המערך כי האיבר הראשון יצא
        heapify(0);// שולחים להיפיפייל כדי לתקן את הערימה
        return max;//מחזירים את המאקס
    }

    // פונקציה שמחזירה כמה איברים בפועל נכנסו לתור
    //כדי שמישהוא מבחוץ יוכל לדעת כמה איברים בתור... אפילו שהוא הכניס את האיברים
    public int getSize(){
        return size;
    }
}
