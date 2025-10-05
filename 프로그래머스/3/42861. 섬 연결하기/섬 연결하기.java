import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        Arrays.sort(costs, (c1, c2) -> {
            return c1[2] - c2[2];
        });
        
        int edges = 0;
        
        for (int[] e : costs) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            
            int pu = parent[u];
            int pv = parent[v];
            
            if (pu == -1 && pv == -1) {
                int rep = Math.min(u, v);
                parent[u] = rep;
                parent[v] = rep;
                answer += w;
                edges++;
            } else if (pu != -1 && pv == -1) {
                int rep = Math.min(pu, v);
                for (int i = 0; i < n; i++) {
                    if (parent[i] == pu) {
                        parent[i] = rep;
                    }
                }
                parent[v] = rep;
                answer += w;
                edges++;
            } else if (pu == -1 && pv != -1) {
                int rep = Math.min(pv, u);
                for (int i = 0; i < n; i++) {
                    if (parent[i] == pv) {
                        parent[i] = rep;
                    }
                }
                parent[u] = rep;
                answer += w;
                edges++;
            } else if (pu != pv) {
                int rep = Math.min(pu, pv);
                int old = Math.max(pu, pv);
                for (int i = 0; i < n; i++) {
                    if (parent[i] == pu || parent[i] == pv) {
                        parent[i] = rep;
                    }
                }
                answer += w;
                edges++;
            } else {}
            
            if (edges == n - 1) break;
        }
        
        return answer;
    }
}