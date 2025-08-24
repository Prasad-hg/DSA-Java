public class MajorityElementDivideConquer {

    // Main function to call recursive majority element finder
    public static int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    // Recursive function
    private static int majorityElementRec(int[] nums, int lo, int hi) {
        // Base case: only one element
        if (lo == hi) {
            return nums[lo];
        }

        // Split into two halves
        int mid = lo + (hi - lo) / 2;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // If both halves agree, that's the majority
        if (left == right) {
            return left;
        }

        // Otherwise, count each candidate in current range
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    // Helper function to count how many times target appears in [lo..hi]
    private static int countInRange(int[] nums, int target, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        return count;
    }

    // Driver code
    public static void main(String[] args) {
        int nums[] = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + majorityElement(nums));
    }
}
