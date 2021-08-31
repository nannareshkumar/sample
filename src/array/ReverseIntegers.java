package array;

import java.util.Arrays;


/**
 * Created by home on 5/4/2020.
 */
public class ReverseIntegers {

    public static void main(String args[]) {
       System.out.println("Value of reverse int : " + reverse(-320));

    }

    public static int reverse(int x){

        String s = String.valueOf(x);
        char[] charArr = s.toCharArray();

        String sign="";
        if(charArr[0] == '-'){
            sign = String.valueOf(charArr[0]);
           charArr = Arrays.copyOfRange(charArr, 1, charArr.length);
        }
        String result = "";
        for(int i = charArr.length-1; i >=0 ; i--) {
            result= result + charArr[i];
        }
        return Integer.valueOf(  sign + result);
    }



    public static int reverse1(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }

    public static int reverseStr(int x ) {

        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }

    }

}
