import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        
        Arrays.sort(costs, (a, b) -> {
            return a[2] - b[2];
        });
        
        UnionFind uf = new UnionFind(n);
        int answer = 0;
        int picked = 0;
        
        for (int[] e : costs) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            if (uf.union(u, v)) {
                answer += w;
                picked++;
                if (picked == n - 1) break;
            }
        }
        return answer;
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    
    UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
    
    boolean union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        
        if (ra == rb)   return false;
        
        if (size[ra] < size[rb]) {
            parent[ra] = rb;
            size[rb] += size[ra];
        } else {
            parent[rb] = ra;
            size[ra] += size[rb];
        }
        
        return true;
    }
}