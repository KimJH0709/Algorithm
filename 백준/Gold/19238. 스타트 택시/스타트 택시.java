import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        Point start = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        Passenger[] passengers = new Passenger[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            passengers[i] = new Passenger(
                    new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1),
                    new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1),
                    false
            );
        }

        for (int i = 0; i < m; i++) {
            NearP np = getNearPassenger(passengers, start, map);

            if (np == null || fuel < np.distance) {
                System.out.println(-1);
                return;
            }

            fuel -= np.distance;
            Passenger p = np.passenger;
            int goToEnd = getEndDistance(p, p.start, map);

            if (goToEnd == -1 || fuel < goToEnd) {
                System.out.println(-1);
                return;
            }

            fuel += goToEnd;
            p.finish = true;
            start = p.end;
        }

        System.out.println(fuel);

    }

    private static int getEndDistance(Passenger p, Point start, int[][] map) {
        int n = map.length;
        Queue<Point> q = new LinkedList<>();
        int[][] visited = new int[n][n];
        q.add(start);
        visited[start.r][start.c] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == p.end.r && now.c == p.end.c) {
                return visited[now.r][now.c] - 1;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (map[nr][nc] == 1 || visited[nr][nc] != 0) continue;

                visited[nr][nc] = visited[now.r][now.c]  + 1;
                q.add(new Point(nr, nc));
            }
        }
        return -1;
    }

    static NearP getNearPassenger(Passenger[] passengers, Point start, int[][] map) {
        int n = map.length;
        int[][] visited = new int[n][n];
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.r][start.c] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if (map[nr][nc] == 1 || visited[nr][nc] != 0) continue;

                visited[nr][nc] = visited[now.r][now.c] + 1;
                q.add(new Point(nr, nc));
            }
        }

        int minDist = Integer.MAX_VALUE;
        Passenger result = null;

        for (Passenger p : passengers) {
            if (p.finish) continue;

            int r = p.start.r;
            int c = p.start.c;
            int dist = visited[r][c];

            if (dist == 0) continue;

            if (dist < minDist) {
                minDist = dist;
                result = p;
            } else if (dist == minDist) {
                if (r < result.start.r || (r == result.start.r && c < result.start.c)) {
                    result = p;
                }
            }
        }

        if (result == null) return null;
        return new NearP(result, minDist - 1);
    }

}

class NearP {
    Passenger passenger;
    int distance;

    NearP(Passenger passenger, int distance) {
        this.passenger = passenger;
        this.distance = distance;
    }
}

class Passenger {
    Point start, end;
    boolean finish;

    Passenger(Point start, Point end, boolean finish) {
        this.start = start;
        this.end = end;
        this.finish = finish;
    }
}

class Point {
    int r, c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}