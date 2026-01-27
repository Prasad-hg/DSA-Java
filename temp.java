public class temp{
    public static void printdec(int n){
        if(n==0){
            // System.out.print(1+" ");
            return;
        }
        System.out.print(n+" ");

        printdec(n-1);
        System.out.print(n+" ");

    }
   public static void main(String args[]){
    int n =10;
    printdec(n);
   } 

}