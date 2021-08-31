package probs;

/**
 * Created by home on 1/7/2021.
 */
public class ContainerWater {


    public static void main(String args[]){
        int[] A = new int[]{1,8,6,2,5,4,8,3,7}; //{2,3,4,5,18,17,6}; //{1,8,6,2,5,4,8,3,7};

        System.out.println("Area of the container:"+ maxAreaUsingPointer(A));
    }

    public static int maxAreaUsingPointer(int[] height){
        int max=0, cal=0,i=0;
        int j=height.length-1;

        while(i < j){
            cal = Math.min(height[i], height[j]) * Math.abs(i-j);
            if(max < cal) {
                max = cal;
            }
            if(height[j] > height[i]){
                i++;
            }else if(height[j] < height[i]) {
                j--;
            } else if(height[i] == height[j]) {
                i++;
                j--;
            }
        }

        return max;
    }


    public static int maxArea(int[] height) {

        //min(i, j) * abs(i-j)
        int[][] m = new int[height.length][height.length];
        int max=0;
        for(int i =0; i< height.length; i++){
            for(int j=0; j< height.length; j++){
                m[i][j] = Math.min(height[i], height[j]) * Math.abs(i-j);
                if(m[i][j] > max) {
                    max = m[i][j];
                }
            }
        }

        return max;

    }

}
