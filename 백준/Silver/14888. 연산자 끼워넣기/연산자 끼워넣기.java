import java.util.Scanner;

public class Main {
    static int n;
    static int[] nums;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        dfs(1, nums[0], sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());


        System.out.println(maxValue);
        System.out.println(minValue);
    }

    static void dfs(int idx, int result, int plus, int minus, int multiply, int divide) {

        if (idx == n) {
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
        }

        if (plus > 0) dfs(idx + 1, result + nums[idx], plus - 1, minus, multiply, divide);
        if (minus > 0) dfs(idx + 1, result - nums[idx], plus, minus - 1, multiply, divide);
        if (multiply > 0) dfs(idx + 1, result * nums[idx], plus, minus, multiply - 1, divide);
        if (divide > 0) dfs(idx + 1, result / nums[idx], plus, minus, multiply, divide - 1);
    }
}
