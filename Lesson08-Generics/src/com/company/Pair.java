package com.company;

/**
 * Created by hackeru on 2/19/2017.
 */

//מחלקה- צמד, זוג
    //זה אומר שקובעים אובייקט מסור פייר וקובעים את הטיפוסים אי אפשר לשנות את זה אחכ
public class Pair<T, S> {
    private T object1;
    private S Object2;

    public Pair(T object1, S object2) {
        this.object1 = object1;
        Object2 = object2;
    }

    public T getObject1() {
        return object1;
    }

    public void setObject1(T object1) {
        this.object1 = object1;
    }

    public S getObject2() {
        return Object2;
    }

    public void setObject2(S object2) {
        Object2 = object2;
    }
}
