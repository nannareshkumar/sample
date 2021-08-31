package array;

import java.util.*;
/**
 * Created by home on 1/8/2021.
 */
public class MissingNumbers {

    public static void main(String args[]){

        int[] A = new int[]{0, 1, 2, 50, 52, 75};
        List<RangeNum> list = missing(A);

        Iterator iter = list.iterator();
        while(iter.hasNext()){
            RangeNum rn = (RangeNum) iter.next();
            System.out.println( rn.start + " " + rn.end);
        }
    }

    public static List<RangeNum> missing(int[] A){
        List<RangeNum> res = new ArrayList();
        int n = 100;
        boolean[] b = new boolean[n];

        for(int i =0; i < A.length; i++){
            b[A[i]] = true;
        }

        Stack<Integer> s = new Stack();
        for(int i=0; i < n; i++){
            if(b[i] == false) {
                if(s.isEmpty())
                    s.push(i);
            } else {
                if(!s.isEmpty()) {
                    int j = (Integer) s.pop();
                    res.add(new RangeNum(j, i - 1));
                }
            }
        }
        if(!s.isEmpty()) {
            int j = (Integer) s.pop();
            res.add(new RangeNum(j, n - 1));
        }

        return res;
    }

    static class RangeNum {
        int start;
        int end;

        RangeNum(int start, int end ){
            this.start = start;
            this.end = end;
        }
    }


}
