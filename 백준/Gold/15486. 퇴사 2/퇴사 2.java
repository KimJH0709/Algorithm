import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];

        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i]);
            if(i + t[i] > n + 1) continue;
            dp[i + t[i]] = Math.max(dp[i + t[i]], p[i] + dp[i]);
        }

        System.out.println(dp[n + 1]);
    }
}