//package BOJ.Section11.P10844;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section11/P10844/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[][] dp = new long[101][10];    // 길이가 i인 계단 수 중 마지막 자리가 j인 경우의 수

        dp[1][0] = 0;
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // 길이가 i인 계단 수를 만들기 위해서는, i-1 자리 수의 마지막 자리가 j-1 또는 j+1이어야 함.
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1];
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8];
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long ans = 0;
        for(int j = 0; j <= 9; j++) {
            ans += dp[N][j];
        }

        System.out.println(ans % 1000000000);
    }

}
