import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str1 = st.nextToken() + st.nextToken();
        String str2 = st.nextToken() + st.nextToken();

        System.out.println(Long.parseLong(str1) + Long.parseLong(str2));
    }
}
