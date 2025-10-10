import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        Map<String, Map<String, Integer>> map = new HashMap<>();
        Map<String, Integer> index = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        
        for (String friend : friends) {
            map.put(friend, new HashMap<>());
            index.put(friend, 0);
            result.put(friend, 0);
        }
        
        for (String gift : gifts) {
            StringTokenizer st = new StringTokenizer(gift);
            String from = st.nextToken();
            String to = st.nextToken();
            
            Map<String, Integer> inner = map.get(from);
            inner.put(to, inner.getOrDefault(to, 0) + 1);
            
            index.put(from, index.get(from) + 1);
            index.put(to, index.get(to) - 1);
        }
        
        int n = friends.length;
        for (int i = 0; i < n; i++) {
            String a = friends[i];
            for (int j = i + 1; j < n; j++) {
                String b = friends[j];
                
                int aToB = map.get(a).getOrDefault(b, 0);
                int bToA = map.get(b).getOrDefault(a, 0);
                
                if (aToB > bToA) {
                    result.put(a, result.get(a) + 1);
                } else if (bToA > aToB) {
                    result.put(b, result.get(b) + 1);
                } else {
                    int ia = index.get(a);
                    int ib = index.get(b);
                    if (ia > ib) {
                        result.put(a, result.get(a) + 1);
                    } else if (ib > ia) {
                        result.put(b, result.get(b) + 1);
                    }
                }
            }
        }
        
        int answer = 0;
        for (String friend : friends) {
            answer = Math.max(answer, result.get(friend));
        }
        
        return answer;
    }
}