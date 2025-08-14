public class arrayaassign1{
    public static int integer1(int n[]){
        for(int i = 0;i<n.length;i++){
            for(int j =i+1; j<n.length;j++){
                if(n[i] == n[j]){
                    return n[i];
                }
            }
        }
        return -1;
    }


    public static int rotated_search(int n[], int target){
        int start = 0;
        int end = n.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(n[mid]==target){
                return mid;
            
            }
            if(n[start]<=n[mid]){
                if(n[start]<=target&&target<=n[mid]){
                    end = mid-1;

                }else{
                    start= mid+1;
                }
            }else{
                if(n[mid]<=target&&target<=n[end]){
                    start =mid+1;
                }else{
                    end = mid -1;
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        // int[] n ={1,2,3,3    };
        // System.out.println(integer1(n));
        int[] n ={4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(rotated_search(n,target));
    }
}