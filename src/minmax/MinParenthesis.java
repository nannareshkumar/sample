package minmax;

import java.util.*;
/**
 * Created by home on 12/15/2020.
 */
public class MinParenthesis {


    public static void main(String args[]) {

        System.out.println("result : " + solve( "((()(())))"));

    }


    public static int solve(String A) {

        if (A.length() == 0)
            return 0;
        else {
            Map<String, String> sym = new HashMap();
            sym.put("(", ")");
            sym.put("{", "}");
            sym.put("[","]");

            Stack<String> stack = new Stack();
            for (int i = 0; i < A.length(); i++) {
                String ch = A.charAt(i)+ "";
                if(stack.isEmpty())
                    stack.push(ch);
                else {
                    String top = stack.peek();
                    String topc = sym.get(top);
                    if (topc != null && topc.equals(ch)) {
                        stack.pop();
                    } else {
                        stack.push(ch + "");
                    }
                }
            }

            return stack.size();

        }
    }
}