import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static int v;
	static LinkedList<Node>[] list;
	static boolean[] visited;
	static int maxFar;
	static int maxDistance;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		
		list = new LinkedList[v + 1];
		for (int i = 1; i <= v; i++) {
			list[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int src = Integer.parseInt(st.nextToken());
			
			while (true) {
				int dst = Integer.parseInt(st.nextToken());
				if (dst == -1) break;
				int weight = Integer.parseInt(st.nextToken());
				list[src].add(new Node(dst, weight));
			}
		}
		visited = new boolean[v + 1];
		maxFar = 1;
		maxDistance = 0;
		
		bfs(1);
		
		visited = new boolean[v + 1];
		maxDistance = 0;
		bfs(maxFar);
		
		System.out.println(maxDistance);
		
	}

	private static void bfs(int start) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(start, 0));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			if(now.distance > maxDistance) {
				maxDistance = now.distance;
				maxFar = now.start;
			}
			
			for (Node next : list[now.start]) {
				if (!visited[next.start]) {
					q.add(new Node(next.start, now.distance + next.distance));
					visited[next.start] = true;
				}
			}
		}
		
	}
}

class Node {
	int start;
	int distance;

	Node(int start, int distance) {
		this.start = start;
		this.distance = distance;
	}
}