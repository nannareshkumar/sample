package stringman;

/**
 * Created by home on 6/3/2020.
 */
public class StringAddition {

    public static void main(String args[]) {

       String result = stringAddition("123", "12");
       System.out.println("Resulted value of :" + result);

    }

    public static String stringAddition(String s1, String s2 ){

        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        Integer result = null;

        for(int i=first.length-1; i >=0; i--) {
            int d1 = i < first.length ? Integer.valueOf(String.valueOf(first[first.length-i])) : 0;
            int d2 = i < second.length ? Integer.valueOf(String.valueOf(second[second.length-i])) : 0;
            
            result = Integer.valueOf(d1 + d2);
        }


       return String.valueOf(result);
    }

}
