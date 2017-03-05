package com.company;

public class Main {

    public static void main(String[] args) {
        //region Lambda
        Writable writable1 = new Writable() {
            @Override
            public void write(String s) {
                System.out.println(s);
            }
        };
        writable1.write("I am an anonymous class");
        Writable writable2 = s -> System.out.println(s);
        writable2.write("heyy");
        BinaryOperator multiplication = (int x, int y) -> x*y;
        BinaryOperator addition = (x, y) -> x+y;
        //TODO: lambda operators can be written with or without parameter types
        Point[] points={new Point(3,4),new Point(7,3),new Point(98,1)};
        Point p=new Point(7,3);
        System.out.println(contains(points,p,(a,b) -> a.x == b.x && a.y == b.y));
        //endregion
        //region Stack
        ArrStacky<Comparable> stacky = new ArrStacky<>();
        stacky.push(2);
        stacky.push(6);
        stacky.push(3);
        stacky.push(5);
        stacky.push(1);
        stacky.push(4);
        stacky=sortStack(stacky);
        while (!stacky.isEmpty())
            System.out.print(stacky.pop()+ " ");
        //endregion
        //region Queue
        System.out.println();
        System.out.println("QQQQ QQQQ QQQQ");
        Queue<Integer> q= new ArrQueue<>();
        for (int i = 0; i < 9; i++) {
            q.push(i+2);
        }
        q.pop();
        q.push(69);
        printQ(q);
        //endregion;
        TrainStation stop0=new TrainStation(70,20);
        TrainStation stop1=new TrainStation(100,300);
        TrainStation stop2=new TrainStation(140,100);
        TrainStation stop3=new TrainStation(100,10);
        TrainStation stop4=new TrainStation(100,70);
        TrainStation stop5=new TrainStation(70,80);
        Queue<TrainStation> trainStationQueue = new ArrQueue<>();
        trainStationQueue.push(stop0);
        trainStationQueue.push(stop1);
        trainStationQueue.push(stop2);
        trainStationQueue.push(stop3);
        trainStationQueue.push(stop4);
        trainStationQueue.push(stop5);
        System.out.println("Start from "+ trainStation(trainStationQueue));
    }
    //region Interfaces_For_Lambda
    interface Writable {
        void write(String s);
    }
    interface BinaryOperator {
        int operate(int x, int y);
    }
    interface Equal{
        boolean areEqual(Point x, Point y);
    }
    static class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x,y;
    }
    public static boolean contains (Point[] arr, Point z, Equal equal){
        for (int i = 0; i < arr.length; i++) {
            if(equal.areEqual(arr[i],z))
                return true;
        }
        return false;
    }
    //endregion
    //region StackFunctions
    //Class exercise: sort the stack
    public static void printQ(Queue t){
        while(!t.isEmpty()) {
            System.out.println(t.pop());;
        }
    }
    static ArrStacky <Comparable>  sortStack (Stacky<Comparable> stack){
        ArrStacky <Comparable> sorted=new ArrStacky<Comparable>();
        ArrStacky <Comparable> smaller=new ArrStacky<Comparable>();
        sorted.push(stack.pop()); // first element
        while(!stack.isEmpty()){
            Comparable curr = stack.pop();
            if(curr.compareTo(sorted.peek())<0) {// curr < sorted.peek()
                while (!smaller.isEmpty() && smaller.peek().compareTo(curr) > 0) // while elements in sorted array are larger than curr
                    sorted.push(smaller.pop());
                smaller.push(curr);
            }
            else{ //curr >= sorted.peek()
                while(!sorted.isEmpty() && sorted.peek().compareTo(curr)<0) // while elements in smaller array are smaller than curr
                    smaller.push(sorted.pop());
                sorted.push(curr);
            }
        }
        while(!smaller.isEmpty())
            sorted.push(smaller.pop());
        return sorted;
    }
    //endregion
    //naive algorithm
    public static int findStartingStation (TrainStation[] stations) {
        for (int i = 0; i < stations.length; i++) {
            int sum = 0;
            int j = i;
            do {
                sum += stations[j].charge;
                sum -= stations[j].distanceToNext;
                if(sum < 0){
                    break; //breaks while
                }
                j++;
                if(j == stations.length)
                    j = 0;
            }
            while(j != i);
            return i;
        }
        return -1; // never happens
    }

    public static int trainStation (Queue<TrainStation> stops){ // 0 (n)
        int totalCharge = 0, stationNum = 0;
        int i = 0;
        int size = stops.size();
        while (i % size != size - (stationNum - 1))
        {
            TrainStation curr = stops.pop();
            totalCharge += curr.charge;
            stops.push(curr);
            if(totalCharge < curr.distanceToNext) {
                totalCharge = 0;
                stationNum = curr.id + 1;
            }
            else {
                totalCharge -= curr.distanceToNext;
            }
            i++;
        }
        return stationNum;
    }
}