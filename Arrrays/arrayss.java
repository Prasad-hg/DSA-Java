public class arrayss{
    public static  int arrayc(String n[] , String key){
        for(int i=0;i<n.length;i++){
            if(n[i].equals(key)){
                return  i;
            }
        }
        return -1;
    }
    


    public static int[] largestnum(int n[]){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<n.length;i++){
            if(max<n[i]){
                max=n[i];
            }
            if(min>n[i]){
                min=n[i];
            }
        }
        return new int[]{max,min};
    }
// ----------------------------------------------------

    public static int binary_search(int n[], int key){
        int start= 0 , end = n.length-1;
        while(start<=end){
            int mid  = (start+end)/2;
            if(n[mid]==key){
                return mid;
            }
            if(n[mid]<key){
                start = mid+1;

            }else{
                end= mid-1;
            }

        }
        return -1;
    }


    public static void reverse(int n[]){
        int first = 0, last = n.length-1;
        while(first<last){
            int temp = n[last];
            n[last] = n[first];
            n[first] = temp;
            first++;
            last--;
        }
    }

    public static void pair(int n[]){
        int totalcount = 0;
        
        for(int i= 0;i<=n.length-1;i++){
            for(int j = i+1;j<=n.length-1;j++){
                System.out.print("("+n[i]+ "," + n[j]+ ")");
                totalcount++;
            }
            System.out.println();
            
        }
        System.out.println(totalcount);
    }

    public static void subarray(int n[]){
        // int totalcount = 0;
        int sum = 0;
        int Maxsum = Integer.MIN_VALUE;
        int Minsum = Integer.MAX_VALUE;
        int [] prefix = new int[n.length];
        prefix[0]= n[0];
        for(int i=1;i<n.length;i++){
            prefix[i] = prefix[i-1]+n[i];
            System.out.println(prefix[i]);

        }
        for(int i = 0;i<n.length;i++){
            
            for(int j =i; j<n.length;j++){
                sum=i==0?prefix[j]:prefix[j]-prefix[i-1];

                // for(int k = i;k<=j;k++){
                //     System.out.print(n[k] +" ");
                //    sum+=n[k];
                // }

                if(Maxsum<sum){
                    Maxsum = sum;
                }
                if(Minsum>sum){
                    Minsum = sum;
                }
                 

                System.out.println();
            
                // totalcount++;
                 System.out.println("sum of subarray is " + sum);
                
            }
               
               
    }
        System.out.println();
        System.out.println("Maximum value is "+ Maxsum);
        System.out.println("Minimum value is "+ Minsum);
    
        // System.out.println("total count is " +  totalcount);
        
    }

   
// -----------------------------------------------------
public static void kadanes(int n []){
    int currsum = n[0];
    int Maxsum= n[0];
    for(int i=1;i<n.length;i++){
        currsum = Math.max(n[i],currsum+n[i]);
    
        Maxsum = Math.max(currsum, Maxsum);

    }
    System.out.println("Max sum of kadanes algo is " + Maxsum );
}
    public static void main(String args[]){
    //     String n[]={"apple", "mango", "kiwi", "papaya"};
    //     String key="papaya";
    //     int index = arrayc(n,key);
    //     if(index==-1){
    //         System.out.println("not found");
    //     }
    //     else{
    //         System.out.println(n[index]);
    //     }
    // }

    // int n[]={10,20,13,45,26};
    // int result[] = largestnum(n);
    // System.out.println(result[0]);
    // System.out.println(result[1]);

    // int n[]= {2,4,6,8,10};
    // int key = 6;
    // int k = (binary_search(n, key));
    // System.out.println(n[k]);

    // int n[] = {10,20,30,40,50,60};
    // reverse(n);
    // for(int i=0;i<n.length;i++){
    //     System.out.print(n[i]+"   ");
    // }
    // System.out.println();
// ------------------------------------------------------------

int n[] = {1,-2,6,-1,3};
//  pair(n);
// -----------------------------------------------------------------
    // subarray(n);

    kadanes(n);


}
}