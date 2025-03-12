import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // SCORE
                arr[i][1] = Integer.parseInt(st.nextToken()); // CALORIE
            }

            int maxScore = bfs(n, l, arr);
            sb.append("#" + t + " " + maxScore).append("\n");

        }
        System.out.println(sb);
    }

    private static int bfs(int n, int l, int[][] arr) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0, 0, 0});

        int maxScore = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int index = now[0];
            int score = now[1];
            int calorie = now[2];

            if (calorie <= l) {
                maxScore = Math.max(maxScore, score);
            }

            if (index < n) {
                q.add(new int[]{index + 1, score, calorie}); // 재료 선택X

                int newScore = score + arr[index][0];
                int newCalorie = calorie + arr[index][1];

                if (newCalorie <= l) {
                    q.add(new int[]{index + 1, newScore, newCalorie}); // 재료 선택O
                }
            }
        }
        return maxScore;
    }
}


