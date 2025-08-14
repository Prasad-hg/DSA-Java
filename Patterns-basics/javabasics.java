import java.util.*;

public class javabasics {
    

    public static String palendrome(int n){
        int org = n;
        int reverse =0;
        
        while(n!=0){
              int x = n %10;
             reverse = reverse*10 +x;
             n = n/10;
        }
        if(org == reverse){
            return "palendrome";
        }else{
            return "not a palendrome";
        }
    }

    public static int sum(int n){
         int sum1 = 0;
        while(n!=0){
            int digit = n%10;
            sum1+=digit;
            n/=10;
        }
        return sum1;

    }

    public static void hollowrec(int totalrow, int totalcol){
        for(int i=1;i<=totalrow;i++){
            for(int j=1;j<=totalcol;j++){
                if(i==1||i==totalrow||j==1||j==totalcol){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }
        
    }

    public static void rotated_half_pyramid(int n){
        for(int i =1; i<=n; i++){
            for(int j=1;j<=n-i;j++){
            System.out.print(" ");
            }
            for(int j =1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void half_pyramid_with_num(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void floyds_triangle(int n){
        int counter = 1;
        for(int i =1;i<=n;i++){
            for(int j =1;j<=i;j++){
                System.out.print(counter+" ");
                counter++;
            }
        System.out.println();
        }
    }

    public static void zero_one_traingle(int n){
        for(int i =1;i<=n;i++){
            for (int j=1;j<=i;j++){
                int sum =i+j;
                if(sum%2==0){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }            
        }
        System.out.println();
    }
    
    }

    public static void butterfly(int n){
        for (int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i=n;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }

            for(int j=1;j<=2*(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public static void solid_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hallow_rhombus(int n){
         for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                if(i==1||i==n||j==1||j==n){
                    System.out.print("*");

                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
         }
    }

    public static void diamond(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for( int j=1;j<=((2*i)-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for( int j=1;j<=(2*i)-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        }
    }
    public static void main(String args[]) {
        //  rotated_half_pyramid(4);
        // half_pyramid_with_num(5);
        // floyds_triangle(5);
        // zero_one_traingle(5);
        // butterfly(5);
        // solid_rhombus(5);
        // hallow_rhombus(9);
        diamond(5);
    
}
