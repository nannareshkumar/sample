package matrix;

/**
 * Created by home on 12/21/2020.
 */
public class GreedyMinJumps {

    public static void main(String args[]){

        String input = ". . . . x . . x x . . . x . .";
        //String input =  "x.xx..."; //"....x..xx...x.."; //expected
        int minJumps = seats(input);
        System.out.println("Total min jumps : " + minJumps);
    }

    public static int seats(String A) {

        int res =0,i,j, rand[] = new int[A.length()];
        if(A.length() == 0)
            return res;

        for(i=0, j=0; i < A.length(); i++){
            String s = A.charAt(i)+"";
            if(s.equals("x")){
                rand[j] = i;
                j++;
            }
        }

        if(j ==0)
          return res;

        int mid=j/2, start, end;
        for(int k =0; k < j; k++){
                start = rand[k];
                end = rand[mid] - mid + k;
                res += Math.abs(end - start)%10000003;
        }

        return res%10000003;
    }
}
