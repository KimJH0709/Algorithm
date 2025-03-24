import java.util.Scanner;

public class Main {
    static int n, s;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0, false);

        System.out.println(count);
    }

    private static void dfs(int index, int currentSum, boolean isSelected) {
        if (index == n) {
            if (currentSum == s && isSelected) {
                count++;
            }
            return;
        }

        dfs(index + 1, currentSum, isSelected);
        dfs(index + 1, currentSum + arr[index], true);
    }
}