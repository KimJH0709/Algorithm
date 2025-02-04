import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int tc = sc.nextInt();


        for (int i = 0; i < tc; i++) {
            long n = sc.nextLong();

            if (n <= 2) {
                sb.append(2).append("\n");
                continue;
            }

            while (true) {
                boolean flag = true;

                for (int j = 2; j < Math.sqrt(n) + 1; j++) {
                    if (n % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    sb.append(n).append("\n");
                    break;
                }
                n++;
            }

        }
        System.out.println(sb.toString());
    }
}