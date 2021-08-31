package bytebybyte;

public class AddBinary {

    public static void main(String args[]){

        String a = "1001", b = "0011";

        System.out.println( Integer.parseInt(a, 2) + "  " + Integer.parseInt(b, 2));
        int res = sum(Integer.parseInt(a, 2), Integer.parseInt(b, 2));
        System.out.println("value of  a + b binary numbers: " + res + " binary: " + Integer.toBinaryString(res));

    }


    public static int sum(int a, int b) {
        if (b == 0) return a;
        int partialSum = a ^ b;
        int carry = (a & b) << 1;
        return sum(partialSum, carry);
    }

}
