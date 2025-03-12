import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static int n, result;
    static int[] queens;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            result = 0;
            queens = new int[n];

            placeQueen(0);

            sb.append("#" + t + " " + result).append("\n");
        }

        System.out.println(sb);
    }

    private static void placeQueen(int row) {
        if (row == n) {
            result++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                queens[row] = col;
                placeQueen(row + 1);
            }
        }
    }

    private static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) {
                return false;
            }
            if (Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}