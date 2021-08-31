package probs;

/**
 * Created by home on 1/11/2021.
 */
public class ConsecutiveColor {

    public static void main(String args[]) {
        char[]  arr = new char[]{'G', 'G', 'G', 'G', 'R', 'R', 'R', 'B', 'R'};
        int res = findConseColr(arr, 'R');
        System.out.println("Given max R consecutive:" + res);
    }

    public static int findConseColr(char[] arr, char c){

        if(arr.length ==0 )
            return 0;

        int res = -1, max=0, currmax=0 ;
        char prev = arr[0], curr;
        for(int i =0; i < arr.length; i++){
            curr = arr[i];
            if( curr == c && prev == curr) {
                currmax += 1;
            } else {
                currmax =1;
            }

            prev = curr;
            if(currmax > max)
                max = currmax;
        }
        return max;

    }


}
