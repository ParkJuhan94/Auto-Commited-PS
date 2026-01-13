import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // N=1 예외 처리
        if(N == 1) {
            System.out.println(1);
            return;
        }
        
        // dp[i][0]: i까지 비내림차순 최대 길이
        // dp[i][1]: i까지 비오름차순 최대 길이
        int[][] dp = new int[N][2];        
        dp[0][0] = 1;
        dp[0][1] = 1;
        
        int maxLen = 1;
        
        for(int i = 1; i < N; i++) {
            // 비내림차순 (같거나 커지는)
            if(arr[i] >= arr[i - 1]) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 1;  // 새로운 구간 시작
            }
            
            // 비오름차순 (같거나 작아지는)
            if(arr[i] <= arr[i - 1]) {
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][1] = 1;  // 새로운 구간 시작
            }
            
            // 최댓값 갱신
            maxLen = Math.max(maxLen, Math.max(dp[i][0], dp[i][1]));
        }
        
        System.out.println(maxLen);
    }
}