package array;

/**
 * Created by home on 11/25/2020.
 */
public class CountingSort2 {

    public static void main(String[] args) {
        int largeValue = 10;
        int[] twentyMillion = new int []{1,4,1,2,7,5,2};
        print(twentyMillion);

        int[] result = sortByAccendPro(twentyMillion , largeValue);
        System.out.println(" ");
        print(result);
    }

    public static void print(int[] twentyMillion){

        System.out.print("Array : ");
        for (int i = 0; i < twentyMillion.length; i++) {
            System.out.print(" " +twentyMillion[i]);
        }
    }

    /**
     * Jasz sort algorithim.
     *
     * @param {int[]} twentyMillion - array of twenty million random ints.
     * @param {int} highestNumber - Highest number to sort to.
     */
    public static int[] sortByAccendPro(int[] twentyMillion, int highestNumber ) {
//        int[] rangePosition = new int[twentyMillion.length];
        int[] newArray = new int[twentyMillion.length];
        int[] range = new int[highestNumber];

        for (int i = 0; i < twentyMillion.length; i++) {
//            rangePosition[i] = twentyMillion[i];
            range[twentyMillion[i]]++;
        }
        for (int i = 0, past = twentyMillion[i]; i < twentyMillion.length; i++) {
            range[i] = past + range[i];
            past = range[i];
        }
        for (int i = 0; i < twentyMillion.length; i++) {
            newArray[range[twentyMillion[i]]] = twentyMillion[i];
            range[twentyMillion[i]]--;
        }

        return newArray;
    }


}
