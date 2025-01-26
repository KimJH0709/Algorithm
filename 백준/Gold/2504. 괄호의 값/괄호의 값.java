import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();

        Stack<Character> stack = new Stack<>();

        int result = 0;
        int tmp = 1;

        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
                tmp *= 2;
            } else if (c == '[') {
                stack.push(c);
                tmp *= 3;
            } else {
                if (stack.isEmpty()) {
                    result = 0;
                    break;
                }

                if (c == ')') {
                    if (stack.peek() == '(') {
                        if (input.charAt(i - 1) == '(') {
                            result += tmp;
                        }
                        stack.pop();
                        tmp /= 2;
                    } else {
                        result = 0;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.peek() == '[') {
                        if (input.charAt(i - 1) == '[') {
                            result += tmp;
                        }
                        stack.pop();
                        tmp /= 3;
                    } else {
                        result = 0;
                        break;
                    }
                }
            }
        }
        
        if (!stack.isEmpty()) {
            result = 0;
        }
        System.out.println(result);
    }
}