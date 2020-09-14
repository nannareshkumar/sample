package test;

import java.util.*;

/**
 * Created by home on 11/9/2017.
 */
public class LRUCache2 {

    private static final int MAX_ENTRIES = 3;
    Map<Integer,Integer> m = new LinkedHashMap<Integer, Integer>(MAX_ENTRIES){

        //Override this , if it returns true the eldest entry in the map is removed
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return m.size() > MAX_ENTRIES;
        }
    };



    // model function
    int getValue(int x){
        //some complex calculations
        return x;
    }
    //to get value from cache
    int getCacheValue(int x){
        return m.get(x);
    }

    int get(int x){
        int result=0;
        if(m.containsKey(x)){
            result=getCacheValue(x);

        }else{
            result=getValue(x);
        }
        m.remove(x);
        m.put(x, result);
        return result;
    }


    public static void main(String[] args) {
        LRUCache2 obj = new LRUCache2();
        for (int i = 1; i <= 3; i++) {
            obj.get(i);
            System.out.println(obj.m);
        }

        for(int i = 1; i<10; i++) {
            obj.get(2);
            obj.get(i);
            System.out.println(obj.m);
        }

    }
    
}
