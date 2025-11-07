import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] ingredients; // [i][0]=신맛, [i][1]=쓴맛
    static int minDiff = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ingredients = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }
        
        // 백트래킹: (현재 인덱스, 신맛 곱, 쓴맛 합, 선택 개수)
        backtrack(0, 1, 0, 0);
        
        System.out.println(minDiff);
    }
    
    static void backtrack(int idx, int sour, int bitter, int count) {
        // 종료 조건: 모든 재료 검토 완료
        if (idx == N) {
            // 최소 1개 이상 선택했을 때만 계산
            if (count > 0) {
                int diff = Math.abs(sour - bitter);
                minDiff = Math.min(minDiff, diff);
            }
            return;
        }
        
        // 1. 현재 재료 선택 O
        backtrack(idx + 1, 
                  sour * ingredients[idx][0],
                  bitter + ingredients[idx][1],
                  count + 1);
        
        // 2. 현재 재료 선택 X
        backtrack(idx + 1, sour, bitter, count);
    }
}