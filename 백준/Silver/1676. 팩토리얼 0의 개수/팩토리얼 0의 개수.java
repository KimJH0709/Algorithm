import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count2 = 0;
        int count5 = 0;
        for (int i = 2; i <= n; i++) {
            int temp = i;
            while (temp % 2 == 0) {
                count2++;
                temp /= 2;
            }

            while (temp % 5 == 0) {
                count5++;
                temp /= 5;
            }
        }

        System.out.println(Math.min(count2, count5));
    }
}