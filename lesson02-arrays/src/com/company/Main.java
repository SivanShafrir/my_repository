package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	int[] arr={3,6,2,5};
	//System.gc();// אוסף את כל הזבל ולכל אובייקטים שאין מצביע אליהם הוא מוחק אותך
	int[] arr2=arr;// 2 המערכים מצביעים לאותו כתובת, הערך של 2 המערכים הוא אותו ערך
    //System.out.println(arr);//מדפיס את הערך של המערך ז"א את הכתובת של המערך

        arr[0] = 4;
        bubbleSort(arr);
    printArray(arr);
     System.out.println(binarySearch(arr, 0, arr.length-1, 2));
    //כמה מילי שניות חלפו מה1.1.1970 בזמן לונדון
     long now= System.currentTimeMillis();
     //הדפסת ספרים רנדומלים
    // Random random= new Random(System.currentTimeMillis());
     //   for (int i = 0; i <4 ; i++)
     //       System.out.println(random.nextInt()+ ",");
     //
      int [] arr1= new int[20];
        Random random= new Random(System.currentTimeMillis());
        for (int i = 0; i <arr1.length ; i++) {
            arr[i]=random.nextInt(100);
        }


    }
    //o(nlogn)
    // פונקציה שבודקת האם יש שתי איברים במערך שהסכום שלהם שווה ל sum
    static boolean contaisPairWithSumX (int[] arr, int sum){
        quickSort(arr,0, arr.length-1);//קודם כל נמיין את המערך
        int l=0,r=arr.length-1;
        while (l<r){
            int temp= arr[l]+arr[r];
            if(temp==sum)
                return true;
            else if(temp<sum)
                l++;
            else
                r--;
        }
        return false;
    }

    // כאשר ההפרש בין המספר הגדול לקטן הוא נמון יחסית פונקציה שבודקת האם יש שתי איברים במערך שהסכום שלהם שווה ל sum
    static boolean contaisPairWithSumX2 (int[] arr, int sum){
        //אם המערך קטן אז כדאי למיין אותו וללכת לפונקציה הקודמת
        if(arr.length<100)
            return contaisPairWithSumX(arr,sum);
        int min=arr[0];
        int max=arr[0];
        //מציאת המינימום והמקסימום כדי לדעת את גודל המערך וגם כדי להשתמש אח"כ בערכם של המינימלי והמקסימלי
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>max)
                max=arr[i];
            if(arr[i]<min)
                min=arr[i];
        }
        //אם ההפרש בין המינימום למקסימום עצום אז עדיף למיין ולשלוח לפונקציה הקודמת
        if(max-min >100000)
            return contaisPairWithSumX(arr,sum);
        // גודלו כמו ההפרש בין הגדול לקטן
        boolean[] binmap= new boolean[max-min+1];
        for (int i = 0; i <arr.length ; i++) {
            int temp=sum-arr[i];
            if(temp>= min && binmap[temp-min]){
                    return true;
            }
            binmap[arr[i]-min]=true;
        }
        return false;
    }

    static void printArray(int[] arr){
        System.out.print("{");
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]);
            if (i<arr.length-1)
                System.out.print(",");
        }
        System.out.println("}");
    }
    // חיפוש במערך ממוין
    static int binarySearch(int[] arr, int left, int right, int x){
        if(right >= left){
            int middle = left + (right-left)/2;
            if(arr[middle] == x)
                return middle;
            if(arr[middle] < x)
                return binarySearch(arr, middle+1, right, x);
            return binarySearch(arr, left, middle-1, x);
        }
        return -1;
    }


    //מיון בועות- משווה כל נתון עם הנתון שלידו ואם השני קטן יותר אז מחליפים בינהם
    static void bubbleSort(int[] arr){
        int upTo=arr.length-1;
        boolean isSorted=false;
        while(!isSorted){
            isSorted=true;
            for (int i = 0; i <upTo ; i++) {
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    isSorted=false;//אם יש פעם שהוא לא נכנס לעשות שום החלפה אז ז"א שהוא סיים את המיון (ולא סומן הדגל בשקר)
                }
            }
            upTo--;//  פחות האיבר האחרון כיון שבכל איטרציה האיבר האחרון הוא האיבר שנכנס למקום שלו
        }
    }
    //מיון הכנסה- כל מספר שבודקים אותו משובץ במקום הנכון
   // מיון יציב- שומר על הסדר של האיברים, למיון קצר המיון דווקא אידאלי,
    static void insertionSort(int arr[]){
        for (int i = 1; i <arr.length ; i++) {
            int key=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>key){//או שהגעתי לסוף המערך או שמצאתי איבר שיותר גדול מKEY
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
    //פונקצית עזר למיון מיזוג
    //פונקציית עזר יודעת למיין 2 מערכים בהנחה שהם ממוינים
    static void merge(int[] arr, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }
        int i=0, j=0;
        int k = l;
        while (i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

   //מיון מיזוג o(nlogn
    // מיון אידאלי החיסרון שלו שהוא מקצה מערכים שוב שוב ויש פה בזבוז. והוא לא מיון יציב
    static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);// מיין את החצי השמאלי
            mergeSort(arr, m+1, r);// מיין את החצי הימני
            merge(arr, l, m, r);// ממזג את שני החצאים של המערך
        }
    }
    //פונקציית ערבול רנדומלי
    static int randomizedPartition(int[] arr,int low,int high){
        if(high==low)
            return low ;
        Random random= new Random(System.currentTimeMillis());//לא שמים ברנדום מספר כדי שכל פעם הוא יביא לנו סדרת מספרים אחרת, אם שמים אותו מספר הוא חוזר תמיד על אותה רשימה אקראית
        int pos=random.nextInt(high-low)+low;// מקבלים מספר אקראי בין הגבוהה לנמוך
        int temp=arr[high];
        arr[high]=arr[pos];
        arr[pos]=temp;
        return partition(arr,low,high);
    }
    //מיון מהיר
    //נעשה איזה ערבול רנדומלי כדי שתמיד המקרה הממוצע יהיה nlogn נעשה פונקציית ערבול רנדומלי
    static void quickSort (int [] arr, int low, int high){
        if(low<high){//אם כן שולחת לפונקצית פרטישיין ושומרת את התוצאה
          int pi= partition(arr,low,high);
          quickSort(arr,low,pi-1);
          quickSort(arr,pi+1,high);
        }

    }
  //פונקצית עזר למיון מהיר שאומרת לכל מערך אני אקח איבר אחד (לדוג האחרון)
    //ובסוף העבודה האיבר ימוקם במקום הנכון כל האיברים שקטנים ממנו יהיה לשמאלו וכל הגדולים ממנו יהיו לימינו
    //שומרים במשתנה עזר כמה איברים קטנים מאיבר הציר
    static int partition(int[] arr,int low,int high){
       int pivot= arr[high]; //בתחילה האיבר ציר הוא האיבר האחרון
        //לולאה שעוברת על ערכי המערך
        // אם אתה קטן או שווה מהאיבר ציר רוצים להדביק אותו הכי שמאלה
        //נקדם את I הוא גדל שמצאתי איבר קטן יותר מהאיבר ציר
        //מחליף בין האיברים
        //מקדמים את הI שוב ומסדרים את מיקומו הסופי של איבר הציר
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
    //שינינו את הI לK
    //מציאת האיבר הI בגודלו= מציאת I האיברים הקטנים ביותר המערך
    //מחלק את המערך ל2 וכל פעם מחפש את האיבר במקום המתאים
    //אם האינדקס שמצאנו קטן יותר מהI אז מורידים מהI את האינדקס וזה מס האיבר החדש שאנחנו רוצים למצוא
    //או של אן כי כל פעם שקוראים לפרטישיין קוראים על הרבה יותר קטן
    static int quickSelect(int [] arr,int l,int r, int k ){
      if(k>0&& k<=r-l+1){// כל עוד הL קטן מהR
          int pos =randomizedPartition(arr,l,r);
          if(pos-l ==k-1)//הפונקציה פרטישיין חילקה לי בול במקום
             return arr[pos];
          if (pos-l>k-1)//שקיבלנו מיקום גדול מהאיבר במיקום שאנחנו מחפשים
             return quickSelect(arr,l,pos-1,k);
          return quickSelect(arr, pos+1,r,k-pos+l-1);// פוס נותן מספר של מיקום על המערך המקורי-בכל שליחה לפונקציה ולכן צריך להוסיף את הl
      }
      return Integer.MAX_VALUE;//  כל האיברים במערך קטנים מהאיבר שאתה מבקש לכן מחזיר איזה שהוא איבר גדול
    }
}

