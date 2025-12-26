import java.util.*;
public class maxArea{
    public static void max(int arr[]){
        int maxarea =0;
        int nsl[]= new int[arr.length];
        int nsr[]= new int[arr.length];
        Stack<Integer>s= new Stack<>();
        // next smaller left
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]= -1;
            }else{
                nsl[i]= s.peek();
            }
            s.push(i);
        }
        s = new Stack<>(); 
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]= arr.length;
            }else{
                nsr[i]= s.peek();
            }
            s.push(i);
        }

        for(int i=0;i<arr.length;i++){
            int curheight = arr[i];
            int area = curheight*(nsr[i] - nsl[i] - 1);
            maxarea = Math.max(area, maxarea);

        }
        System.out.println("max area " + maxarea);
    }
    public static void main(String args[]){
        int arr[] = {2,1,5,6,2,3};
        // int arr[] = {2,4};
        max(arr);
    }
}