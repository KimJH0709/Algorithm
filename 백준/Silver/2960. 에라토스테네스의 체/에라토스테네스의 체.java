import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean[] arr = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            arr[i] = true;
        }

        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (arr[i]) {
                for (int j = i; j <= N; j += i) {
                    if (arr[j]) {
                        arr[j] = false;
                        count++;

                        if (count == K) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }

    }
}