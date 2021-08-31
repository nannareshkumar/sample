package minmax;

import java.util.*;

/**
 * Created by home on 12/18/2020.
 */
public class LongestValidParenthesis {

    public static void main(String args[]){

        System.out.println(" Longest valid parenthesis length is :" + longestValidParentheses("(()()"));

    }


    public static int longestValidParentheses(String s) {

        int result =0;
        if(s.length() <= 0)
            return result;

        Stack<Integer> stack = new Stack();
        stack.push(-1);
        for(int i=0; i < s.length(); i++) {

            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if(!stack.empty()) {
                    stack.pop();
                    result = Math.max(result, i - stack.peek());
                }
                else
                    stack.push(i);
            }
        }

        return result;
    }

}
