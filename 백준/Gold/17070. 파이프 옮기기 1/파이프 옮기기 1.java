import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[N][N][3];
        dp[0][1][0] = 1;  // 시작 위치

        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (A[i][j] == 1) continue;
                // 가로(0)
                if (j - 1 >= 0 && A[i][j-1] == 0) {
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                }
                // 세로(1)
                if (i - 1 >= 0 && A[i-1][j] == 0) {
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                }
                // 대각선(2)
                if (i - 1 >= 0 && j - 1 >= 0
                    && A[i-1][j] == 0 && A[i][j-1] == 0 && A[i-1][j-1] == 0) {
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }

        long ans = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        System.out.println(ans);
    }
}
