import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        int visited[] = new int[n + 1];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 1;
        
        int max = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    max = Math.max(max, visited[next]);
                    q.add(next);
                }
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            if (max == visited[i])
                answer++;
        }
        
        
        return answer;
    }
}