package probs;

/**
 * Created by home on 5/30/2020.
 */
public class MatchingPairs {


    public static void main(String args[]){

        System.out.println(" results of matchingPairs: " + matchingPairs("mno", "mnoA") );

    }

    public static int matchingPairs(String s, String t) {

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        int count = 0;
        for(int i=0 ; i < sChar.length; i++){
            if(sChar[i] == tChar[i] ){
                count+=1;
            } else {
                int j = t.indexOf(sChar[i]);
                if(j != -1) {
                    char tmp = sChar[i];
                    sChar[i] = sChar[j];
                    sChar[j] = tmp;
                    if (sChar[i] == tChar[i]) {
                        count += 1;
                    }
                }
            }

        }
        return count;
    }

}
