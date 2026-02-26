import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int firstLen = first.length();
        int secondLen = second.length();

        int min = firstLen + secondLen;

        int pad = secondLen;

        first = "0".repeat(pad) + first + "0".repeat(pad);

        int firstStart = pad;
        int firstEnd = pad + firstLen;

        for (int i = 0; i <= first.length() - secondLen; i++) {
            boolean possible = true;

            for (int j = 0; j < secondLen; j++) {
                if (first.charAt(i + j) == '2' && second.charAt(j) == '2') {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                int secondStart = i;
                int secondEnd = i + secondLen;

                int start = Math.min(firstStart, secondStart);
                int end = Math.max(firstEnd, secondEnd);

                int totalLength = end - start;

                min = Math.min(min, totalLength);
            }
        }

        System.out.println(min);
    }
}