import java.io.*;
import java.util.*;

public class Main {
    static int N;
 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[50001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for(int i = 4; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);                                
            }
            dp[i] = min + 1;
        }
        
        System.out.print(dp[N]);
    }
    
}