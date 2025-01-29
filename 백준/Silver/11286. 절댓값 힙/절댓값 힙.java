import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num == 0) {

                if (pq.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(pq.poll()[0]).append("\n");
                }


            } else {
                if (num >= 0) {
                    pq.add(new int[]{num, num});
                } else {
                    pq.add(new int[]{num, -num});
                }
            }
        }

        System.out.println(sb.toString());

    }
}
