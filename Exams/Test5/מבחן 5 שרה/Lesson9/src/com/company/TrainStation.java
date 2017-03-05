package com.company;

/**
 * Created by hackeru on 2/23/2017.
 */
public class TrainStation {
    static private int idCounter=0;
    int id;
    int charge;
    int distanceToNext;

    public TrainStation(int charge, int distanceToNext) {
        this.charge = charge;
        this.distanceToNext = distanceToNext;
        this.id = idCounter++;
    }
}
