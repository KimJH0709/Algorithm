import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String str = br.readLine();


        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (i == 0) {
                sb.append(Integer.toBinaryString(num));
            } else {
                sb.append(arr[num]);
            }
        }
        
        System.out.println(sb.toString());
    }
}
