package stringman;

/**
 * Created by home on 10/29/2020.
 */
public class StringManupulation {

    public static void main(String[] args) {
        String str = "Welcome to Beginnersbook";
        reverse(str);
        //System.out.println("The reversed string is: " + reversed);
    }

    public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void reverse(String str)
    {
        if ((str==null)||(str.length() <= 1))
            System.out.println(str);
        else
        {
            System.out.print(str.charAt(str.length()-1));
            reverse(str.substring(0,str.length()-1));
        }
    }
}