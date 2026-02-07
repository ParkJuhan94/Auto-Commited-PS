import java.util.*;
import java.io.*;

public class Main {
    static int[][] grid;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(solve(0, 0, N));
    }
    
    static int solve(int r, int c, int size) {
        // Base case: 1x1 구역
        if (size == 1) {
            return grid[r][c];
        }
        
        // 4개 구역으로 나누기
        int half = size / 2;
        int[] results = new int[4];
        
        results[0] = solve(r, c, half);              // 왼쪽 위
        results[1] = solve(r, c + half, half);       // 오른쪽 위
        results[2] = solve(r + half, c, half);       // 왼쪽 아래
        results[3] = solve(r + half, c + half, half); // 오른쪽 아래
        
        // 정렬 후 2번째 값 반환
        Arrays.sort(results);
        return results[1];
    }
}