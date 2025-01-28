import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        ArrayList<int[]> pairs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                pairs.add(new int[]{stack.pop(), i});
            }
        }  // (, ) 쌍의 인덱스들을 pairs 리스트에 입력

        int n = pairs.size();
        Set<String> result = new TreeSet<>();

        int maxCount = (int) Math.pow(2, n);
        // 비트마스킹을 이용
        for (int i = 1; i < maxCount; i++) {
            boolean[] remove = new boolean[input.length()];

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    remove[pairs.get(j)[0]] = true;
                    remove[pairs.get(j)[1]] = true;
                }
            }

            StringBuilder current = new StringBuilder();
            for (int k = 0; k < input.length(); k++) {
                if (!remove[k]) {
                    current.append(input.charAt(k));
                }
            }

            result.add(current.toString());
        }

        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());

    }
}