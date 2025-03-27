import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];

        dfs(0, 1);
        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {

        if (depth == m) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++) {
            result[depth] = i;
            dfs(depth + 1, i);
        }
    }
}