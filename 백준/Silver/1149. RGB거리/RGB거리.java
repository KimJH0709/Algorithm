import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[n + 1][5];

        final int R = 1, G = 2, B = 3;
        for (int i = 1; i <= n; i++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();
            dp[i][R] = Math.min(dp[i - 1][G], dp[i - 1][B]) + r;
            dp[i][G] = Math.min(dp[i - 1][R], dp[i - 1][B]) + g;
            dp[i][B] = Math.min(dp[i - 1][G], dp[i - 1][R]) + b;
        }

        System.out.println(Math.min(dp[n][R], Math.min(dp[n][G], dp[n][B])));
    }
}