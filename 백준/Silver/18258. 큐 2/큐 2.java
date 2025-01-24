import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue queue = new Queue();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            StringTokenizer st = new StringTokenizer(cmd);
            String command = st.nextToken();
            if (command.equals("push")) {
                queue.push(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                sb.append(queue.pop()).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(queue.empty()).append("\n");
            } else if (command.equals("front")) {
                sb.append(queue.front()).append("\n");
            } else if (command.equals("back")) {
                sb.append(queue.back()).append("\n");
            }
        }

        System.out.println(sb.toString());

        br.close();
    }

    static class Queue {
       int front;
       int rear;
       int[] arr;

        Queue() {
            rear = 0;
            front = 0;
            arr = new int[2000001];
        }

        void push(int x) {
            arr[rear++] = x;
        }

        int pop() {
            if (size() == 0) {
                return -1;
            }
            int result = arr[front++];
            return result;
        }

        int size() {
            return rear - front;
        }

        int empty() {
            return size() == 0 ? 1 : 0;
        }

        int front() {
            return size() == 0 ? -1 : arr[front];
        }

        int back() {
            return size() == 0 ? -1 : arr[rear - 1];
        }
    }
}
