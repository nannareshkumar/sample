package array;

/**
 * Created by home on 10/28/2020.
 */
public class LargestNum {

    public static void main(String arg[]) throws Exception {

        int input = 56894215;
        int largest = getLargest(input);
        System.out.println(largest);

    }

    private static int getLargest(int num) throws Exception{

        int[] freq = new int[10];
        int digits = 0;
        while(num > 0){
            int rem = num%10;
            freq[rem]++;
            num/=10;
            digits++;
        }

      int result =0;
        for(int index = 9 ; index >= 0; index--){
            if(freq[index] > 0){
                result = (result*10) + index;
            }
        }
        return result;

    }



//    private static int getLargest(int number) throws Exception{
//
//        boolean isNegative = number < 0;
//        int num = isNegative ? -1 * number : number;
//        int[] freq = new int[10];
//        int digits = 0;
//        while(num > 0){
//            int rem = num%10;
//            freq[rem]++;
//            num/=10;
//            digits++;
//        }
//
//        return isNegative ? -1 * getSmallestNumber(freq): getLargestNumber(freq, digits);
//
//    }
//
//    private static int getLargestNumber(int[] freq, int digits){
//        int digitCount = 0;
//        int freqIndex = 9;
//        int result = 0;
//
//        while(freqIndex >=0 && digitCount < digits){
//            if(freq[freqIndex] > 0) {
//                result = (result *10) + freqIndex;
//                freq[freqIndex]--;
//                digitCount++;
//            }
//            if(freq[freqIndex] == 0){
//                freqIndex++;
//            }
//        }
//
//        for(int index = freqIndex; index >=0; index++ ) {
//            if(freq[index] > 0){
//                throw new IllegalArgumentException("Could not converrt the largest number");
//            }
//            return result;
//        }
//        return result;
//    }
//
//    private static int getSmallestNumber(int[] freq ){
//        int result = 0;
//        for(int index=1; index < 9; index++){
//            if(freq[index] != 0) {
//                result = index;
//                freq[index]--;
//                break;
//            }
//        }
//
//        for(int index=0; index <=9; index++){
//            while(freq[index]--  != 0){
//                result = result *10 + index;
//            }
//        }
//        return result;
//
//    }

}
