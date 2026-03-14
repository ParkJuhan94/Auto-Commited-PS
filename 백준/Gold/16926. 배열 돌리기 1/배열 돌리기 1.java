import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        int rings = Math.min(N, M) / 2;
        
        for (int k = 0; k < rings; k++) {
            // 링 추출 (시계방향)
            List<Integer> ring = new ArrayList<>();
            
            // 상단 (left → right)
            for (int c = k; c < M - k; c++)       ring.add(arr[k][c]);
            // 우측 (top+1 → bottom)
            for (int r = k + 1; r < N - k; r++)   ring.add(arr[r][M-1-k]);
            // 하단 (right-1 → left)
            for (int c = M - 2 - k; c >= k; c--)  ring.add(arr[N-1-k][c]);
            // 좌측 (bottom-1 → top+1)
            for (int r = N - 2 - k; r >= k + 1; r--) ring.add(arr[r][k]);
            
            // 반시계 R회전 = 왼쪽 시프트 R%len
            int len = ring.size();
            int shift = R % len;
            
            // 시프트된 링 다시 배치
            int idx = 0;
            for (int c = k; c < M - k; c++)           arr[k][c]       = ring.get((idx++ + shift) % len);
            for (int r = k + 1; r < N - k; r++)       arr[r][M-1-k]   = ring.get((idx++ + shift) % len);
            for (int c = M - 2 - k; c >= k; c--)      arr[N-1-k][c]   = ring.get((idx++ + shift) % len);
            for (int r = N - 2 - k; r >= k + 1; r--)  arr[r][k]       = ring.get((idx++ + shift) % len);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0) sb.append(' ');
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}