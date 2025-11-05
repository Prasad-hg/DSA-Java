import java.util.*;

public class LonelyNumbers {
    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(nums);  // sort ArrayList

        int n = nums.size();

        // case 1: only one element
        if (n == 1) {
            list.add(nums.get(0));
            return list;
        }

        // check first element
        if (nums.get(0) + 1 < nums.get(1) && nums.get(0) != nums.get(1)) {
            list.add(nums.get(0));
        }

        // check middle elements
        for (int i = 1; i < n - 1; i++) {
            int prev = nums.get(i - 1);
            int curr = nums.get(i);
            int next = nums.get(i + 1);

            if (prev + 1 < curr && curr + 1 < next &&
                curr != prev && curr != next) {
                list.add(curr);
            }
        }

        // check last element
        if (nums.get(n - 2) + 1 < nums.get(n - 1)) {
            list.add(nums.get(n - 1));
        }

        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 3, 5, 3));
        System.out.println(findLonely(nums)); // Output: [1, 5]
    }
}
