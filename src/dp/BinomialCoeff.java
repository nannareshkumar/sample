package dp;

/**
 * Created by home on 2/24/2021.
 */
public class BinomialCoeff {

    public static void main(String args[]){

        BinomialCoeff bc = new BinomialCoeff();
        System.out.println("resultant value of :" + bc.binomial(5,2));
    }

    public int binomial(int n, int k){

        int C[][] = new int[n+1][k+1];
        int n0=1, n1=1, n2=1;

        for(int i = 1; i <=n; i++ ){
            for(int j = 1; j <=Math.min(i,k); j++ ){

                if(i==0 || j==i)
                    C[i][j]=1;
                else
                    C[i][j] = C[i-1][j-1] + C[i-1][j];
            }
        }

        return C[n][k];
    }


}
