public class BitManipulation {

    // 1️⃣ Get ith bit
    static boolean getBit(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    // 2️⃣ Set ith bit
    static int setBit(int n, int i) {
        return n | (1 << i);
    }

    // 3️⃣ Clear ith bit
    static int clearBit(int n, int i) {
        return n & ~(1 << i);
    }

    // 4️⃣ Toggle ith bit
    static int toggleBit(int n, int i) {
        return n ^ (1 << i);
    }

    // 5️⃣ Check even or odd
    static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    // 6️⃣ Check power of 2
    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // 7️⃣ Count set bits (Brian Kernighan)
    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    // 8️⃣ Remove rightmost set bit
    static int removeRightmostSetBit(int n) {
        return n & (n - 1);
    }

    // 9️⃣ Isolate rightmost set bit
    static int isolateRightmostSetBit(int n) {
        return n & (-n);
    }

    // 🔟 Generate all subsets using bitmask
    static void generateSubsets(int[] arr) {
        int n = arr.length;

        for (int mask = 0; mask < (1 << n); mask++) {
            System.out.print("{ ");
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println("}");
        }
    }

    // MAIN METHOD — TEST EVERYTHING
    public static void main(String[] args) {

        int n = 13; // 1101
        int i = 2;

        System.out.println("Number n = " + n);

        System.out.println("Get bit " + i + ": " + getBit(n, i));
        System.out.println("Set bit " + i + ": " + setBit(n, i));
        System.out.println("Clear bit " + i + ": " + clearBit(n, i));
        System.out.println("Toggle bit " + i + ": " + toggleBit(n, i));

        System.out.println("Is Even: " + isEven(n));
        System.out.println("Is Power of 2: " + isPowerOfTwo(n));

        System.out.println("Count set bits: " + countSetBits(n));
        System.out.println("Remove rightmost set bit: " + removeRightmostSetBit(n));
        System.out.println("Isolate rightmost set bit: " + isolateRightmostSetBit(n));

        int[] arr = {1, 2, 3};
        System.out.println("Subsets:");
        generateSubsets(arr);
    }
}
