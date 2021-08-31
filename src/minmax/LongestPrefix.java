package minmax;

/**
 * Created by home on 5/13/2020.
 */
public class LongestPrefix {

    public static void main(String args[]){

        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println("Resulted valued : " + longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        String result= "";
        String prev = "";

        if(strs.length == 0)
            return "";

        char[] chars = ((String) strs[0]).toCharArray();

        for(int j=0; j < chars.length; j++) {
            result = result + chars[j] ;
            for(int i = 0; i < strs.length; i++){
                if(!strs[i].startsWith(result)){
                    result = prev;
                    break;
                }
            }
            if(prev == result)
                break;
            prev = result;
        }
        return result;
    }
}
