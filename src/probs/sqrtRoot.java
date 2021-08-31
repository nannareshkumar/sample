package probs;

/**
 * Created by home on 12/11/2020.
 */
public class sqrtRoot {

    public static void main(String args[]){


        System.out.println(sqrt(81));;
    }


    public static int sqrt(int n){

        if(n < 2)
            return n;

        int result = 1;
        int start=1, end=n, ans=0, mid= (int) Math.floor(start+end)/2;

        while(start <= end ){
            mid = (int) Math.floor(start+end)/2;
           if(mid*mid == n){
              result = mid;
              break;
           }else{
               if(mid * mid < n ){
                  start = mid +1;
               } else{
                   end = mid-1;
               }
           }
        }

       return result;
    }



}
