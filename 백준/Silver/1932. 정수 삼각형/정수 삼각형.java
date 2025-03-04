import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dp = new int[n + 1][n + 1];
        int[][] num = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                num[i][j] = sc.nextInt();
            }
        }

        dp[1][1] = num[1][1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + num[i][j];
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[n][i] > max) {
                max = dp[n][i];
            }
        }

        System.out.println(max);
    }
}