package probs;

/**
 * Created by home on 11/8/2020.
 */
public class ConQRed {


    public static void main(String args[]){

        char[] colours = new char[]{'R','G', 'B','R', 'R', 'B','G','G', 'B', 'B','R', 'R', 'R','G', 'B'};

        System.out.println("Consecutive Reds:" + findRs(colours));

    }

    public static int findRs(char[] col){

        if(col.length <=0)
            return 0;

        int maxR=0, count=0; char prev=0;
        for (int i = 0; i < col.length ; i++) {

            if(i==0)
              prev = col[0];

            if(col[i]=='R'){
                count++;
            }else if(prev=='R' && prev !=col[i]) {
                maxR = maxR < count ? count : maxR;
                count = 0;
            }

            prev=col[i];
        }


        return maxR;

    }



}
