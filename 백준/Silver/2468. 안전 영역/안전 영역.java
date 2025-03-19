import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {-1, 0, 1, 0};
        Queue<Point> q = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (max < map[i][j]) max = map[i][j];
            }
        }

        for (int rain = 0; rain <= max; rain++) {
            boolean[][] visited = new boolean[n][n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] > rain && !visited[i][j]) {
                        q.add(new Point(i, j));
                        visited[i][j] = true;
                        while(!q.isEmpty()) {
                            Point now = q.poll();
                            for (int k = 0; k < 4; k++) {
                                int nr = now.r + dr[k];
                                int nc = now.c + dc[k];

                                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

                                if (map[nr][nc] > rain && !visited[nr][nc]) {
                                    q.add(new Point(nr, nc));
                                    visited[nr][nc] = true;
                                }
                            }
                        }
                        cnt++;
                    }
                }
            }
            set.add(cnt);
        }
        System.out.println(set.pollLast());
    }
}

class Point {
    int r;
    int c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}