import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, Integer> countMap = new HashMap<>();
        for (String id : id_list) {
            countMap.put(id, 0);
        }
        
        Map<String, List<String>> reporterMap = new HashMap<>();
        
        Set<String> set = new HashSet<>(Arrays.asList(report));
        
        for (String s : set) {
            StringTokenizer st = new StringTokenizer(s);
            String from = st.nextToken();
            String to = st.nextToken();
            
            countMap.put(to, countMap.get(to) + 1);
            
            reporterMap.putIfAbsent(from, new ArrayList<>());
            reporterMap.get(from).add(to);
        }
        
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            if (reporterMap.containsKey(user)) {
                for (String reported : reporterMap.get(user)) {
                    if (countMap.get(reported) >= k) {
                        answer[i]++;
                    }
                }
            }
        }
        
        return answer;
    }
}