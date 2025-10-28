import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[][] land = new int[N][M];
        int minHeight = 256, maxHeight = 0;
        
        // 입력 + 최소/최대 높이 파악
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, land[i][j]);
                maxHeight = Math.max(maxHeight, land[i][j]);
            }
        }
        
        int minTime = Integer.MAX_VALUE;
        int resultHeight = 0;
        
        // 높이를 높은 것부터 시도 (같은 시간이면 높은 높이 선택하기 위해)
        for (int targetHeight = maxHeight; targetHeight >= minHeight; targetHeight--) {
            int time = 0;
            int inventory = B;
            
            // 모든 블록 순회
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = land[i][j] - targetHeight;
                    
                    if (diff > 0) {
                        // 제거: 2초씩, 인벤토리에 추가
                        time += diff * 2;
                        inventory += diff;
                    } else if (diff < 0) {
                        // 추가: 1초씩, 인벤토리에서 제거
                        time += -diff;
                        inventory += diff; // diff가 음수라 빼짐
                    }
                }
            }
            
            // 인벤토리가 음수면 불가능
            if (inventory >= 0) {
                if (time < minTime) {
                    minTime = time;
                    resultHeight = targetHeight;
                }
            }
        }
        
        System.out.println(minTime + " " + resultHeight);
    }
}