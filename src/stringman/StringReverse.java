package stringman;

import java.util.*;

/**
 * Created by home on 12/19/2020.
 */
public class StringReverse {

    public static void main(String args[]) {

        //String input="	      fwbpudnbrozzifml   osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq                 ";
        String input="  test test1  test2   test3 testing  "; // "blue is sky the"
        System.out.println("+++++++++" +input + "+++++++++" );
        System.out.println("+++++++++" +test2(input)+"+++++++++");
    }

    public static String test2(String s){

        StringBuffer sb = new StringBuffer();
        String[] res = s.split(" ");
        for(int i=res.length-1; i >=0; i--){
            if(!res[i].equals(""))
             sb.append(res[i]+" ");
        }
        return sb.toString().trim();
    }

    public static void test(){
        int[] A = new int[]{11};
        int[] res = solve(A, 3);

        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+ " ");
        }

    }

    public static int[] solve(int[] A, int B) {

        int[] res = new int[B];
        Arrays.sort(A);

        int len = A.length;
        if (B <= len) {
            for (int i = A.length - 1, j = 0; j < B && i >= 0; i--, j++) {
                res[j] = A[i];
            }
        }
        return res;
    }

}
