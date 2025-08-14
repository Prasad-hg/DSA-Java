public class trapedrainwater{
    public static int trappedwater(int[]n){
        int leftmax[] = new int[n.length];
        leftmax[0] = n[0];
        for(int i=1;i<n.length;i++){
            leftmax[i] = Math.max(n[i], leftmax[i-1]);
        }
        int rightmax[]= new int[n.length];
         rightmax[n.length-1] = n[n.length-1];
        for(int i = n.length-2;i>=0;i--){
            rightmax[i] = Math.max(n[i], rightmax[i+1]);

        }
        int final1 = 0;
        for(int i=0; i<n.length;i++){
            int trapped = Math.min(leftmax[i], rightmax[i]);
             final1+= trapped- n[i];
        }
        return final1;
    }
    public static void main(String[] args){
        int []n = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappedwater(n));
    }
}