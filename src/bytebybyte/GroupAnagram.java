package bytebybyte;

import java.util.*;

/**
 * Created by home on 3/6/2021.
 */
public class GroupAnagram {

    public static void main(String args[]){
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagram ga = new GroupAnagram();
        ga.groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result  = new ArrayList();
        Map<String, List<String>> map = new HashMap();

        for(int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toLowerCase().toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

            List<String> list = map.get(sorted);
            if(list != null) {
                list.add(strs[i]);
            } else{
                List<String> newList = new ArrayList();
                newList.add(strs[i]);
                map.put(sorted, newList);
            }
        }

        Iterator<Map.Entry<String, List<String>>>  iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, List<String>> entry= iter.next();
            result.add(entry.getValue());
        }

        return result;
    }
}
