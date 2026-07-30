package io.herald.myspringweb.Test;

import java.util.*;

public class CollectionFramework {
    public static void main(String[] args) {

        //List -> ArrayList, LinkedList, Vector -> all are same, minor performance difference

        List<Integer> intList = new Vector<>();
        intList.add(1);

        //Set -> HashSet, - no duplicate
        Set<Integer> intSet = new TreeSet<>();

        //Map -> HashMap, LinkedHashMap, Tree Map
        Map<Integer, String>map = new HashMap<>();
        map.put(1,"apple");
        map.put(1,"pineapple");

        System.out.println(map);




    }
}

