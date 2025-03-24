import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] cost;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        cost = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        for (int start = 0; start < n; start++) {
            visited[start] = true;
            dfs(start, start, 0, 0);
            visited[start] = false;
        }

        System.out.println(min);
    }

    private static void dfs(int start, int current, int count, int currentCost) {
        if (count == n - 1) {
            if (cost[current][start] != 0) {
                int totalCost = currentCost + cost[current][start];
                min = Math.min(min, totalCost);
            }
            return;
        }

        for (int next = 0; next < n; next++) {
            if (visited[next] || cost[current][next] == 0) continue;

            visited[next] = true;
            dfs(start, next, count + 1, currentCost + cost[current][next]);
            visited[next] = false;
        }
    }
}