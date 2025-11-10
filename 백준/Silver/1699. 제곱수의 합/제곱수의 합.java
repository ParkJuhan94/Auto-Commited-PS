import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        // n을 만드는 최소 개수
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= N; i++) {
            for(int j = 1; j * j <= i; j++) {
                if(dp[i - j * j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);                    
                }
            }
        }
        
        System.out.println(dp[N]);
    }
}