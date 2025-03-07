import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    static List<Integer>[] graph;
    static int[] color;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        for (int tc = 0; tc < k; tc++) {
            int v = sc.nextInt();
            int e = sc.nextInt();
            
            
            graph = new List[v + 1];
            color = new int[v + 1];
            for (int i = 0; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < e; i++) {
                int src = sc.nextInt();
                int dist = sc.nextInt();
                graph[src].add(dist);
                graph[dist].add(src);
            }
            for (int i = 1; i <= v; i++) {
                dfs(i, 0);
            }

            boolean isBinary = true;
            for (int i = 1; i <= v; i++) {
                for (int next : graph[i]) {
                    if (color[i] == color[next]) {
                        isBinary = false;
                        break;
                    }
                }
            }
            System.out.println(isBinary ? "YES" : "NO");
        }
    }

    static int RED = 1;
    static int BLUE = 2;
    private static void dfs(int nodeNum, int depth) {
        if (color[nodeNum] != 0) return;
        if (depth % 2 == 0) color[nodeNum] = RED;
        else color[nodeNum] = BLUE;

        for (int next : graph[nodeNum]) {
            dfs(next, depth + 1);
        }
    }
}