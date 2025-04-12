import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	static int M, N, H;
	static int[][][] box;
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		H = Integer.parseInt(st.nextToken()); // 높이

		box = new int[H + 1][N + 1][M + 1];

		for (int h = 1; h <= H; h++) {
			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 1; m <= M; m++) {
					box[h][n][m] = Integer.parseInt(st.nextToken());
					if (box[h][n][m] == 1) {
						q.add(new Point(h, n, m));
					}
				}
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int i = 0; i < 6; i++) {
				int nz = now.z + dz[i];
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 1 || nx > N || ny < 1 || ny > M || nz < 1 || nz > H) continue;

				if (box[nz][nx][ny] == 0) {
					box[nz][nx][ny] = box[now.z][now.x][now.y] + 1;
					q.add(new Point(nz, nx, ny));
				}
			}
		}

		int days = 0;
		for (int h = 1; h <= H; h++) {
			for (int n = 1; n <= N; n++) {
				for (int m = 1; m <= M; m++) {
					if (box[h][n][m] == 0) return -1;
					days = Math.max(days, box[h][n][m]);
				}
			}
		}
		return days - 1;
	}
}

class Point {
	int x, y, z;
	Point(int z, int x, int y) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
