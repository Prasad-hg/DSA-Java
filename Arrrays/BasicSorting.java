import java.util.*;
public class BasicSorting{
    public static void BubbleSort(int arr[]){
        for(int turn=0;turn<arr.length-1;turn++){
            boolean swap = false;
            for(int j=0;j<arr.length-1-turn;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap ) break;
        }
    }

    public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        // System.out.println();

    }

    public static void SelectionSort(int arr[]){
        for(int i = 0; i<arr.length-1;i++){
            int minval = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[minval]>arr[j]){
                    minval = j;
                }
            }
            int temp = arr[minval];
            arr[minval] = arr[i];
            arr[i] = temp;
        }
    }

    public static void InsertionSort(int arr[]){
        for(int i =1;i<arr.length;i++){
            int current = arr[i];
            int j = i-1;

            while(j>=0 &&arr[j]>current){
                arr[j+1] = arr[j];
                j--;

            }
            arr[j+1]= current;
        }
    }
    public static void main(String args[]){
        int arr[]= {5,4,1,3,2};
        InsertionSort(arr);
        printarr(arr);
    }

}
