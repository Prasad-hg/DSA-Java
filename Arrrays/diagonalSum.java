public class diagonalSum{
    public static int diagonalSum(int matrix[][]){
        int sum = 0;
        for(int i=0;i<matrix.length;i++){
            // for(int j =0;j<matrix[0].length;j++){
                // if(i==j){
                //     sum+=matrix[i][j];
                // }
                // else if(i+j==matrix.length-1){
                //     sum+=matrix[i][j];
                    
                // }
                sum+=matrix[i][i];
                if(i!=matrix.length-i-1){
                    sum+=matrix[i][matrix.length-i-1];
                }
            
        }
        return sum;
    }
    public static boolean stairCaseSearch(int matrix[][] ,int key){
        int col = 0, row = matrix.length-1;
        while(col<matrix.length && row>=0){
            if(matrix[row][col]==key){
                System.out.print("found key at("+row+","+col+")");
                return true;
            }
            else if(key<matrix[row][col]){
                row--;
            }
            else{
                col++;
            }

        }
        System.out.println("key not found");
        return false;
    }
    public  static void main(String args[]){
        int matrix[][] = {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16},
                     };
                     
        int key = 2;
    // System.out.println(diagonalSum(matrix));
    stairCaseSearch(matrix,key);
   
    }
}