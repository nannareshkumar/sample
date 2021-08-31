package ds;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by home on 5/29/2020.
 */
public class QueueSample {

    public static void main(String args[]) {

        int[] arr = new int[]{1, 2, 2, 3, 4, 5};
        List<Integer> ele = new ArrayList();

        Queue<Integer> arrQ = new LinkedList(Arrays.stream(arr).boxed().collect(Collectors.toList()));

        for (int k = 0; k < arr.length; k++) {
            ele.add(arrQ.poll());
           System.out.print(" " + ele.get(k));
        }
    }
}
