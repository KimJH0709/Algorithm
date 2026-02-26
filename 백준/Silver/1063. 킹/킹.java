import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        // 알파벳 : 열(A~H)  |  숫자 : 행(1~8)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        String king = st.nextToken();
        String stone = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        Point pKing = new Point(king.charAt(0) - 'A', king.charAt(1) - '1');
        Point pStone = new Point(stone.charAt(0) - 'A', stone.charAt(1) - '1');

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();

            int dr = 0;
            int dc = 0;

            if (cmd.equals("R")) {
                dr = 1;
            } else if (cmd.equals("L")) {
                dr = -1;
            } else if (cmd.equals("B")) {
                dc = -1;
            } else if (cmd.equals("T")) {
                dc = 1;
            } else if (cmd.equals("RT")) {
                dr = 1; dc = 1;
            } else if (cmd.equals("LT")) {
                dr = -1; dc = 1;
            } else if (cmd.equals("RB")) {
                dr = 1; dc = -1;
            } else if (cmd.equals("LB")) {
                dr = -1; dc = -1;
            }

            int nextKingR = pKing.r + dr;
            int nextKingC = pKing.c + dc;

            if (nextKingR < 0 || nextKingR >= 8 || nextKingC < 0 || nextKingC >= 8) {
                continue;
            }

            if (nextKingR == pStone.r && nextKingC == pStone.c) {
                int nextStoneR = pStone.r + dr;
                int nextStoneC = pStone.c + dc;

                if (nextStoneR < 0 || nextStoneR >= 8 || nextStoneC < 0 || nextStoneC >= 8) {
                    continue;
                }

                pStone.r = nextStoneR;
                pStone.c = nextStoneC;
            }
            
            pKing.r = nextKingR;
            pKing.c = nextKingC;
        }
        System.out.println((char)(pKing.r + 'A') + "" + (char)(pKing.c + '1'));
        System.out.println((char)(pStone.r + 'A') + "" + (char)(pStone.c + '1'));

    }
}

class Point {
    int r, c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}