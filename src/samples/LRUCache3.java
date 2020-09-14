package test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by home on 11/25/2017.
 */
public class LRUCache3 {

    int MAX_SIZE = 3;
    Map<Integer, String> test = new LinkedHashMap<Integer, String>(MAX_SIZE) {

        protected boolean removeEldestEntry(Map.Entry obj) {
            return test.size() > MAX_SIZE;
        }

    };

 String getValue(int x) {
    return "Object" + x;
 }

 String getCacheValue(int x) {
   return  test.get(x);
 }


 String get( int x) {

     String result= "Object" + x;
     if(test.containsKey(x)){
         result = getCacheValue(x);
     } else {
         result = getValue(x);
     }

     test.remove(x);
     test.put(x, result);
     return result;
 }

 public static void main(String arg[]) {

     LRUCache3 obj = new LRUCache3();
     for(int i =1; i <= 5; i++) {
         obj.get(i-2);
         System.out.println(obj.test);
     }

     
 }


}
