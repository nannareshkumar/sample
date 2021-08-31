package stringman;

/**
 * Created by home on 5/30/2020.
 */
public class StringRotation {


    public static void main(String args[]){


        for(int i =0; i<=256; i++){
            System.out.print(" "+i + " " + (char) i );
        }


//        String str = rotationalCipher("Zebra-493?", 3);
//        System.out.println("resultant value: " + str);
//
//        str= rotationalCipher("All-convoYs-9-be:Alert1.", 4);
//        System.out.println("resultant value: " + str);
    }

   static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
       String result = "";

        if(rotationFactor <= 0 || input.equals(""))
            result = input;

       String regex = "^[a-zA-Z0-9]+$";

       //Pattern pattern = Pattern.compile(regex);

        for(int i=0;i<input.length();i++) {
             char ele = input.charAt(i);

             if((ele >= 65 && ele <= 91) ) {
                ele = (char)(((ele + rotationFactor - 65) % 26) + 65);
            } else if((ele >= 97 && ele <= 123) ) {
                 ele = (char)(((ele + rotationFactor - 97) % 26) + 97);
             } else if((ele >= 48 && ele <= 57) ) {
                 ele = (char) (((ele + rotationFactor - 48) % 10) + 48);
             }
            result = result + ele;
        }


        return result;
    }

}
