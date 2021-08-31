package stringman;

/**
 * Created by home on 12/23/2020.
 */
public class CodeString {

        // Driver program to test above function
        public static void main(String[] args) {
            char digits[] = {'2', '5', '1', '1', '4'};
            int n = digits.length;
            System.out.printf("Count is %d", countDecodingDP(digits, n));
        }

    static int countDecodingDP(char digits[], int n) {
        // A table to store results of subproblems
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;

        if(digits[0]=='0')   //for base condition "01123" should return 0
            return 0;

        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            if (digits[i - 1] > '0')
                count[i] = count[i - 1];

            if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }

    static int countDecoding(char[] digits, int n){
        if (n == 0 || n == 1)
            return 1;

        // for base condition "01123" should return 0
        if (digits[0]=='0')
            return 0;

        // Initialize count
        int count = 0;

        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        if (digits[n - 2] == '1' || (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }


}
