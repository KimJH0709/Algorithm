import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N, K;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new int[100001];

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visited[N] = 1;

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == K) {
				System.out.println(visited[now] - 1);
				return;
			}
			
			int[] nextStep = { now + 1, now - 1, now * 2 };

			for (int next : nextStep) {
				if (next >= 0 && next <= 100000 && visited[next] == 0) {
					q.add(next);
					visited[next] = visited[now] + 1;
				}
			}
		}


	}
}