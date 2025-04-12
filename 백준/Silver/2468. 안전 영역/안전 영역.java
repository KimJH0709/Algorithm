import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[][] map;
	static int max = Integer.MIN_VALUE;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > max) max = map[i][j];
			}
		}
		
		int result = 1;
		
		for (int h = 1; h < max; h++) {
			visited = new boolean[N + 1][N + 1];
			int safeArea = 0;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					
					if (!visited[i][j] && map[i][j] > h) {
						bfs(i, j, h);
						safeArea++;
					}
					
					
				}
			}
			result = Math.max(result, safeArea);

		}
		
		System.out.println(result);
		
	}


	static void bfs(int r, int c, int height) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if (nr >= 1 && nc >= 1 && nr <= N && nc <= N) {
					if (!visited[nr][nc] && map[nr][nc] > height) {
						visited[nr][nc] = true;
						q.add(new Point(nr, nc));
					}
				}
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