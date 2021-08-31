package stringman;

import static java.lang.Integer.parseInt;

/**
 * Created by home on 10/26/2020.
 */
public class RepeatString {


    public static void main(String args[]) {

        String s1 = "a1b2c3";
        String res = compute(s1, 5);
        System.out.println("value of result:" + res);
    }

    public static String compute(String s1, int index){

        String res = "-1";
        if(s1.length() > 0 && s1.length() >= index ) {

            String app = "";
            res = "";
            char[] chars = s1.toCharArray();
            for(int i =0; i<chars.length ; i++ ){
                char al = chars[i];
                app = "";
                if(Character.isDigit(al)){
                   int a2 = Integer.parseInt(al+"");

                   String rep = res.substring(res.length()-1);
                   for(int j = 1 ; j <= a2; j++)
                       app = app + rep;

                } else {
                    res = res + al;
                }
                if(!app.isEmpty())
                    res = res + app;
            }


        }
        return res;
    }




}
