import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        int[][] board = new int[N][N];
        
        // 방향: 상(↑) → 우(→) → 하(↓) → 좌(←) 반시계!
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        int r = N / 2;
        int c = N / 2;
        int num = 1;
        board[r][c] = num++;
        
        int dir = 0;  // 상 방향부터 시작
        int step = 1;
        
        while (num <= N * N) {
            for (int repeat = 0; repeat < 2; repeat++) {
                for (int i = 0; i < step; i++) {
                    if (num > N * N) break;
                    
                    r += dr[dir];
                    c += dc[dir];
                    board[r][c] = num++;
                }
                
                dir = (dir + 1) % 4;
                if (num > N * N) break;
            }
            
            step++;
        }
        
        // 출력 + 좌표 찾기
        StringBuilder sb = new StringBuilder();
        int ansR = 0, ansC = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]).append(' ');
                
                if (board[i][j] == M) {
                    ansR = i + 1;
                    ansC = j + 1;
                }
            }
            sb.append('\n');
        }
        
        sb.append(ansR).append(' ').append(ansC);
        System.out.print(sb);
    }
}