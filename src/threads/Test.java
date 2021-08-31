package threads;

import java.util.*;

/**
 * Created by home on 11/26/2016.
 */
public class Test {


    public static void main(String a[]) {

//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
//         System.out.print( "Is word Palindrome: " +  palindrome(s));

        amethod();

    }
    public static int findMiddleIndex(int[] numbers) throws Exception {

        int endIndex = numbers.length - 1;
        int startIndex = 0;
        int sumLeft = 0;
        int sumRight = 0;
        while (true) {
            if (sumLeft > sumRight) {
                sumRight += numbers[endIndex--];
            } else {
                sumLeft += numbers[startIndex++];
            }
            if (startIndex > endIndex) {
                if (sumLeft == sumRight) {
                    break;
                } else {
                    throw new Exception(
                            "Please pass proper array to match the requirement");
                }
            }
        }
        return endIndex;
    }

    public static boolean checkAnagram(String s1, String s2 ) {

        boolean value = false;
        s1 = s1.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\s", "");

        if (s1.length() != s2.length()) {
            value = false;
        } else {
            char[] s1a = s1.toLowerCase().toCharArray();
            char[] s1b = s2.toLowerCase().toCharArray();

            Arrays.sort(s1a);
            Arrays.sort(s1b);

            value = Arrays.equals(s1a, s1b);

        }
        return value;
    }

    public static Collection subStrings(String s, int k) {

        List<String> result = new ArrayList();

        List<String> list = new ArrayList();
        for (int i = 0; i <= (s.length() - k) ; i++) {
            list.add(s.substring(i,i+k));
        }
        Collections.sort(list);

        result.add(list.get(0));
        result.add(list.get(list.size()-1));

        System.out.println(" value of 1 element: " + result.get(0) + " and 2 element is : " + result.get(result.size()-1));

        return result;
    }

    public static boolean palindrome(String s) {
        boolean result = false;
//        String part1 = s.substring(0, s.length()/2);
//        String part2 = s.substring( s.length()/2, s.length());

        char[] chars = s.toCharArray();
        for (int i = 0, k = s.length()-1; i < s.length()/2 ; i++, k-- ){
            result = (chars[i] == chars[k]);
        }
        return result;
    }


    public static void amethod() {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");

        Spliterator<String> spliterator1 = list.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        spliterator1.forEachRemaining(System.out::println);

        System.out.println("========");

        spliterator2.forEachRemaining(System.out::println);
    }





}


