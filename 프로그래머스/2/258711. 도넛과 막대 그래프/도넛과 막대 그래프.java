import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int max = 0;
        for (int[] edge : edges) {
            max = Math.max(max, Math.max(edge[0], edge[1]));
        }
        
        List<Integer>[] list = new ArrayList[max + 1];
        for (int i = 1; i <= max; i++) {
            list[i] = new ArrayList<>();
        }
        
        int[] indegree = new int[max + 1];
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            list[src].add(dst);
            
            indegree[dst]++;
        }
        
        int start = 0;
        int count = 0;
        for(int i = 1; i <= max; i++){
            if (indegree[i] != 0)   continue;
            if (list[i].size() > count) {
                start = i;
                count = list[i].size();
            }
        }
        answer[0] = start;
        
        // n 정점 n 간선 -> 도넛
        // n 정점 n-1 간선 -> 막대
        // 2n+1 정점 2n+2 간선 -> 8자
        
        for (int i = 0; i < list[start].size(); i++) {
            int vCount = 1;
            int eCount = 0;
            
            boolean[] visited = new boolean[max + 1];
            
            int v = list[start].get(i);
            Queue<Integer> q = new ArrayDeque<>();
            q.add(v);
            visited[v] = true;
            
            while(!q.isEmpty()) {
                int now = q.poll();
                eCount += list[now].size();
                
                for (int next : list[now]) {
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                        vCount++;
                    }
                }
            }
            
            if(vCount == eCount) answer[1]++;
            else if(vCount - 1 == eCount) answer[2]++;
            else answer[3]++;
            
        }
        
        
        return answer;
    }
}