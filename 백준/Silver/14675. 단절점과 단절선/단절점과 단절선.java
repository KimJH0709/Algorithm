import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (t == 1) {
                //t가 1일때는 k번 정점이 단절점인지에 대한 질의
                //리프노드는 단절점이 불가능
                //루트 노드는 자식이 2개 이상일 때만 단절점 가능
                if (k == 1) {
                    if (graph[k].size() >= 2) {
                        sb.append("yes").append('\n');
                    } else {
                        sb.append("no").append('\n');
                    }
                } else {
                    if (graph[k].size() <= 1) {
                        sb.append("no").append('\n');
                    } else {
                        sb.append("yes").append('\n');
                    }
                }

            } else if (t == 2) {
                //t가 2일때는 k번 간선이 단절선인지에 대한 질의
                //트리에서 모든 간선은 단절선
                sb.append("yes").append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}