import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean isValid = true;

        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int left = x - r;
            int right = x + r;

            list.add(new int[]{left, right});
        }

        list.sort((c1, c2) -> {
            if (c1[0] != c2[0])
                return c1[0] - c2[0];
            return c1[1] - c2[1];
        });

        int[] prev = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        for(int[] c : list) {
            if(prev[1] >= c[0] && prev[1] <= c[1]) {
                isValid = false;
                break;
            }
            prev = c;
        }



        System.out.println(isValid ? "YES" : "NO");

    }
}