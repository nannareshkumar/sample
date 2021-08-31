package probs; /**
 * Created by home on 8/28/2020.
 */
import java.util.Scanner;

public class Bitwise_Addition
{
    static long add(long x, long y)
    {
        int carry, ans;
        while(y!=0)
        {
            ans = (int) x ^ (int) y;
            carry = (int) (x & y) << 1;
            x = ans;
            y = carry;
        }
        return x;
    }
    public static void main(String args[])
    {
        System.out.println("Enter the numbers to be added:");
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        System.out.println("The Summation is: "+add(x, y));
    }
}