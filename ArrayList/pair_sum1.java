import java.util.ArrayList;
public class pair_sum1{
    public static Boolean pair_sum(ArrayList<Integer> list, int target){
        int left = 0, right = list.size()-1;
        while(left<right){
            if(list.get(left)+list.get(right)==target){
                return true;
            }
            if(list.get(left)+list.get(right)<target){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer>list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        int target = 20;
    System.out.println(pair_sum(list, target));
    }
}