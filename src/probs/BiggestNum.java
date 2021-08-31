package probs;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by home on 10/27/2020.
 *
 * Find the largest number from the given int value. If given value is 561489 then method must return 986541
 *
 *
 */
public class BiggestNum {

    public static void main(String args[]) {

        int input = 561489032;
        System.out.println("largest value is:" + biggest(input));

    }

    public static int biggest(int n){

        String str = n+"";
        TreeSet<Integer> set = new TreeSet(new The_Comparator());

        char[] ins = str.toCharArray();
        for(int i =0; i<ins.length; i++) {
            set.add(Integer.parseInt(ins[i]+""));
        }

        String result ="";
        Iterator iter = set.iterator();
        while(iter.hasNext()){
             Integer int1 =  (Integer) iter.next();
             result  = result + int1;
        }

        return Integer.parseInt(result);
    }

}

class The_Comparator implements Comparator<Integer> {
    public int compare(Integer str1, Integer str2)
    {
        return str2- str1;

//        if(str1 != null && str2 !=  null)
//            return str1.compareTo(str2) > 0 ? -1 : 1;
//        else
//            return 0;

    }
}