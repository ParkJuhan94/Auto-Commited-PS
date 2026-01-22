import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int whiteCnt = 0;
    static int blueCnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        divide(0, 0, N);
        
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }
    
    static void divide(int r, int c, int size) {
        // 현재 영역이 모두 같은 색인지 체크
        if (isSameColor(r, c, size)) {
            if (paper[r][c] == 0) {
                whiteCnt++;
            } else {
                blueCnt++;
            }
            return;
        }
        
        // 다른 색이 섞여있으면 4등분
        int half = size / 2;
        
        divide(r, c, half);                    // 좌상단 (I)
        divide(r, c + half, half);             // 우상단 (II)
        divide(r + half, c, half);             // 좌하단 (III)
        divide(r + half, c + half, half);      // 우하단 (IV)
    }
    
    static boolean isSameColor(int r, int c, int size) {
        int color = paper[r][c];
        
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        
        return true;
    }
}