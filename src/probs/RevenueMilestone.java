package probs;

/**
 * Created by home on 5/30/2020.
 *
 *
 * Revenue Milestones
 We keep track of the revenue Facebook makes every day, and we want to know on what days Facebook hits certain revenue
 milestones. Given an array of the revenue on each day, and an array of milestones Facebook wants to reach, return an array
 containing the days on which Facebook reached every milestone.
 Signature
 int[] getMilestoneDays(int[] revenues, int[] milestones)
 Input
 revenues is a length-N array representing how much revenue FB made on each day (from day 1 to day N). milestones is a length-K array of total revenue milestones.
 Output
 Return a length-K array where K_i is the day on which FB first had milestones[i] total revenue.
 Example
 revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
 milestones = [100, 200, 500]
 output = [4, 6, 10]
 Explanation
 On days 4, 5, and 6, FB has total revenue of $100, $150, and $210 respectively. Day 6 is the first time that FB has >= $200 of total revenue.
 *
 *
 *
 */
public class RevenueMilestone {

    public static void main(String args[]){

        int[] revenues = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] milestones = new int[]{100, 200, 500};

        int[] result = getMilestoneDays(revenues, milestones);
        print(result);

        revenues = new int[]{100, 200, 300, 400, 500};
        milestones= new int[]{300, 800, 1000, 1400};
        //int expected_1[] = {2, 4, 4, 5};
        result = getMilestoneDays(revenues, milestones);
        print(result);

        revenues = new int[]{700, 800, 600, 400, 600, 700};
        milestones = new int[]{3100, 2200, 800, 2100, 1000};
        //expected_2[] = {5, 4, 2, 3, 2};


    }

    static int[] getMilestoneDays(int[] revenues, int[] milestones) {

        int[] result = new int[milestones.length];
        if(milestones.length == 0 && revenues.length > 0)
            return result = new int[revenues[1]];

        int target=0, sum=0;
        for(int mil=0 ; mil < milestones.length; mil++) {
            sum=0;
            for (int i = 0; i < revenues.length; i++) {
                target = milestones[mil];
                sum = sum + revenues[i];
                if (sum >= target) {
                    result[mil] = i + 1;
                    break;
                }
            }
        }
        return result;
    }


    static void print(int[] result){
        System.out.println("\n");
        for(int i=0; i< result.length; i++){
            System.out.print(" " + result[i]);
        }
    }


}
