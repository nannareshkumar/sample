package test;

import java.util.*;
import java.io.*;

public class StringRotation {

    // function that rotates s towards left by d
    public static String leftrotate(String str, int d) {
//        String ans = str.substring(d) + str.substring(0, d);
//        return ans;

        String result = "";
        char[] arr  = str.toCharArray();
        for (int i = 0; i <= d; i++) {
           result = result + arr[i];
        }
        return str.substring(d, str.length()) +  result;

    }

    // function that rotates s towards right by d
    public static String rightrotate(String str, int d) {
        // return leftrotate(str, str.length() - d);
        String result = "";
        char[] arr  = str.toCharArray();
        for (int i = str.length() - d; i < str.length(); i++) {
            result = result + arr[i];
        }
        return result + str.substring(0, str.length()-d);

    }

    // Driver code
        public static void main(String args[]) {
            String str1 = "GeeksforGeeks";
            System.out.println(leftrotate(str1, 2));

            String str2 = "GeeksforGeeks";
            System.out.println(rightrotate(str2, 2));
        }
    }

