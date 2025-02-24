import java.util.Scanner;

class Main {
    static int N, M;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

        dfs(1);

        System.out.println(cnt - 1);


    }

    static void dfs(int node) {
        visited[node] = true;
        cnt++;
        for (int i = 1; i <= N; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}