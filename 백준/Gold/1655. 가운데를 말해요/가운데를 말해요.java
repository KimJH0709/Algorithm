import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(num);

                if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            } else {
                minHeap.add(num);

                if (maxHeap.peek() > minHeap.peek()) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb.toString());
    }
}
