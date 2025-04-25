import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean isContain = false;
        for (String word : words) {
            if (word.equals(target))
                isContain = true;
        }
        if (!isContain) return 0;
        
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[words.length];
        
        for (int i = 0; i < words.length; i++) {
            if (diffOne(begin, words[i])) {
                q.add(i);
                visited[i] = 1;
            }
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            String nowWord = words[now];

            for (int i = 0; i < words.length; i++) {
                if (visited[i] == 0 && diffOne(nowWord, words[i])) {
                    visited[i] = visited[now] + 1;
                    q.add(i);
                }
            }
        }
        
         for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                return visited[i];
            }
        }

        return 0;
        
    }
    
    static boolean diffOne(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                count++;
        }
        
        return count == 1 ? true : false;
    }
}