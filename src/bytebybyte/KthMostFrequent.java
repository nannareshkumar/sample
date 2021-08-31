package bytebybyte;

import java.util.*;

/**
 * Created by home on 1/21/2021.
 */
public class KthMostFrequent {

    public static void main(String args[]){


        String[] s = new String[]{"aabb", "aab","aab", "aabb", "aabb", "aaba", "aaba", "aaba", "aaba"};
        KthMostFrequent k = new KthMostFrequent();
        String[] res = k.kthMostFrequent(s, 1);

        System.out.println("Lexographical result:");
        for(String item : res){
            System.out.print(" " + item);
        }
    }


    public String[] kthMostFrequent(String[] strings, int k) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String s : strings) {
            Integer x = map.get(s);
            if (x == null) x = 0;
            map.put(s, ++x);
        }

        List list = new ArrayList(map.entrySet());
 
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                Integer v1 = (Integer) ((Map.Entry) o1).getValue();
                Integer v2 = (Integer) ((Map.Entry) o2).getValue();
                return v2 - v1;
            }
        });

        Iterator iter = list.iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)   iter.next();
            System.out.println(entry.getKey()+ "  : " + entry.getValue());
        }

        int count=0;
        String[] res = new String[k];
        if (list.size() >= k && count<=k){
            res[count] = (String) ( (Map.Entry) list.get(count)).getKey();
            count++;
        }


        return res;
    }
}