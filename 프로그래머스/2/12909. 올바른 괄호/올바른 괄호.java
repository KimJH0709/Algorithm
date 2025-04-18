import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty())    return false;
                if (ch == ')' && stack.pop() != '(')    return false;
            }
        }
        
        return stack.isEmpty();
    }
}