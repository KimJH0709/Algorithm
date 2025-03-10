import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PriorityQueue<Meeting> pq = new PriorityQueue<>((a, b) -> {
            return a.start - b.start;
        });
        PriorityQueue<Meeting> pq2 = new PriorityQueue<>((a, b) -> {
            return a.end - b.end;
        });

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            pq.add(new Meeting(start, end));
        }

        pq2.add(pq.poll());
        while(!pq.isEmpty()) {
            Meeting meeting = pq.poll();
            if (meeting.start < pq2.peek().end) {
                pq2.add(meeting);
            } else {
                pq2.poll();
                pq2.add(meeting);
            }
        }

        System.out.println(pq2.size());
    }
}
class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}