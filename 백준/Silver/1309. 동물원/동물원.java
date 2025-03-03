import java.util.Scanner;

class Main {
    final static int NONE = 0;
    final static int LEFT = 1;
    final static int RIGHT = 2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dp = new int[3][n + 1];
        // {n}에는 오른쪽에만 배치할 수 있다. {n - 1} 왼쪽에 사자가 있다면
        // dp[right][n] = dp[left][n - 1] + dp[none][n -1]
        // {n}에는 왼쪽에만 배치할 수 있다. {n - 1} 오른쪽에 사자가 있다면
        // dp[left][n] = dp[right][n - 1] + dp[none][n - 1]
        // 사자를 배치하지 않는다면 이전 모든 상태에서 가능하다.
        // dp[none][n] = dp[left][n - 1] + dp[right][n - 1] + dp[none][n - 1]

        dp[LEFT][1] = 1;
        dp[RIGHT][1] = 1;
        dp[NONE][1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[LEFT][i] = (dp[RIGHT][i - 1] + dp[NONE][i - 1]) % 9901;
            dp[RIGHT][i] = (dp[LEFT][i - 1] + dp[NONE][i - 1]) % 9901;
            dp[NONE][i] = (dp[LEFT][i - 1] + dp[RIGHT][i - 1] + dp[NONE][i - 1]) % 9901;
        }

        System.out.println((dp[0][n] + dp[1][n] + dp[2][n]) % 9901);



    }
}