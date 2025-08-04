
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Stack<Character> stack = new Stack<Character>();
		
		int sum = 0;
		char prev = ' ';
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (i > 0) {
				prev = str.charAt(i - 1);
			}
			
			if (c == '(') {
				stack.push(c);
			}
			else {
				stack.pop();
				if (i > 0 && prev == '(') {
					sum += stack.size();
				} else if (i > 0 && prev == ')') {
					sum += 1;
				}
			}
		}
		
		System.out.println(sum);

	}

}
