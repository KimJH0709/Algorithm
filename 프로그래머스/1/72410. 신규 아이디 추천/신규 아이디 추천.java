import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        new_id = new_id.toLowerCase();
        
        //2단계
        Deque<Character> d = new ArrayDeque<>();
        for (char ch : new_id.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '-' || ch == '_' || ch == '.') {
                d.add(ch);
            }
        }

        // 3단계
        Deque<Character> d2 = new ArrayDeque<>();
        while (!d.isEmpty()) {
            char ch = d.poll();

            if (ch == '.') {
                if (!d2.isEmpty() && d2.peekLast() == '.') {
                    continue;
                }
                d2.addLast(ch);
            } else {
                d2.addLast(ch);
            }
        }

        // 4단계
        if (!d2.isEmpty() && d2.peekFirst() == '.') {
            d2.pollFirst();
        }
        if (!d2.isEmpty() && d2.peekLast() == '.') {
            d2.pollLast();
        }

        // 5단계
        if (d2.isEmpty()) {
            d2.add('a');
        }

        // 6단계
        while (d2.size() > 15) {
            d2.pollLast();
        }

        if (!d2.isEmpty() && d2.peekLast() == '.') {
            d2.pollLast();
        }

        // 7단계
        while (d2.size() < 3) {
            d2.addLast(d2.peekLast());
        }
        
        for (char c : d2) {
            answer += c;
        }
        
        return answer;
    }
}

// 소문자, 숫자, 빼기, 밑줄, 마침표
// 마침표는 처음 끝 연속 X

// 1 - 모든 대문자를 소문자로
// 2 - 소문자 숫자 빼기 밑줄 마침표 제외 제거
// 3 - 마침표 2번 이상 연속은 1개로 치환
// 4 - 마침표 처음 끝이면 제거
// 5 - 빈문자열이면 a 대입
// 6 - 16자 이상이면 15자 이후 제거 마지막 마침표면 마침표도 제거
// 7 - 2자 이하라면 3자가 될때까지 마지막 문자 반복