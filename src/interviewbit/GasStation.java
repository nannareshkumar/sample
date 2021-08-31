package interviewbit;

public class GasStation {

    public static void main(String args[] ){
        int[] gas = new int[] {1, 2};
        int[] cost = new int[]{2, 1};

        System.out.println(" Starting from index :" + canCompleteCircuit(gas, cost) + " will make circular");
    }
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public static int canCompleteCircuit(final int[] A, final int[] B) {
            int total = 0, tank = 0, index = 0;
            for (int i = 0; i < B.length; i++) {
                int consume = A[i] - B[i];
                tank += consume;
                if (tank < 0) {
                    index = i + 1;
                    tank = 0;
                }
                total += consume;
            }
            return total < 0 ? -1 : index; // check if total -ve which means we can't complete the trip.
        }

}
