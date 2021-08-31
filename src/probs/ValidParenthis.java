package probs;

import java.util.*;

/**
 * Created by home on 5/4/2020.
 */
public class ValidParenthis {


    public static void main(String args[]) {


        String input = "(){}}{"; //"(){}}{"
        boolean result = isValid(input);
        System.out.println("IsValid string : " + result);

    }

    public static boolean isValid(String s) {

        boolean isValid = false;
        if(s == null || s.isEmpty() || (s.length()%2 != 0))
            return isValid;

        Map<String, String> pairs = new HashMap();
        pairs.put("{", "}");
        pairs.put("[", "]");
        pairs.put("(", ")");

        Stack<String> stack = new Stack();

        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            stack.push(String.valueOf(chars[i])) ;
        }
        int k =0;

        Object[] result = stack.toArray();
        for(int i=0, j=result.length-1 ; i < (result.length)/2 && j >=0 ; i++, j--){
            String pair = pairs.get(String.valueOf(result[i]));
            isValid = ((pair != null) && (pair.equals(result[j]) || pair.equals(result[i+1]))) ? true : false;

            if( i%2==0 && isValid == false)
                break;
        }

        return isValid;
    }
}


