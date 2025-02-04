import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();

        int[] num = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            if (max <= num[i]) {
                max = num[i];
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= max; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (num[j] % i == 0) {
                    count++;
                }
            }

            if (count == n) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());

    }
}