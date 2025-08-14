public class recursion{
    public static void printDec(int n){
        if(n<=1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void printInc(int n){
        if(n==1){
            System.out.print("1"+" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }
    public static int factNum(int n){
        if(n==1){
            return 1;
        }
        int fact = factNum(n-1);
        int fn = n*fact;
        // System.out.println(fn);
        return fn;
    }
    public static int sumNum(int n){
        if(n==1){
            return 1;
        }
        int sum1 =sumNum(n-1);
        int total = n+sum1;
        return total;
    }
    public static int fib(int n){
        if(n==0||n==1){
            return n;
        }
        int fib1 = fib(n-1);
        int fib2 = fib(n-2);
        int final1 =  fib1 +fib2;
        return final1;
    }
    public static boolean sorted(int arr[], int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return sorted(arr, i+1);
    
    }
    public static int firstOcc(int[]arr, int key, int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOcc(arr, key, i+1);
    }
    public static int lastOcc(int []arr, int key, int i){
        if(i==arr.length){
            return -1;
        }
        int isFound = lastOcc(arr, key, i+1);
        if(isFound==-1&&arr[i]==key){
            return i;
        }
        return isFound;
    }
    public static int  tilingPrb(int n){
        // Base case
        if (n==0||n==1){
            return 1;
        }
        // vertica case
        int vertical = tilingPrb(n-1);
        // horizontal
        int horizontal = tilingPrb(n-2);
        int finalway = vertical + horizontal;
        return finalway;
    }
    // -------------------------
    public static void removeDUp(String str, int idx, StringBuilder newStr, boolean map[]){
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }
        char currchar= str.charAt(idx);
        if(map[currchar-'a']==true){
            removeDUp(str, idx+1, newStr, map);
        }else{
            map[currchar-'a']=true;
            removeDUp(str, idx+1, newStr.append(currchar), map);
        }
    }
    // ----------------
    public static int friendspairing(int n){
        if(n==0||n==1){
            return 1;
        }
        // single
        int fnm1 = friendspairing(n-1);
        int fnm2 = friendspairing(n-2);
        int pairways = n-1 * fnm2;
        int totalways = fnm1 + pairways;
        return totalways;

    }
    public static void printBinaryStrings(int n , int lastplace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinaryStrings(n-1, 0, str+"0");
        if(lastplace==0){
            printBinaryStrings(n-1, 1, str+"1");
        }
    }
    public static void main(String args[]){
        // int n=25;
        // printDec(n);
        // printInc(n);
        // factNum(n);
        //  System.out.println(factNum(n));
        //  System.out.println(sumNum(n));
        //  System.out.println(fib(n));
        // int []arr = {1,2,5,4,5,5 };
        // int key =5;
     
        // System.out.println(sorted(arr, 0));
        // System.out.println(firstOcc(arr,key, 0));
        // System.out.println(lastOcc(arr,key, 0));
        // int n = 4;
        // System.out.println(tilingPrb(n));
        // String str = "appnacollege";
        // removeDUp(str, 0, new StringBuilder(""), new boolean[26]);
        // int n =3;
        // int res= friendspairing(n);
        // System.out.println(res);
        
        printBinaryStrings(3,0,"");
    }
}