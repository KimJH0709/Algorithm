import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = sc.nextInt();
        }

        int max = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(num[j] < num[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max,  dp[i]);
            }
        }

        System.out.println(max);


    }
}