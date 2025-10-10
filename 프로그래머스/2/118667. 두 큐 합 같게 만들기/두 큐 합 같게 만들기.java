import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        long sumQ1 = 0;
        long sumQ2 = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sumQ1 += queue1[i];
        }
        
        for (int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sumQ2 += queue2[i];
        }
        
        int count = 0;
        while (count <= 4 * queue1.length) {
            if (sumQ1 > sumQ2) {
                int num = q1.poll();
                q2.add(num);
                sumQ1 -= num;
                sumQ2 += num;
                count++;
            } else if (sumQ1 < sumQ2) {
                int num = q2.poll();
                q1.add(num);
                sumQ1 += num;
                sumQ2 -= num;
                count++;
            } else {
                return count;
            }
        }        
    
        return -1;
    }
}