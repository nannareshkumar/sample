package stringman;

/**
 * Created by home on 1/9/2021.
 */
public class StringCompress {

    public static void main(String ags[]){
        String s ="aaabccc";
        System.out.println("compressed string:" + compressed(s) );
    }

    public static String compressed(String s){
        String res = "";
        int sum=0;
        char[] arr = s.toCharArray();
        char prev= arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] == prev)
                sum += 1;
            else{
                res = res+ prev+ ""+sum;
                sum=1;
            }
            prev= arr[i];
        }
        res = res+ prev+ ""+sum;

      return res;
    }
}
