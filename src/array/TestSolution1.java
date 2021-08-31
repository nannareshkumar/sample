package array;

import java.util.*;

/**
 * Created by home on 10/28/2020.
 */
public class TestSolution1 {

    public static void main(String args[]){

        String input = "abcdzedcba"; //-> abcdzdcba      aabbccdd       "abbacacdaad"
        String result = amethod(input);
        System.out.println("TestSolution 1 " + result);
    }

    public static String amethod(String input) {

        Map<String, Integer> map = new HashMap();
        char[] chars = input.toCharArray();

        //check each alphabet getting count
        for (int i = 0; i < chars.length; i++) {
            Integer count = map.get(chars[i] + "");
            if (count == null)
                map.put(chars[i] + "", 1);
            else
                map.put(chars[i] + "", ++count);

        }

        int k = 0;
        String result = "";
        String left = "", right = "", mid = "";
        String inValid ="Not a palindrom";

        Set<String> keys = map.keySet();
        Iterator iter = keys.iterator();
        while (iter.hasNext()) {
            String st = (String) iter.next();
            Integer count = map.get(st);
            if (count % 2 != 0)
                k++;

            if (k == 0 || k == 1) {
                if (count % 2 == 0) {
                    for (int j = 1; j <= count / 2; j++) {
                        left = left + st;
                        right = st + right;
                    }
                } else {
                    for (int j = 1; j <= count; j++) {
                        mid = mid + st;
                    }
                }

            } else {
                result = inValid;
            }
        }
        //right = right + left;

        if(!result.equals(inValid))
            result = left + mid + right;

        return result;
    }


}
