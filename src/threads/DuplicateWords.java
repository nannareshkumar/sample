package threads; /**
 * Created by home on 3/3/2020.
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords
{
    public static void main(String[] args){

      userNameCheck();
    }

    public static void userNameCheck() {

        String constStr = "^[a-zA-Z][\\w]{7,29}$";
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());

        while(count > 0){
            String s = sc.nextLine();
            System.out.println( " value matches :" + s.matches(constStr));
            count--;
        }
        sc.close();
    }



    public static void duplicateCheck() {
        String pattern = "(\\b\\w+\\b)(\\s*\\1\\b)+";
        Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String input = in.nextLine();
            Matcher m = r.matcher(input);
            boolean findMatch = true;
            while(m.find( )){
                input = input.replaceAll(m.group(), m.group(1));
                findMatch = false;
            }
            System.out.println(input);
            testCases--;
        }

    }



}