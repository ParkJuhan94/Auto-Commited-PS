import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 예외
        if(D == 3) {
            int a = K/2;
            int b = K - a;
                    
            System.out.println(a);
            System.out.println(b);
            return;
        }
        
        int[] dp = new int[D + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= D; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }        
        
        // a, b 찾기
        for(int i = 1; i <= K/2; i++) {
            int diff = K - i * dp[D - 3];
            int remainder = diff % dp[D - 2];
            if(remainder == 0 && diff/dp[D - 2] >= i) {
                System.out.println(i);
                System.out.println(diff/dp[D - 2]);
                return;
            }
        }
    }
}