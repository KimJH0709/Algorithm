import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test_case; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            Queue<int[]> queue = new LinkedList<>();

            int[] prior = new int[N];
            for (int j = 0; j < N; j++) {
                int importance = Integer.parseInt(st.nextToken());
                queue.add(new int[]{j, importance});
                prior[j] = importance;
            }

            Arrays.sort(prior);

            int printOrder = 0;

            while(!queue.isEmpty()) {
                int[] current = queue.poll();

                if (current[1] == prior[N - 1]) {
                    printOrder++;
                    N--;
                    if (current[0] == M) {
                        sb.append(printOrder).append("\n");
                        break;
                    }
                } else {
                    queue.add(current);
                }
            }
        }
        System.out.println(sb.toString());
    }
}