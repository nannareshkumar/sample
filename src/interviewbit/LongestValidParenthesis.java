package interviewbit;

import java.util.*;

public class LongestValidParenthesis {

    public static void main(String args[]){
       String s =  ")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))(((";
        //"((((())))";
        LongestValidParenthesis l = new LongestValidParenthesis();
       System.out.println(" length: " + l.longestValidParentheses(s));
    }

    public int longestValidParentheses(String A) {

        String res = "", check= "()", val="";
        Stack<Character>  stack = new Stack();
        char open = '(', close = ')', curr;

        char[] c = A.toCharArray();
        for(int i =0; i<c.length; i++) {

            if(c[i] == open || stack.isEmpty()){
                stack.push(c[i]);
            } else if (!stack.isEmpty() && c[i] == close) {
                val = stack.pop()+""+ c[i];
                if(val.equals(check))
                    res += val;
            }
        }
        System.out.println(res);
        return res.length();
    }

}
