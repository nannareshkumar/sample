package dp;

public class TextJustification {

    public String justify(String words[], int width) {

        int cost[][] = new int[words.length][words.length];

        for(int i=0; i < words.length; i++){
            cost[i][i] = width - words[i].length();
            for(int j =i+1 ; j < words.length; j++){
                cost[i][j] = cost[i][j-1] - words[j].length()-1;
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                if(cost[i][j] < 0)
                    cost[i][j] = Integer.MAX_VALUE;
                else {
                    cost[i][j] = (int) Math.pow(cost[i][j], 2);
                }
            }
        }

        int minCost[] = new int[words.length];
        int result[] = new int[words.length];

        for (int i = words.length-1; i >=0; i--) {
            minCost[i] = cost[i][words.length-1];
            result[i] = words.length;
            for (int j = words.length-1; j >i ; j--) {

                if(cost[i][j-1] == Integer.MAX_VALUE)
                    continue;

                if(minCost[i] > minCost[j] + cost[i][j-1]) {
                    minCost[i] = minCost[j] + cost[i][j - 1];
                    result[i] = j;
                }
            }
        }

        System.out.println(" Minimum cost :" + minCost[0]);
        int  i=0, j = result[i];
        StringBuffer sb = new StringBuffer();

        while(j < words.length) {
            j = result[i];

            for (int k = i; k < j; k++) {
                  sb.append(words[k] + " ");
            }
            sb.append("\n");
            i = j;
        }
         return  sb.toString();
    }

    public static void main(String args[]){
        String words1[] = {"This", "is", "an", "example", "of", "text", "justification."};
        TextJustification awl = new TextJustification();
        System.out.println(awl.justify(words1, 16));
    }

}
