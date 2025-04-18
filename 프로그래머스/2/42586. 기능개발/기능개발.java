import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int day = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            q.add(day);
        }
        
        List<Integer> list = new ArrayList<>();
        int now = q.poll();
        int count = 1;
        while(!q.isEmpty()) {
            int compare = q.poll();
            if (now >= compare) {
                count++;
            } else {
                list.add(count);
                now = compare;
                count = 1;
            }
        }
        list.add(count);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);    
        } 

        return answer;
    }
}