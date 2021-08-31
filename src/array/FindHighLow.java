package array;

import java.util.*;

/**
 * Created by home on 11/17/2020.
 */
class FindLowHigh{
    static int findLowIndex(List<Integer> arr, int key) {
        //TODO: Write - Your - Code
        int low = binary(arr, key);

        return low;
    }

    static int findHighIndex(List<Integer> arr, int key) {
        //TODO: Write - Your - Code
        int high = binary(arr, key);
        if(high > 0){
            while(high<=arr.size()){
                if(key == arr.get(high))
                    high++;
            }
        }

        return high;
    }

    static int binary(List<Integer> list, int key){

        int i = list.size()-1, j=0, result=-1;
        for(; i>=0 && j>=0;) {
            if(key > list.get(j) && key < list.get(i)){
                i=i/2;
            } else if( j<i && key > list.get(i)) {
                j=i;i=i*2;
            } else if (key == list.get(j)) {
                result = j;
            }else{
                result=-1;
            }

        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4,4, 5, 5, 5, 6, 6, 6, 6, 6, 6);
        int key = 5;
        int low = findLowIndex(array, key);
        int high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);

        key = -2;
        low = findLowIndex(array, key);
        high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);
    }
}