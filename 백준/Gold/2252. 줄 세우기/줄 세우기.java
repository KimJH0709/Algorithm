import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        @SuppressWarnings("unchecked")
        List<Integer>[] list = new List[n + 1];
        int[] indegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int src = sc.nextInt();
            int dist = sc.nextInt();
            list[src].add(dist);
            indegree[dist]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");

            for (int next : list[now]) {
                indegree[next]--;
                    if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
