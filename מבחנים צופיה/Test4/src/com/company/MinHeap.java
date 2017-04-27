package com.company;

/**
 * Created by hackeru on 2/21/2017.
 */
public class MinHeap {

    Comparable[] arr;
    int size;

    public MinHeap(){
        arr = new Comparable[10];
        size = 0;
    }

    public MinHeap(Comparable[] arr){
        this.arr = arr;
        size = arr.length;
        for (int i = size/2; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i){
        int smallest = i;
        int l = leftChild(i);
        int r = rightChild(i);
        if(l<size && arr[l].compareTo(arr[smallest]) < 0)
            smallest = l;
        if(r<size && arr[r].compareTo(arr[smallest]) < 0)
            smallest = r;
        if(smallest != i){
            Comparable temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapify(smallest);
        }
    }

    private void bubbleUp(int i){
        int p;
        while(i != 0 && arr[(p=parent(i))].compareTo(arr[i]) > 0){
            Comparable temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
            i = p;
        }
    }


    private int leftChild(int i){
        return 2*i + 1;
    }

    private int rightChild(int i){
        return 2*i + 2;
    }

    private int parent(int i){
        return (i-1)/2;
    }


    public void insert(Comparable x){
        if(size == arr.length){
            Comparable[] temp = new Comparable[size * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        //arr[size++] = x;
        int i = size;
        size++;
        arr[i] = x;
        bubbleUp(i);
    }

    public Comparable getMin(){
        if(size == 0)
            throw new IndexOutOfBoundsException();

        Comparable result = arr[0];//ארר במקום ה0 הוא האיבר המינימלי כי זה ערימת מינימום
        return result;
    }

    public Comparable extractMin(){
        if(size == 0)
            throw new IndexOutOfBoundsException();
        if(size == 1){
            size--;
            return arr[0];
        }
        Comparable min = arr[0];
        arr[0] = arr[size-1];
        size--;
        heapify(0);
        return min;
    }

    public int getSize(){
        return size;
    }
    //האם הפונקציה יכולה לקבל פרמטרים, הפונקציה דיפולט
    //צריכה לבדוק את המערך אם הוא ערימת מינימום או לא
    //עובדת על מין היפ ספציפי של המחלקה... שעליו שלחו את הפונקציה, והפונציה לא הייתה מקבלת משתנים אם זה לא היה סטטי
    //מכיון שזה פונקציה סטטית אז זה שירות חיצוני שאומר על כל מערך אם זה ערימת מינימום או לא
    public static boolean isValidMinHeap(Comparable[] arr, int i, int size ){
        //הסייז זה הגודל של המערך במפועל ולכן אם רוצים לדעת אם אין בן ימני שואלים אם הרייט גדול מהסייז ז"א שהוא לא קיים
        int left=2*i+1; //הבן השמאלי של אי
        int right=2*i+2;
        if (left>size)
            return true;
       else {
            if(arr[i].compareTo(arr[left])>0)//אם האבא יותר גדול ממהבן שלו אז זה לא טוב
                return false;
        }
        if(right<=size) {//אם יש בן ימני
            if (arr[i].compareTo(arr[right]) > 0)//אם האבא גדול מהבן הימני
                return false;

        }
       return isValidMinHeap(arr,left,size)&&isValidMinHeap(arr,right,size);
    }
}
