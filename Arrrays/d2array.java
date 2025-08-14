import java.util.*;
public class d2array{
    public static boolean search(int arr[][], int key){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==key){
                    System.out.println("("+i+","+j+")");
                    return true;
                }
            }
        }
        System.out.println("not found!!");
        return false;
    }

    public static void largeSmall(int arr[][]){
        int largest = 0;
        int smallest = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                
                    largest+= arr[i][j];
                    smallest = Math.min(arr[i][j], smallest);
                
            }
        }
        System.out.println(largest); 
        System.out.println(smallest);

    }
    public static void main(String args[]){
        int  [][] arr= new int [3][3];
        int r = arr.length, c = arr[0].length;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the numbers");
        for(int i = 0; i<r;i++){
            for(int j =0;j<c;j++){
                arr[i][j]= sc.nextInt();
            }
        }
        System.out.println("output:");
        for(int i = 0; i<r;i++){
            for(int j =0;j<c;j++){
                System.out.print(arr[i][j]+ " "); 
            }
            System.out.println();
        }
    int key = 6;
    search(arr, key );

    largeSmall(arr);
    }
}