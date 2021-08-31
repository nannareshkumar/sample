package bytebybyte;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by home on 1/1/2021.
 */
public class MergeKArrays {

    public static int[] mergeKSortedArray(int[][] arr) {
        //PriorityQueue is heap in Java
        PriorityQueue<QueueNode> queue = new PriorityQueue<QueueNode>();
        int total=0;

        //add arrays to heap
        for (int i = 0; i < arr.length; i++) {
            queue.add(new QueueNode(i, 0, arr[0][i]));
            total = total + arr[i].length;
        }

        int m=0;
        int result[] = new int[total];

        //while heap is not empty
        while(!queue.isEmpty()){
            QueueNode ac = queue.poll();
            result[m++]= ac.value;

//            if(ac.index < ac.arr.length-1){
//                queue.add(new QueueNode(, ac.arr, ac.index+1, ));
//            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }


    static class QueueNode implements Comparable<QueueNode> {
        int arr;
        int index;
        int value;

        public QueueNode(int arr, int index, int value) {
            this.arr = arr;
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(QueueNode o) {
            int i=0;
            if(this.value > o.value)
                i=1;
            if(this.value < o.value)
                i=-1;
            else
                i=0;
            return i;
        }
    }


}
