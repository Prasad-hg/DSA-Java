import java.util.*;

public class Classroom {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // ---------- ADD (Heapify Up) ----------
        public void add(int data) {
            // step 1: add at last index
            arr.add(data);

            int x = arr.size() - 1;     // child index
            int par = (x - 1) / 2;      // parent index

            // heapify up
            while (x > 0 && arr.get(x) < arr.get(par)) {
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        // ---------- REMOVE / DELETE ROOT ----------
        public int remove() {
            if (arr.size() == 0) {
                throw new RuntimeException("Heap is empty");
            }

            int data = arr.get(0);

            // step 1: swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step 2: delete last
            arr.remove(arr.size() - 1);

            // step 3: heapify down from root
            heapify(0);

            return data;
        }

        // ---------- HEAPIFY DOWN ----------
        private void heapify(int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        // ---------- PEEK ----------
        public int peek() {
            if (arr.size() == 0) {
                throw new RuntimeException("Heap is empty");
            }
            return arr.get(0);
        }

        // ---------- ISEMPTY ----------
        public boolean isEmpty() {
            return arr.size() == 0;
        }

        // ---------- PRINT ----------
        public void printHeap() {
            System.out.println(arr);
        }
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        Heap h = new Heap();

        h.add(5);
        h.add(3);
        h.add(8);
        h.add(1);
        h.add(2);

        System.out.println("Heap array:");
        h.printHeap();

        System.out.println("Peek (min): " + h.peek());

        System.out.println("Removing elements:");
        while (!h.isEmpty()) {
            System.out.println(h.remove());
        }
    }
}
