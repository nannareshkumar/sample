package minmax;

import java.util.Stack;

/**
 * Created by home on 12/24/2020.
 */
public class LongestParenthesis {


    public static void main(String args[]){

        LongestParenthesis lp = new LongestParenthesis();
        String s =  ")()())"; //"()"; //")()())"; //"()(()";
        System.out.println("results : " + findMaxLen(s) );//lp.longestValidParentheses(s));
    }
        // method to get length of the longest valid
        static int findMaxLen(String str)
        {
            int n = str.length();
            Stack<Integer> stk = new Stack<>();
            stk.push(-1);

            // Initialize result
            int result = 0;

            // Traverse all characters of given string
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '(')
                    stk.push(i);
                else {
                    if(!stk.isEmpty()) {
                        stk.pop();
                        result = Math.max(result, i - stk.peek());
                    } else {
                        stk.push(i);
                    }
                }
            }

            return result;
        }


    public int longestValidParentheses(String s) {

        if(s.length() <= 0)
            return 0;

        String result = new String("");

        int max=0, start=0, end=0;
        Stack<String> stack = new Stack();
        for(int i=0; i < s.length(); i++) {
            String ret = s.charAt(i)+"";
            if(stack.isEmpty()){
                stack.push(ret);
                start = i;
            }
            else {
                if(ret.equals(")") && stack.peek().equals("(")) {
                    end =i;
                    max= ((end - start + 1)%2 == 0)? (end - start + 1) : max ;
                    result += ret + stack.pop();
                } else {
                    stack.push(ret);
                }
            }
        }

        return max;
    }


}
