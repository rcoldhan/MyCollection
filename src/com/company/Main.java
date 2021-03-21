package com.company;

import java.util.Arrays;
import java.util.Collection;
//import java.util.Iterator;

public class Main {

    public static void main(final String[] args) {
        Collection<Integer> coll2 = new MyCollection<>();
        coll2.add(4);
        coll2.add(1);
        coll2.add(2);
        coll2.add(3);

        //Iterator<?> it = coll2.iterator();
        //it.next();
        //coll2.add(5);
        Collection<Integer> coll = new MyCollection<>();
        coll.add(1);
        coll.add(3);
        boolean result = coll2.retainAll(coll);
//        coll.add(1);
//        coll.add(8);
        //System.out.println("coll: " + Arrays.toString(coll.toArray()));
        System.out.println("coll2: " + Arrays.toString(coll2.toArray()) + " Размер: " + coll2.size());
        //boolean result = coll2.containsAll(coll);
        //coll2.clear();
        //boolean result = coll2.removeAll(coll);
        System.out.println(result);
        //System.out.println("1 после: " + Arrays.toString(coll.toArray()));
        //System.out.println("2 после: " + Arrays.toString(coll2.toArray()) + " Размер: " + coll2.size());
    }
}