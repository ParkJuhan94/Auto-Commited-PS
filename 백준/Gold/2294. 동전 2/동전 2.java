import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        // dp[i]: i원을 만드는 최소 동전 개수
        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 초기값: 불가능 표시
        dp[0] = 0; // 0원은 동전 0개
        
        // 각 금액에 대해 모든 동전으로 갱신
        for (int i = 1; i <= k; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}