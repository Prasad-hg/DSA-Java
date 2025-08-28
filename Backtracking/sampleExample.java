public class sampleExample{
    public static void changeArr(int[]arr, int i, int val){
        if(i==arr.length){
            printArr(arr);
            return ;
        }
        arr[i]= val;
        changeArr(arr,i+1,val+1);
        arr[i]= arr[i]-2;
    }

    public static void printArr(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    public static void main(String args[]){
        int arr[]= new int[5];
        int i= 0;
        int val =1;
        changeArr(arr, i, val);
        printArr(arr);

    }
}