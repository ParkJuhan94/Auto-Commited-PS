import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[19][19];
    // 방향: 우, 하, 우하, 우상
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 모든 위치에서 탐색 (왼쪽→오른쪽, 위→아래 순서)
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 0) continue;
                
                int color = board[i][j];
                
                // 4방향 체크
                for (int dir = 0; dir < 4; dir++) {
                    if (check(i, j, color, dir)) {
                        System.out.println(color);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }
        
        System.out.println(0);
    }
    
    static boolean check(int x, int y, int color, int dir) {
        // 역방향에 같은 색이 있으면 시작점이 아님 (중복 방지)
        int px = x - dx[dir];
        int py = y - dy[dir];
        if (isValid(px, py) && board[px][py] == color) {
            return false;
        }
        
        // 5개 연속 확인
        int count = 0;
        for (int i = 0; i < 6; i++) {
            int nx = x + dx[dir] * i;
            int ny = y + dy[dir] * i;
            
            if (!isValid(nx, ny) || board[nx][ny] != color) {
                break;
            }
            count++;
        }
        
        // 정확히 5개인지 확인 (6개 이상이면 false)
        return count == 5;
    }
    
    static boolean isValid(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}