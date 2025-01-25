import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();

        Deque<int[]> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        while (!deque.isEmpty()) {

            int[] target = deque.pollFirst();
            sb.append(target[0]).append(" ");

            if (deque.isEmpty()) {
                break;
            }

            int steps = target[1];
            if (steps > 0) {
                steps = (steps - 1) % deque.size();
                for (int i = 0; i < steps; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                steps = (-steps) % deque.size();
                for (int i = 0; i < steps; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }

        }

        System.out.println(sb.toString());
    }
}