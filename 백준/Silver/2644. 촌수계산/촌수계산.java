import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static LinkedList<Integer>[] list;
	static boolean[] visited;
	static int[] chons;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		list = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new LinkedList<>();
		}
		visited = new boolean[n + 1];
		chons = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int target1 = Integer.parseInt(st.nextToken());
		int target2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int dst = Integer.parseInt(st.nextToken());
			
			list[src].add(dst);
			list[dst].add(src);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(target1);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			visited[now] = true;
			
			for (int next : list[now]) {
				if (!visited[next]) {
					q.add(next);
					visited[next] = true;
					chons[next] = chons[now] + 1;
				}
			}
		}
		
		System.out.println((chons[target2] == 0) ? "-1" : chons[target2]);
	}
}