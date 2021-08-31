package interviewbit;

public class ContainerWithMostWater {

    public static void main(String args[]){
        int[] a = new int[]{1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(" result : " + c.maxHeight(a));
    }

    public int maxHeight(int[] height){
        int maxArea=0;
        int a = 0;
        int b = height.length- 1;

        while(a < b){
            if(height[a] < height[b]) {
                maxArea = Math.max(maxArea, height[a] * (b - a));
                a +=1;
            } else {
                maxArea = Math.max(maxArea, height[b] * (b - a));
                b-=1;
            }
        }
        return maxArea;
    }

}
