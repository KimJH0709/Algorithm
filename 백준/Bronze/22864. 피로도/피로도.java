import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();

        int fatigue = 0; // 피로도
        int work = 0; // 작업량

        for (int i = 0; i < 24; i++) {
            if (fatigue + A <= M) {
                fatigue += A;
                work += B;
            } else {
                fatigue -= C;
                if (fatigue < 0) fatigue = 0;
            }
        }

        System.out.println(work);



    }
}