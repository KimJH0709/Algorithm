import java.util.Scanner;

class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        //시작 -> 2, 3, 5, 7
        //끝 -> 1, 3, 5, 7, 9
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

    }

    private static void dfs(int num, int digits) {
        if (digits == n) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }


            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i, digits + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}