package probs;

import java.util.*;

/**
 * Created by home on 11/10/2020.
 */
public class ScheduleInvite {

    public static void main(String args[]){

        int[][] mat = new int[3][16];
        Map<Integer, String> input = new HashMap();
        input.put(0, "9-9.30,11-11.30,11.30-12");
        input.put(1, "9-9.30,9.30-10,1-1.30,1.30-2");
        input.put(2, "10.30-11,11-11.30,3-3.30,3.30-4");

        Map<String, Integer> inputStr = prepareMap(input);
        int[][] inputArray = convertToBits(input, inputStr);
        int[] inputBits = commonInvite(inputArray);
        String result = conversionInvite(inputBits, inputStr);

        System.out.println("Common possible invite for all three users:" + result);

    }



    public static int[][] convertToBits(Map<Integer, String> input, Map<String, Integer> inputStr){

        int[][] result = new int[input.keySet().size()][16];
        if(input == null && input.isEmpty())
            return result;

        for(Map.Entry<Integer, String> item: input.entrySet()){
            String sch = item.getValue();
            int user = item.getKey();
            for(int i=0;i<16; i++)
                result[user][i]=1;

            StringTokenizer st = new StringTokenizer(sch,",");
            while(st.hasMoreTokens()) {
                Integer index = inputStr.get(st.nextToken());
                if (index != null)
                    result[user][index] = 0;
            }
        }
        return result;
    }

    public static int[] commonInvite(int[][] input){

        int[] result = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        for(int i=0;i<16; i++){
            int op = 1;
            for(int j=0;j<input.length;j++){
              op = op & input[j][i] ;
            }
            result[i]=op;
        }
       return result;
    }

    public static String conversionInvite(int[] inputBits, Map<String, Integer> inputStr){

        String resultStr="";
        for(int i=0; i< inputBits.length; i++){
           if(inputBits[i] == 1 ){

             Collection<Integer> values =  inputStr.values();
             for(Map.Entry<String, Integer> item: inputStr.entrySet()){
                   if (item.getValue() == i)
                      resultStr= (resultStr.isEmpty() ? "" : resultStr + ",") + item.getKey();
               }
           }
        }
        return resultStr;
    }

    public static Map<String, Integer> prepareMap(Map<Integer, String> input){

        Map<String, Integer> result = new HashMap();
        result.put("9-9.30",0);
        result.put("9.30-10",1);
        result.put("10-10.30",2);
        result.put("10.30-11",3);
        result.put("11-11.30",4);
        result.put("11.30-12",5);
        result.put("12-12.30",6);
        result.put("12.30-1",7);
        result.put("1-1.30",8);
        result.put("1.30-2",9);
        result.put("2-2.30",10);
        result.put("2.30-3",11);
        result.put("3-3.30",12);
        result.put("3.30-4",13);
        result.put("4-4.30",14);
        result.put("4.30-5",15);
        result.put("5-5.30",16);

        return result;
    }

}
