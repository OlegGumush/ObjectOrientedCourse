package Lesson06_Collections_Map_List;

import java.util.*;
import java.util.Map.Entry;

public class TreeMapDemo {

    public static void mapExample1() {
        
        String days[] = {"Sunday", "Monday", "Tuesday", "Wednesnday", "Thursday", "Friday", "Saturday"};
        Map<Integer, String> map = new HashMap<Integer, String>();
        try {
            for (int i = 0; i < 7; i++) {
                map.put(i, days[i]);
            }
            System.out.println(map);
            map.put(1, "Tuesday");
            System.out.println(map);


            TreeMap<Integer, String> tMap = new TreeMap<Integer, String>(map);
            //Retrieving all keys
            Set<Integer> kSet = tMap.keySet();
            System.out.println("Keys of tree map: " + kSet.toString());
            //Retrieving all value;
            Collection<String> kVal = tMap.values();
            System.out.println("Values of tree map: " + kVal.toString());
            //Retrieving the First key and its value
            System.out.println("First key: " + tMap.firstKey() + " Value: " + tMap.get(tMap.firstKey()) + "\n");
            //Removing the first key and value
            System.out.println("Removing first data: " + tMap.remove(tMap.firstKey()));
            System.out.println("Now the tree map Keys: " + tMap.keySet());
            System.out.println("Now the tree map contain: " + tMap.values() + "\n");
            //Retrieving the Last key and value
            System.out.println("Last key: " + tMap.lastKey() + " Value: " + tMap.get(tMap.lastKey()) + "\n");
            //Removing the last key and value
            System.out.println("Removing last data: " + tMap.remove(tMap.lastKey()));
            System.out.println("Now the tree map Keys: " + tMap.keySet());
            System.out.println("Now the tree map contain: " + tMap.values());
        } catch (Exception e) {
        }
    }

    public static void mapExample2() {
        Map<Integer, String> mp = new HashMap<Integer, String>();
        // adding or set elements in Map by put method key and value pair
        mp.put(2, "Two");
        mp.put(1, "One");
        mp.put(3, "Three");
        mp.put(4, "Four");
        System.out.println(mp);
        //Get Map in Set interface to get key and value
    
        Set<Entry<Integer, String>> s = mp.entrySet();
        //Move next key and value of Map by iterator
        Iterator<Entry<Integer, String>> it = s.iterator();
        while (it.hasNext()) {
            // key=value separator this by Map.Entry to get key and value
            Map.Entry<Integer, String> m = (Map.Entry<Integer, String>) it.next();
            // getKey is used to get key of Map
            int key = (Integer) m.getKey();
            // getValue is used to get value of key in Map
            String value = (String) m.getValue();
            System.out.println("Key :" + key + "  Value :" + value);
        }
    }

    public static void mapExample3() {
        Map<Integer, String> tmp = new HashMap<Integer, String>();
        tmp.put(2, "Two");
        tmp.put(1, "One");
        tmp.put(5, "Five");
        tmp.put(4, "Four");
        System.out.println(tmp);
    }

    public static void main(String args[]) {
        System.out.println("example 1");
        mapExample1();
        System.out.println("example 1");
        mapExample2();
        System.out.println("example 1");
        mapExample3();
    }
}
