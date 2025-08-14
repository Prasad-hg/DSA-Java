// STock price...problem

public class javaarray1{
    public static int buy_sell_stocks(int n[]){
        int buyprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int i= 0;i<n.length;i++){
            if(buyprice<n[i]){
                int profit = n[i] - buyprice;
                maxprofit =Math.max( maxprofit,profit);
            }else{
                buyprice = n[i];
            }
             
        }
        return maxprofit;
    }

    public static void main(String args[]){
        int [] n = {12,5,7,1,70,34,1,245};
        System.out.println(buy_sell_stocks(n));
    }
}