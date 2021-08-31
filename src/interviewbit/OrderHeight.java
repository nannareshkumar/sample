package interviewbit;

import java.util.*;

public class OrderHeight {
    public static void main(String args[]){
        int[] A = new int[]{ 29, 82, 30, 62, 23, 67, 35};//  {5, 3, 2, 6, 1, 4};  // 29, 82, 30, 62, 23, 67, 35
        int[] B = new int[]{5, 0, 2, 0, 3, 1, 1}; //{0, 1, 2, 0, 3, 2};
        OrderHeight oh = new OrderHeight();
        int[] res = oh.order(A, B);

        System.out.println("result:" + Arrays.toString(res));
    }

    public int[] order(int[] A, int[] B) {
        //Heights: 5 3 2 6 1 4
//      InFronts:  0 1 2 0 3 2
        int[] res = new int[A.length];
        Arrays.fill(res, -1);

        Map<Integer, Integer> m = new TreeMap();
        int minh=Integer.MAX_VALUE;
        for(int i = 0 ; i <A.length; i++){
            m.put(A[i], B[i]);
            if(minh > A[i] )
                minh = A[i];
        }

        Iterator<Map.Entry<Integer, Integer>> iter = m.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, Integer> val = iter.next();
               int count=0;
               for(int i =0; i<res.length; i++){
                   if(res[i] == -1) {
                        if(count == val.getValue())
                            res[i] = val.getKey();
                        count++;
                   }
            }
        }

        return res;
    }

}
