import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static int F, S, G, U, D;
	static int[] visited;
	static boolean[] checked;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken()); // 총 층
		S = Integer.parseInt(st.nextToken()); // 현재 위치 
		G = Integer.parseInt(st.nextToken()); // 가야하는 곳 
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		
		visited = new int[F + 1];
		checked = new boolean[F + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		checked[S] = true;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			if (now == G) {
				System.out.println(visited[G]);
				return;
			}
			
			int[] nextStep = {now - D, now + U};
			
			for (int next : nextStep) {
				if (next >= 1 && next <= F && !checked[next]) {
					checked[next] = true;
					visited[next] = visited[now] + 1;
					q.add(next);

				}
			}
		}
		
		System.out.println("use the stairs");
	}
}