// trapping rainwater problem..

public class javaarray{
    public static int trappd_water(int height[]){
        int n = height.length;
        int leftmax[]=new int[height.length];
        leftmax[0] = height[0];
        for(int i = 1 ;i<n;i++){
            leftmax[i] = Math.max(leftmax[i-1],height[i]);
        }
        int rightmax[]= new int[height.length];
        rightmax[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--){
            rightmax[i] = Math.max(rightmax[i+1], height[i]);
            
        }
        int final1 = 0;
        for(int i = 0 ;i<n;i++){
            int trapped = Math.min(leftmax[i],rightmax[i]);
             final1 += (trapped - height[i]);
            
        }
        return final1;
        

    }


    public static void main(String args[]){
        int[] height = {4,2,0,6,3,2,5};
        System.out.println(trappd_water(height));
    }

}