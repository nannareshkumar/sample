package threads;

import java.util.*;

/**
 * Created by home on 11/26/2016.
 */
public class LengthLinkedList {

    public static void main(String arg[]) {

        String s = "00-44  48 5555 8361";
        String result = "";

        for(int i =0, j=1; i < s.length(); i++) {
           char c = s.charAt(i);
            if(c != ' ' && c != '-') {
                result += (j>0 && j%3 == 0) ? c+"-" : c;
                j++;
                }
            }
        System.out.println("result : " + result);
        }


    }



