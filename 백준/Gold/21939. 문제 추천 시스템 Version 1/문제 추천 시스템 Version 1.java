import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, TreeSet<Integer>> problems = new TreeMap<>();
        Map<Integer, Integer> diff = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            problems.putIfAbsent(L, new TreeSet<>());
            problems.get(L).add(P);
            diff.put(P, L);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                problems.putIfAbsent(L, new TreeSet<>());
                problems.get(L).add(P);
                diff.put(P, L);
            } else if (cmd.equals("recommend")) {
                int cond = Integer.parseInt(st.nextToken());
                if (cond == 1) {
                    int hardestLevel = problems.lastKey();
                    sb.append(problems.get(hardestLevel).last()).append("\n");
                } else if (cond == -1) {
                    int easiestLevel = problems.firstKey();
                    sb.append(problems.get(easiestLevel).first()).append("\n");                }
            } else if (cmd.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());

                int L = diff.get(P);
                problems.get(L).remove(P);

                if (problems.get(L).isEmpty()) {
                    problems.remove(L);
                }

                diff.remove(P);
            }
        }
        System.out.println(sb.toString());
    }
}

/**
 * recommend x
 * x == 1  가장 어려운 문제 출력
 * x == -1 가장 쉬운 문제 출력
 *
 * add P L
 * 난이도가 L인 문제 번호 P를 추가
 *
 * solved P
 * 추천 문제 리스트에서 문제 번호 P를 제거
 */