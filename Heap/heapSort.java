import java.util.*;

public class heapSort {

    // ---------- HEAP SORT ----------
    public static void heapSort(int arr[]) {

        int n = arr.length;

        // STEP 1: Build Max Heap
        // Start from last non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // STEP 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {

            // Swap root (largest) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify reduced heap
            heapify(arr, 0, i);
        }
    }

    // ---------- HEAPIFY (Max Heap) ----------
    public static void heapify(int arr[], int i, int size) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            // Swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            // Heapify affected subtree
            heapify(arr, maxIdx, size);
        }
    }

    // ---------- MAIN ----------
    public static void main(String args[]) {

        int arr[] = {1, 2, 4, 5, 3};

        heapSort(arr);

        // Print sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
