package threads; /**
 * Created by home on 3/3/2020.
 */

import java.util.Scanner;
import java.util.regex.*;

public class PatternEx {
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());
            while(testCases>0){
                String pattern = in.nextLine();
                try{
                    System.out.println("value of pattern " + pattern);
                    Pattern pat=Pattern.compile(pattern);
                    System.out.println("Valid");
                }catch(Exception e){System.out.println("Invalid");}
                testCases--;
            }
        }
    }