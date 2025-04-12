import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];

		Queue<Point> q = new LinkedList<>();

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 1; m <= M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while (true) {
			visited = new boolean[N + 1][M + 1];
			int count = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (map[i][j] > 0 && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}

			if (count == 0) {
				System.out.println(0);
				break;
			}

			if (count >= 2) {
				System.out.println(year);
				break;
			}

			melt();
			year++;
		}

	}

	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr >= 1 && nc >= 1 && nr <= N && nc <= M) {
					if (!visited[nr][nc] && map[nr][nc] > 0) {
						visited[nr][nc] = true;
						q.add(new Point(nr, nc));
					}
				}
			}
		}

	}

	static void melt() {
		int[][] temp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] > 0) {
					int water = 0;

					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];

						if (nr >= 1 && nc >= 1 && nr <= N && nc <= M) {
							if (map[nr][nc] == 0) {
								water++;
							}
						}
					}

					temp[i][j] = Math.max(map[i][j] - water, 0);
				}
			}
		}
		for(int i = 1; i<= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
}

class Point {
	int r, c;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}