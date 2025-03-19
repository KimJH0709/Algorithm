import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {-1, 0, 1, 0};
        List<Integer> list = new ArrayList<>();
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                if(map[i][j]==0){
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int count = 0;
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        Point now = q.poll();
                        count++;
                        for (int k = 0; k < 4; k++) {
                            int nr = now.r + dr[k];
                            int nc = now.c + dc[k];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 1 && !visited[nr][nc]) {
                                q.add(new Point(nr, nc));
                                visited[nr][nc] = true;
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for (int size : list) {
            System.out.println(size);
        }

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