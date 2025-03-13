import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 도시의 개수
        int m = sc.nextInt(); // 도로의 개수
        int k = sc.nextInt(); // 거리 정보
        int x = sc.nextInt(); // 출발 도시

        @SuppressWarnings("unchecked")
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        for (int i = 0; i < m; i++) {
            list[sc.nextInt()].add(sc.nextInt());
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        distance[x] = 0;

        while(!q.isEmpty()) {
            int now = q.poll();

            for (int next : list[now]) {
                if (distance[next] == -1) {
                    distance[next] = distance[now] + 1;
                    q.add(next);
                }
            }
        }

        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                found = true;
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}