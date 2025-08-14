public class recursionhw{
    static String digits[]= {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void indices(int arr[], int i , int key){
        if(i == arr.length){
            return;
        }
        if(arr[i]==key){
            System.out.print(i+" ");
        }
         indices(arr, i+1, key);
    }
    // -------------
    public static void printDigits(int number){
        if(number == 0){
            return;
        }
        int lstdigit =number%10;
        printDigits(number/10);
        System.out.print(digits[lstdigit]+" ");
    }
    public static void main(String arge[]){
        // int arr[] = {3,2,4,5,6,2,7,2,2};
        // int key = 2;
        // int i=0;
        // indices(arr, i, key);
    System.out.println();
    printDigits(1030);
    }
}