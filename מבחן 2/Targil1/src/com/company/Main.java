package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr={33,20,32,14,31};
        insertionSort(arr);
        System.out.println(choclate(3,arr));

	// write your code here
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

//יש לי בעיה עם האינדקסים פה אני מודעת לזה
//רצתי על המערך ועשיתי עוד מערך בגודל של ה M והכנסתי אליו כל פעם את המספרים שיש להם את ההפרש הכי קטן
// לבסוף מיינתי אותו והחזרתי את ההפרש בין האיבר הראשון למערך לאחרון במערך
static  int choclate (int m, int arr[]) {
    int[] smallHefresh = new int[m];
    for (int i = 0; i < smallHefresh.length; i++) {
        smallHefresh[i] = arr[i];
    }
    for (int i = 0; i < arr.length; i++) {
        int k = 0;
        if (k < m-1) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] < smallHefresh[k] - smallHefresh[k + 1]) {
                    smallHefresh[k] = arr[i];
                    smallHefresh[k + 1] = arr[j];
                }
                k++;
            }
        }
        break;
    }
    insertionSort(smallHefresh);
    return smallHefresh[0] - smallHefresh[m - 1];

}


//אני רצה על האלכסון בגלל שהמטריצה ממוינת, עד שאני מגיעה באלכסון למספר שגדול לי מה X שאני רוצה,
// אז אני עומדת באלכסון על המיקום של המספר האחרון שיותר קטן מ
// X ואז אם המספר הזה באלכסון יותר גדול מ X אני זזה שמאלה בעמודות ואם הוא יותר קטן אני זזה ימינה בעמודות
static boolean exsistInTheArray (int arr[][],int x) {
    int i = 0, j = 0;
    while (arr[i][j] < x) {
        i++;
        j++;
    }
    while(arr[i][j]< x)
    {
        j++;
    }
    while(arr[i][j]> x){
        j--;
    }
    if (arr[i][j]==x)
        return true;
    return false;
}

}
