import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] L = new int[N];
        int[] J = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[100];
        
        for (int i = 0; i < N; i++) {
            for (int hp = 99; hp >= L[i]; hp--) {
                dp[hp] = Math.max(dp[hp], dp[hp - L[i]] + J[i]);
            }
        }
        
        System.out.println(dp[99]);
    }
}