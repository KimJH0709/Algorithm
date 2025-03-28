import java.util.*;

public class Main {
    static int n,m;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static Integer[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        result = new int[m];

        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        nums = set.toArray(new Integer[0]);

        Arrays.sort(nums);

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {

        if (depth == m) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < nums.length; i++) {
            result[depth] = nums[i];
            dfs(depth + 1, i);
        }
    }
}