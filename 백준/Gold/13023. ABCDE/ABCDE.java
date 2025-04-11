import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static int n, m;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean found = false;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }


        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (found) break;
        }

        System.out.println(found ? "1" : "0");

    }

    private static void dfs(int now, int depth) {

        if (depth == 5) {
            found = true;
            return;
        }

        visited[now] = true;

        for (int next : list[now]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (found) return;
            }
        }

        visited[now] = false;
    }
}
