import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            int n = Integer.parseInt(br.readLine());

            int[][] map = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                String line = br.readLine();
                for (int j = 1; j <= n; j++) {
                    map[i][j] = line.charAt(j - 1) - '0';
                }
            }

            int sum = 0;
            int center = n / 2 + 1;
            for (int i = 1; i <= n; i++) {
                int start = Math.abs(center - i) + 1;
                int end = n - Math.abs(center - i);
                
                for (int j = start; j <= end; j++) {
                    sum += map[i][j];
                }
            }

            sb.append("#" + t + " " + sum).append("\n");
        }

        System.out.println(sb.toString());

    }
}