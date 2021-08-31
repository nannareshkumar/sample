package sorting;

import java.io.*;
import java.util.*;


/**
 * Created by home on 2/2/2021.
 */
public class KthElements {

        public static void KthElements(int arr[], int size, int k) {

            PriorityQueue<Integer> minHeap = new PriorityQueue(new Comparator(){
                public int compare(Object o1, Object o2){
                    return  (Integer) o2 - (Integer) o1;
                }
            });
            for(int i = 0; i < k; i++) {
                minHeap.add(arr[i]);
            }

            for(int i = k; i < size; i++) {
                if (minHeap.peek() < arr[i])
                    continue;
                else {
                    minHeap.poll();
                    minHeap.add(arr[i]);
                }
            }

            Iterator iterator = minHeap.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next() + " ");
            }
        }

        // Driver code
        public static void main (String[] args)
        {
            int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
            int size = arr.length;
            int k = 3;
            KthElements(arr, size, k);
        }
    }

// This code is contributed by Vansh Sethi
