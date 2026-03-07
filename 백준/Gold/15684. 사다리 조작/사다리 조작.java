import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] board; // board[a][b]: a행 b~b+1 사이에 가로선 존재
    static int ans = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); M = sc.nextInt(); H = sc.nextInt();
        board = new boolean[H + 1][N + 1];
        
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            board[a][b] = true;
        }
        
        for (int add = 0; add <= 3; add++) {
            if (dfs(add, 1)) {
                ans = add;
                break;
            }
        }
        System.out.println(ans);
    }
    
    // cnt개의 가로선을 추가해서 identity 만들 수 있는지
    static boolean dfs(int cnt, int startRow) {
        if (cnt == 0) return check();
        
        for (int r = startRow; r <= H; r++) {
            for (int c = 1; c < N; c++) {
                // 이미 있거나, 인접 가로선 충돌이면 스킵
                if (board[r][c]) continue;
                if (c > 1 && board[r][c-1]) continue;
                if (c < N-1 && board[r][c+1]) continue;
                
                board[r][c] = true;
                if (dfs(cnt - 1, r)) return true;
                board[r][c] = false;
            }
        }
        return false;
    }
    
    static boolean check() {
        for (int start = 1; start <= N; start++) {
            int cur = start;
            for (int r = 1; r <= H; r++) {
                if (cur < N && board[r][cur]) cur++;
                else if (cur > 1 && board[r][cur-1]) cur--;
            }
            if (cur != start) return false;
        }
        return true;
    }
}