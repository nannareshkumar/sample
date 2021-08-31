package stringman;

import java.util.*;

/**
 * Created by home on 1/5/2021.
 */
public class StringAnagrams {

    public static void main(String args[]){
        String[] s = new String[]{"eat","tea", "tan", "ate", "nat", "bat"};

        Map<String, List<String>> map = anagram(s);

        Iterator<Map.Entry<String, List<String>>> iter = map.entrySet().iterator();
        while(iter.hasNext()){

         System.out.println(" ");
         Map.Entry<String, List<String>> entry =  iter.next();
         System.out.println(" key : " + entry.getKey() + " \n values : ");

         List<String> values = entry.getValue();
         for(int i=0; i < values.size(); i++){
             System.out.print(" " + values.get(i));
         }

        }

    }

    static Map<String, List<String>> anagram(String[] s){

        Map<String, List<String>> map = new HashMap();
        List<String> list = new ArrayList();


        for(int i=0; i< s.length; i++ ){
            char[] c = s[i].toLowerCase().toCharArray();
            Arrays.sort(c);
            String s1 = new String(c);
            List<String> stor = map.get(s1);

            if(stor != null){
                stor.add(s[i]);
            } else {
                List<String> store = new ArrayList();
                store.add(s[i]);
                map.put(s1, store);
            }
        }
        return map;
    }

}
