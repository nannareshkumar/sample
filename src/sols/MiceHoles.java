package sols;

/**
 * Created by home on 1/17/2021.
 */
public class MiceHoles {

    public static void main(String args[]){
        MiceHoles mh = new MiceHoles();

        int[] A = new int[] { -49,  58,  72, -78, 9, 65, -42, -3 };
        int[] B = new int[] {  30, -13, -70,  58, -34, 79, -36, 27 };

        System.out.println("result : " +mh.mice(A, B));
    }

    public int mice(int[] A, int[] B) {

        int res=0, max=0;
        if(A.length == B.length){
            for(int i=0; i< A.length; i++ ){
                if(A[i] > B[i])
                    res = A[i] - B[i];
                else
                    res = B[i] - A[i];
                if(res > max)
                    max = res;
            }
        }
        return max;
    }
}
