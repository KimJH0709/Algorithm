import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n + 1][5]; // 0, 5는 padding
        int[][] dmx = new int[n + 1][5];
        int[][] dmn = new int[n + 1][5];

        final int MAX_VALUE = 1000000;

        for (int i = 1; i <= n; i++) {
            dmx[i][0] = 0;
            dmn[i][0] = MAX_VALUE;
            dmx[i][4] = 0;
            dmn[i][4] = MAX_VALUE;
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = sc.nextInt();
                dmx[i][j] = arr[i][j] + Math.max(dmx[i - 1][j - 1], Math.max(dmx[i - 1][j], dmx[i - 1][j + 1]));
                dmn[i][j] = arr[i][j] + Math.min(dmn[i - 1][j - 1], Math.min(dmn[i - 1][j], dmn[i - 1][j + 1]));
            }
        }

        int max = Math.max(dmx[n][1], Math.max(dmx[n][2], dmx[n][3]));
        int min = Math.min(dmn[n][1], Math.min(dmn[n][2], dmn[n][3]));

        System.out.println(max + " " + min);
    }
}