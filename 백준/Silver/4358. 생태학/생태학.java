import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<String, Integer>();
        String input;
        int total = 0;

        while ((input = br.readLine()) != null) {
            if (!map.containsKey(input)) {
                map.put(input, 1);
            } else {
                map.put(input, map.get(input) + 1);
            }
            total ++;
        }

        StringBuilder sb = new StringBuilder();
//        for (Map.Entry<String, Integer> m : map.entrySet()) {
//            String name = m.getKey();
//            int count = m.getValue();
//
//            double percent = (double) count / total;
//
//            sb.append(name).append(String.format(" %.4f", percent * 100)).append("\n");
//        }

//        Map.Entry<>를 이용하면 Map에 저장된 모든 key-value 쌍을 각각의 key-value를 갖고 있는 하나의 객체로 얻을 수 있다.

        for (String key : map.keySet()) {
            String name = key;
            int count = map.get(key);

            double percent = (double) count / total;
            sb.append(name).append(String.format(" %.4f", percent * 100)).append("\n");
        }

        System.out.println(sb.toString());
    }
}