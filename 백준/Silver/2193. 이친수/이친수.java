//package BOJ.Section11.P2193;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section11/P2193/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // dp[i][j] 는 i 자릿수에서 j를 마지막 숫자로 가지는 이친수의 개수
        long[][] dp = new long[91][2];
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + dp[i - 1][1];
                } else {
                    dp[i][j] = dp[i - 1][0];
                }
            }
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }

}
