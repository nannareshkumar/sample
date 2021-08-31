package probs;

/**
 * Created by home on 11/26/2020.
 *
 *
 * Input:  txt[] = "THIS IS A TEST TEXT"
 pat[] = "TEST"
 Output: Pattern found at index 10

 Input:  txt[] =  "AABAACAADAABAABA"
 pat[] =  "AABA"
 Output: Pattern found at index 0
 Pattern found at index 9
 Pattern found at index 12
 */
public class RabinSearchAlgo {

    public static void main(String args[]){

        String s = "THIS IS A TEST TEXT";
        String s1 = "TEST";
        int prime = 11;

        char[] txt = s.toCharArray();
        char[] pat =  s1.toCharArray();

        search(txt, pat, prime);
    }


    public static void search(char[] txt, char[] pat, int prime){

        int d = 256;
        int p=0, t=0, h=1;
        int n = txt.length, m = pat.length, i, j;

        for (i = 0; i < m-1; i++)
            h = (h*d)%prime;

        // one time finding the hash value of pat
        for(i=0; i < m; i++){
            p = (d*p + pat[i])%prime;
            t = (d*t + txt[i])%prime;
        }

        for(i=0; i<=n-m;i++){
            if(p==t){
                for( j=0; j<m ; j++){
                   if(txt[i+j] != pat[j])
                       break;
                }
                if(j == m)
                System.out.println("Index of the pattern :"  + i);
            }
            if(i<n-m){
                t = (d*(t - txt[i]*h) + txt[i+m])%prime;
                if(t<0)
                    t = t+prime;
            }
        }
    }


    static void search2(char[] txt, char[] pat, int q)
    {
        int M = pat.length;
        int N = txt.length;
        int i, j, d=256;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M-1; i++)
            h = (h*d)%q;

        for (i = 0; i < M; i++) {
            p = (d*p + pat[i])%q;
            t = (d*t + txt[i])%q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++)
        {
            if ( p == t )
            {
                for (j = 0; j < M; j++) {
                    if (txt[i+j] != pat[j])
                        break;
                }
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            if ( i < N-M ) {
                t = (d*(t - txt[i]*h) + txt[i+M])%q;
                if (t < 0)
                    t = (t + q);
            }
        }
    }


}



