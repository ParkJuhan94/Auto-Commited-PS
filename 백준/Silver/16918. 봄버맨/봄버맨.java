import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] grid;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        
        char[][] result;
        
        if (N == 1) {
            // 초기 상태
            result = grid;
        } else if (N % 2 == 0) {
            // 짝수: 전체 폭탄
            result = getFullBombs();
        } else if (N % 4 == 3) {
            // 3, 7, 11, ... → 첫 번째 폭발 (3초 상태)
            result = explode(grid);
        } else {
            // 5, 9, 13, ... → 두 번째 폭발 (5초 상태)
            // 5초 = 3초 상태를 한 번 더 폭발
            result = explode(explode(grid));
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.print(sb);
    }
    
    // 모든 칸에 폭탄 설치
    static char[][] getFullBombs() {
        char[][] full = new char[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(full[i], 'O');
        }
        return full;
    }
    
    // 현재 폭탄들을 폭발시킨 결과
    static char[][] explode(char[][] current) {
        // 먼저 모든 칸에 폭탄 설치
        char[][] next = getFullBombs();
        
        // 현재 폭탄이 있는 위치와 인접 칸 파괴
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (current[i][j] == 'O') {
                    next[i][j] = '.';  // 폭탄 위치 파괴
                    
                    // 상하좌우 파괴
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                            next[nr][nc] = '.';
                        }
                    }
                }
            }
        }
        
        return next;
    }
}