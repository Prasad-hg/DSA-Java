import java.util.*;
public class practiseQ{
   
    public static Boolean pair_sum(ArrayList<Integer> list){
         Boolean inc = true;
        Boolean dec = true;
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                inc = false;
            }
            if(list.get(i)<list.get(i+1)){
                dec = false;
            }
            }
            return inc||dec;
        }
   
     
    
    public static void main(String args[]){
        ArrayList<Integer>list = new ArrayList<>(Arrays.asList(2,11,5,7,9));
        //  list.add(11);
        // list.add(15);
        // list.add(6);
        // list.add(8);
        // list.add(9);
        // list.add(10);
        
    System.out.println(pair_sum(list));
    }
}