package array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by home on 9/14/2020.
 */
public class MoveZeroToLeft {

    public static void main(String args[]) {

        int[] input = { 1, 10, 20, 0, 59, 63, 0, 88, 0 };

        try {
             moveZerosToLeft(input);
            System.out.println("Resultant value : " + Arrays.toString(input));

        } catch(Exception e){
            e.printStackTrace();
        }

    }


    public static int[] move(int[] input) throws Exception {

        if(input.length == 0)
            throw new Exception("Empty array exception");

        int[] zeros = new int[input.length];
        int[] nonZeros = new int[input.length];
        int i = 0, j = 0;

        for(int a: input){
           if(a == 0){
               zeros[i++] = a;
           } else
               nonZeros[j++] = a;
        }

        for(int k =0; k < nonZeros.length && i<nonZeros.length; i++, k++)
            zeros[i] = nonZeros[k];

      return zeros;
    }

    static void moveZerosToLeft(int[] A) {
        if (A.length < 1) {
            return;
        }

        int writeIndex = A.length - 1;
        int readIndex = A.length - 1;

        while(readIndex >= 0) {
            if(A[readIndex] != 0) {
                A[writeIndex] = A[readIndex];
                writeIndex--;
            }

            readIndex--;
        }

        while(writeIndex >= 0) {
            A[writeIndex] = 0;
            writeIndex--;
        }
    }

    public static int[] moveSwap(int[] input){

        int reader = 0;
        for(int i = 0 ; i < input.length; i++){
            if(input[i] == 0 && reader < i) {
                swapZero(input, reader, i);
                reader++;
            }

        }

        return input;
    }


    public static void swapZero(int[] input, int reader, int curr){

        int temp = input[reader];
        input[reader] = input[curr];
        input[curr] = temp;
    }

}
