import java.util.*;

class Job {
    char id;
    int deadline;
    int profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

class jobSequence {

    static void jobSequencing(Job[] jobs) {

        // 1️⃣ Sort jobs by deadline (ascending)
        Arrays.sort(jobs, (a, b) -> a.deadline - b.deadline);

        // 2️⃣ Max heap based on profit
        PriorityQueue<Job> maxHeap =
                new PriorityQueue<>((a, b) -> b.profit - a.profit);

        int time = 0;

        // 3️⃣ Process each job
        for (Job job : jobs) {
            if (time < job.deadline) {
                // Slot available → take job
                maxHeap.add(job);
                time++;
            } else if (!maxHeap.isEmpty() &&
                       maxHeap.peek().profit < job.profit) {
                // Replace less profitable job
                maxHeap.poll();
                maxHeap.add(job);
            }
        }

        // 4️⃣ Print selected jobs
        ArrayList<Job> result = new ArrayList<>(maxHeap);
        result.sort((a, b) -> a.deadline - b.deadline);

        for (Job job : result) {
            System.out.print(job.id + " ");
        }
    }

    public static void main(String[] args) {

        Job[] jobs = {
            new Job('a', 4, 20),
            new Job('b', 1, 10),
            new Job('c', 1, 40),
            new Job('d', 1, 30)
        };

        jobSequencing(jobs);
    }
}
