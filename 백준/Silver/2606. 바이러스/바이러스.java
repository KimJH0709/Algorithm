import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	
	static boolean[] visited;
	static LinkedList<Integer>[] list;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int m = Integer.parseInt(br.readLine()); // 간선의 수
		
		visited = new boolean[n + 1];
		list = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < m ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());
			
			list[src].add(dst);
			list[dst].add(src);
		}
		
		bfs(1);
		
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (visited[i])	count++;
		}
		
		System.out.println(count);
		
	}
	private static void bfs(int start) {
	
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (int next : list[now]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		
	}
}