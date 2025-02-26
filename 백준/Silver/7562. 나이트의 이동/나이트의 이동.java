import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int tc, n;
    static int[][] board;
    static int[][] visited;
    static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dc = {1, -1, 2, -2, 2, -2, 1, -1};
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            n = sc.nextInt();
            board = new int[n][n];
            visited = new int[n][n];
            Point start = new Point(sc.nextInt(), sc.nextInt());
            Point end = new Point(sc.nextInt(), sc.nextInt());

            Queue<Point> q = new LinkedList<>();
            q.add(start);
            visited[start.r][start.c] = 1;
            while (!q.isEmpty()) {
                Point now = q.poll();
                if (now.r == end.r && now.c == end.c) {
                    System.out.println(visited[end.r][end.c] - 1);
                    break;
                }
                for (int j = 0; j < 8; j++) {
                    int nr = now.r + dr[j];
                    int nc = now.c + dc[j];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    if (visited[nr][nc] == 0) {
                        q.add(new Point(nr, nc));
                        visited[nr][nc] = visited[now.r][now.c] + 1;
                    }
                }
            }
        }
    }
}

class Point {
    int r, c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}