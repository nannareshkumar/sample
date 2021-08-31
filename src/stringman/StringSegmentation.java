package stringman;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by home on 9/16/2020.
 */
public class StringSegmentation {

    public static void main(String args[]){

        HashSet<String> dic = new HashSet();
        String s = "apple"; dic.add(s); s = "pie"; dic.add(s); s = "peer"; dic.add(s); s = "pier"; dic.add(s); s= "pear"; dic.add(s);

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        Set<String> values =  fetching(line, dic);

        Iterator iter = values.iterator();
        while(iter.hasNext()){
            System.out.println("Values :" + iter.next());
        }

    }

    public static Set<String> fetching(String input, Set<String> dic){

        if(input == null || dic == null || dic.isEmpty())
            return null;


        int j =0, k =0;
        HashSet fetched = new HashSet();

        char[] chars = input.toCharArray();
        for(int i=0; i<=chars.length; i++){
            String sub = input.substring(j, i);
            if(dic.contains(sub)){
                fetched.add(sub);
                j=i;
            }
        }
        return fetched;

    }

}
