import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][][] visited = new boolean[n][n][2]; 
        // 0 이면 가로 1이면 세로
        Queue<Robot> queue = new LinkedList<>();
        
        queue.add(new Robot(0, 0, 0, 0));
        visited[0][0][0] = true;
        
        while(!queue.isEmpty()) {
            Robot cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int count = cur.count;
            
            // End Case
            if ((x == n - 1 && y == n - 2 && dir == 0) || (x == n - 2 && y == n - 1 && dir == 1)) {
                return count;
            }
            
            // 상하좌우
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (canMove(nx, ny, dir, board)) {
                    if (!visited[nx][ny][dir]) {
                        visited[nx][ny][dir] = true;
                        queue.add(new Robot(nx, ny, dir, count + 1));
                    }
                }
            }
            
            // 회전
            for (Robot rotated : getRotations(x, y, dir, board)) {
                if (!visited[rotated.x][rotated.y][rotated.dir]) {
                    visited[rotated.x][rotated.y][rotated.dir] = true;
                    queue.add(new Robot(rotated.x, rotated.y, rotated.dir, count + 1));
                }
            }
        }
        return -1;
    }
    
    static boolean canMove(int x, int y, int dir, int[][] board) {
        int n = board.length;
        if (x < 0 || x >= n || y < 0 || y >= n || board[x][y] == 1) return false;
        if (dir == 0) {
            return y + 1 < n && board[x][y + 1] == 0;
        } else {
            return x + 1 < n && board[x + 1][y] == 0;
        }
    }
    
    static List<Robot> getRotations(int x, int y, int dir, int[][] board) {
        List<Robot> rotations = new ArrayList<>();
        int n = board.length;

        if (dir == 0) {
            if (x + 1 < n && board[x + 1][y] == 0 && board[x + 1][y + 1] == 0) {
                rotations.add(new Robot(x, y, 1, 0));
                rotations.add(new Robot(x, y + 1, 1, 0));
            }
            if (x - 1 >= 0 && board[x - 1][y] == 0 && board[x - 1][y + 1] == 0) {
                rotations.add(new Robot(x - 1, y, 1, 0));
                rotations.add(new Robot(x - 1, y + 1, 1, 0));
            }
        } else { // 세로 → 가로 회전
            if (y + 1 < n && board[x][y + 1] == 0 && board[x + 1][y + 1] == 0) {
                rotations.add(new Robot(x, y, 0, 0));
                rotations.add(new Robot(x + 1, y, 0, 0));
            }
            if (y - 1 >= 0 && board[x][y - 1] == 0 && board[x + 1][y - 1] == 0) {
                rotations.add(new Robot(x, y - 1, 0, 0));
                rotations.add(new Robot(x + 1, y - 1, 0, 0));
            }
        }

        return rotations;
    }
}

class Robot {
    int x, y, dir, count;
    Robot (int x, int y, int dir, int count) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.count = count;
    }
}