import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int ans = n / 3;

            sb.append("#" + t + " " + ans + "\n");
        }

        System.out.println(sb);
    }
}