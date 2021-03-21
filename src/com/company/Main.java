package com.company;

import java.util.Arrays;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        Collection<Integer> coll2 = new MyCollection<>();
        //coll2.add(3);
        coll2.add(4);
        coll2.add(1);
        coll2.add(2);
        coll2.add(3);
        coll2.add(5);
	    Collection<Integer> coll = new MyCollection<>();
	    coll.add(1);
	    coll.add(2);
        coll.add(3);
        System.out.println("coll: " + Arrays.toString(coll.toArray()));
        System.out.println("coll2: " + Arrays.toString(coll2.toArray()) + " Размер: " + coll2.size());
        boolean result = coll2.containsAll(coll);
        //coll2.clear();
        //boolean result = coll2.removeAll(coll);
        System.out.println(result);
        //System.out.println("1 после: " + Arrays.toString(coll.toArray()));
        //System.out.println("2 после: " + Arrays.toString(coll2.toArray()) + " Размер: " + coll2.size());
    }
}