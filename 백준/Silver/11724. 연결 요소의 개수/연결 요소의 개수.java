import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= N; i++) {
                if(graph[now][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    static void dfs(int node) {
        Stack<Integer> s = new Stack<>();
        s.push(node);
        visited[node] = true;

        while(!s.isEmpty()) {
            int now = s.pop();
            for (int i = 1; i <= N; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    s.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    /*static void dfs(int node) {
        visited[node] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }*/
}
