import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][3];

        int[][] dp = new int[n][3];
        int[][] mdp = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[0][i] = board[0][i];
            mdp[0][i] = board[0][i];
        }

        // {n} 왼쪽 -> {n - 1}이 왼쪽, 가운데
        // {n} 가운데 -> {n - 1}이 왼쪽, 가운데, 오른쪽
        // {n} 오른쪽 -> {n - 1}이 가운데, 오른쪽

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        dp[i][j] = Math.max(dp[i - 1][0], dp[i - 1][1]) + board[i][j];
                        mdp[i][j] = Math.min(mdp[i - 1][0], mdp[i - 1][1]) + board[i][j];
                        break;
                    case 1:
                        dp[i][j] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + board[i][j];
                        mdp[i][j] = Math.min(mdp[i - 1][0], Math.min(mdp[i - 1][1], mdp[i - 1][2])) + board[i][j];
                        break;
                    case 2:
                        dp[i][j] = Math.max(dp[i - 1][1], dp[i - 1][2]) + board[i][j];
                        mdp[i][j] = Math.min(mdp[i - 1][1], mdp[i - 1][2]) + board[i][j];
                        break;
                };
            }
        }

        System.out.println(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2])) + " " +
                Math.min(mdp[n - 1][0], Math.min(mdp[n - 1][1], mdp[n - 1][2])));

    }
}