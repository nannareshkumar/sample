package array;

/**
 * Created by home on 5/7/2020.
 */
public class Fibonacci {

        //exponential
        static int fib(int n, int i)
        {
            if (n <= 1)
                return n;
            System.out.print(" n:" + n + " i:" + i++);
            return fib(n-1, i) + fib(n-2, i);
        }

        //linear
        static int fibo(int n, int count){
            if(n <= 1 )
                return n;

            int[] f = new int[n+1];
            f[0] = 0;
            f[1] = 1;
            for(int i = 2; i<=n; i++){
              f[i] = f[i-1] + f[i-2];
              System.out.print("\t f[" + i + "]" + f[i]);
              count++;
            }
            System.out.println("count :" + count);
            return f[n];
        }

    //improve the space complexity by O(1)
    public int fib(int n) {
        if (n < 2) return n;
        int n1 = 1, n2 = 0;
        for (int i = 2; i < n; i++) {
            int n0 = n1 + n2;
            n2 = n1;
            n1 = n0;
        }

        return n1 + n2;
    }

        public static void main (String args[])
        {
            int n = 10;
            System.out.println(" exponential:" + fib(n, 1));
            System.out.println(" linear:" + fibo(n,1));
        }
}
