package main.java.task1;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @version 1.0
 * @autor Naragas
 * @created 7/19/2025
 */

public class main {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        var customMap = new CustomHashMap<Integer,String>();

        customMap.put(1765, "one");
        customMap.put(0, "Zero");
        customMap.put(2, "two");
        customMap.put(8763, "three");
        customMap.put(4, "four");
        customMap.put(5, "five");
        customMap.put(645, "six");
        customMap.put(754, "seven");
        customMap.put(8, "eight");
        customMap.put(9, "nine");
        customMap.put(10, "ten");
        customMap.put(null, "NULL");
        customMap.put(11, "eleven");
        customMap.put(12, "twelve");
        customMap.put(143, "thirteen");
        System.out.println(customMap);
        customMap.remove(645);
        System.out.println(customMap);
        System.out.println(customMap.get(4));
        System.out.println(customMap.get(null));
        System.out.println(customMap.get(2));
        System.out.println(customMap.get(754));
        customMap.put(5,"PIAT");
        System.out.println(customMap.get(4));
        System.out.println(customMap.get(2));
        System.out.println(customMap.get(754));
        System.out.println(customMap);


    }

}
