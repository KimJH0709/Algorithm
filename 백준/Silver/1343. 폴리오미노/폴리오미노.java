import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        int count = 0;
        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == '.') {
                if (count % 2 != 0) {
                    System.out.println(-1);
                    return;
                }
                int AAAA = count / 4;
                int BB = (count % 4) / 2;

                for (int j = 0; j < AAAA; j++) {
                    sb.append("AAAA");
                }
                for (int j = 0; j < BB; j++) {
                    sb.append("BB");
                }

                if (i < input.length()) {
                    sb.append(".");
                }
                count = 0;
            }
            else {
                count++;
            }

        }

        System.out.println(sb.toString());
    }
}