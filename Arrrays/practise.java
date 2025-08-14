public class practise{
    public static void practise(int arr[][], int key){
        int row = 0, col = 0;
        int count =0;
        while(row<arr.length){
            col=0;
            while(col<arr[0].length){
            if(arr[row][col]==key){
                count++;
            }
            col++;
            }
        
            row++;
            
        }
        System.out.println(count);
    }
// ----------------------------------
    public static int stringCount(String str){
     
        int count=0;
        for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);

            if(ch=='a'|| ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
        }
        return count;
    }
    public static void main(String args[]){
        // int[][]arr = {{4,7,8},
        //             {8,8,7}};
        //             int key = 7;
        //             practise(arr, key);
        String str = "Praesad";
        System.out.println(stringCount(str));
    }
}