package array;

import java.util.Random;

/**
 * Created by home on 11/24/2020.
 */
public class CountingSort {

        public static void main(String[] args) {
            int largeValue = 10;
            int[] twentyMillion = new int []{1,4,1,2,7,5,2};
//            for (int i = 0; i < twentyMillion.length; i++) {
//                twentyMillion [i] = new Random().nextInt(largeValue);
//            }
            sortByAccendPro(twentyMillion , largeValue);
        }

        /**
         * Jasz sort algorithim.
         *
         * @param {int[]} twentyMillion - array of twenty million random ints.
         * @param {int} highestNumber - Highest number to sort to.
         */
        public static void sortByAccendPro(int[] twentyMillion, int highestNumber ) {
            int[] rangePosition = new int[twentyMillion.length];
            int[] newArray = new int[twentyMillion.length];
            int[] range = new int[highestNumber];
            long time = System.nanoTime();
            for (int i = 0; i < twentyMillion.length; i++) {
                rangePosition[i] = twentyMillion[i];
                range[twentyMillion[i]]++;
            }
            for (int i = range.length - 1, past = twentyMillion.length; i >= 0; i--) {
                range[i] = past - range[i];
                past = range[i];
            }
            for (int i = 0; i < twentyMillion.length; i++) {
                newArray[range[rangePosition[i]]] = twentyMillion[i];
                range[rangePosition[i]]++;
            }
            System.out.println("time = " + (System.nanoTime() - time));
        }
    }