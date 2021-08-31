package stringman;

/**
 * Created by home on 12/17/2020.
 */
public class StringExists {

    public static void main(String args[]){
//         String A= "eZCHXr0CgsB4O3TCDlitYI7kH38rEElI"; "aabcc"
//         String B= "UhSQsB6CWAHE6zzphz5BIAHqSWIY24D";  "dbbca"
//         String C="eUZCHhXr0SQsCgsB4O3B6TCWCDlAitYIHE7k6H3z8zrphz5EEBlIIAHqSWIY24D";  "aadbbcbcac"

     String A = "noUdRp97xFvpifeSXGwOjcVNhHo9N2D";
     String B = "6iZItw9A3fj86uYx04tvWKLtl9BK";
     String C = "n6ioUdRpZ97ItwxF9Av3fj86upYxif0eS4XtvWKLtlG9wOBKjcVNhHo9N2D";

     System.out.println("result : " + isInterleaveDP("aabcc", "dbbca", "aadbbcbcac") );
    }


    public static boolean isInterleavedRecursive(String A, String B, String C, int pos1, int pos2, int pos3){
        if(pos1 == A.length() && pos2 == B.length() && pos3 == C.length()){
            return true;
        }

        if(pos3 == C.length()){
            return false;
        }

        return (pos1 < A.length() && A.charAt(pos1) == C.charAt(pos3) && isInterleavedRecursive(A, B, C, pos1+1, pos2, pos3+1))
                || (pos2 < B.length() && B.charAt(pos2) == C.charAt(pos3) && isInterleavedRecursive(A, B, C, pos1, pos2+1, pos3+1));

    }
    

    public static int isInterleave(String A, String B, String C) {

       return isInterleavedRecursive( A,  B, C,  0,0, 0) ? 1 :0;


//        int aInd=0, bInd=0,cInd=0;
//        int res =0; String out="";
//
//        for(int i=0; i<C.length();i++){
//            String c = C.charAt(i)+"";
//            if( aInd < A.length() && c.equals(A.charAt(aInd)+"")){
//                aInd++;
//            }else if( bInd < B.length() && c.equals(B.charAt(bInd)+"")){
//                bInd++;
//            }else{
//                out +=c;
//            }
//        }
//
//        res = (out.length()>0) ? 0 : 1;
//        return res;

    }


    public static int isInterleaveDP(String A, String B, String C){
        boolean T[][] = new boolean[A.length() +1][B.length() +1];

        if(A.length() + B.length() != C.length()){
            return 0;
        }

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length; j++){
                int l = i + j -1;
                if(i == 0 && j == 0){
                    T[i][j] = true;
                }
                else if(i == 0){
                    if(C.charAt(l) == B.charAt(j-1)){
                        T[i][j] = T[i][j-1];
                    }
                }
                else if(j == 0){
                    if(A.charAt(i-1) == C.charAt(l)){
                        T[i][j] = T[i-1][j];
                    }
                }
                else{
                    T[i][j] = (A.charAt(i-1) == C.charAt(l) ? T[i-1][j] : false) || (B.charAt(j-1) == C.charAt(l) ? T[i][j-1] : false);
                }
            }
        }
        return T[A.length()][B.length()] == true ? 1 :0 ;
    }

}
