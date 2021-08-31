package ds;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by home on 5/29/2020.
 */
public class QueueRemoval {

    public static void main(String args[]){

        int[] arr = new int[]{1, 2, 2, 3, 4, 5};
        int x = 5;
        int[] result  = findPositions(arr, x);

        System.out.println("value of the indexes: ");
        for(int i=0; i < result.length; i++){
            System.out.print(" " + result[i]);
        }

    }


    static int[] findPositions(int[] arr, int x) {

        if(x == 0 || arr.length <= 0)
            return arr;

        // Write your code here
        int[] copyArr = Arrays.copyOf(arr,arr.length);
        int[] result = new int[arr.length];
        Map<Integer, Integer> store= new HashMap();
        int[] ele = new int[x];

        Queue<Integer> arrQ = new LinkedList(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        for(int i=0; i < arr.length; i++){
            store.put(i+1, arr[i] );
        }

        for(int i =1; i <= x; i++){

            int count = x;
            int large = 0;
            for(int j = 1; j <= x ; j++) {

              Integer intValue =  ( (Integer) arrQ.poll());
              if(intValue != null)
               ele[j-1] = intValue.intValue() ;

              large  = ele[j-1] > large ? ele[j-1] : large;
            }

            for(int k = 0; k < ele.length; k++){
                if(ele[k] != large)
                    arrQ.offer(ele[k] - 1);
            }

            Iterator<Map.Entry<Integer, Integer>> iter = store.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<Integer, Integer> entry = iter.next();
                if(entry.getValue().equals(large))
                    result[i-1] = entry.getKey().intValue();
            }

        }

        return result;
    }



}
