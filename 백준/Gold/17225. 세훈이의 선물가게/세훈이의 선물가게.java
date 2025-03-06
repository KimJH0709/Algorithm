import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bTime = sc.nextInt(); // 상민이가 포장하는 데 걸리는 시간
        int rTime = sc.nextInt(); // 지수가 포장하는 데 걸리는 시간
        int n = sc.nextInt(); // 가게 손님 수

        Deque<Integer> blueQueue = new LinkedList<>();
        Deque<Integer> redQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            char color = sc.next().charAt(0);
            int cnt = sc.nextInt();
            switch (color) {
                case 'B':
                    if (!blueQueue.isEmpty() && blueQueue.getLast() + bTime > time) {
                        time = blueQueue.getLast() + bTime;
                    }
                    for (int j = 0; j < cnt; j++) {
                        blueQueue.offer(time);
                        time += bTime;
                    }
                    break;
                case 'R':
                    if (!redQueue.isEmpty() && redQueue.getLast() + rTime > time) {
                        time = redQueue.getLast() + rTime;
                    }
                    for (int j = 0; j < cnt; j++) {
                        redQueue.offer(time);
                        time += rTime;
                    }
            }
        }

        List<Integer> blueOrder = new LinkedList<>();
        List<Integer> redOrder = new LinkedList<>();
        int orderNumber = 0;
        while(!blueQueue.isEmpty() && !redQueue.isEmpty()) {
            if (blueQueue.peek() <= redQueue.peek()) {
                blueOrder.add(++orderNumber);
                blueQueue.poll();
            } else {
                redOrder.add(++orderNumber);
                redQueue.poll();
            }
        }

        while(!blueQueue.isEmpty()) {
            blueOrder.add(++orderNumber);
            blueQueue.poll();
        }

        while(!redQueue.isEmpty()) {
            redOrder.add(++orderNumber);
            redQueue.poll();
        }

        System.out.println(blueOrder.size());
        for (int num : blueOrder) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(redOrder.size());
        for (int num : redOrder) {
            System.out.print(num + " ");
        }
    }
}