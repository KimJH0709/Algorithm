import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	static int[][] maze;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		maze = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			String line = br.readLine();
			for (int j = 1; j <= m; j++) {
				maze[i][j] = line.charAt(j-1) - '0';
			}
 		}
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(1, 1));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if (nr > n || nr < 1 || nc > m || nc < 1) {
					continue;
				}
				
				if (maze[nr][nc] == 1) {
					q.add(new Point(nr, nc));
					maze[nr][nc] = maze[now.r][now.c] + 1;
				}
			}
		}
		
		System.out.println(maze[n][m]);
	}

}


class Point {
	int r;
	int c;
	Point (int r, int c) {
		this.r = r;
		this.c = c;
	}
}