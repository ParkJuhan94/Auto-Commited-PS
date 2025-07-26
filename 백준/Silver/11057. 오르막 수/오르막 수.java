//package BOJ.Section11.P11057;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
   //     System.setIn(new FileInputStream("src/BOJ/Section11/P11057/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10]; // dp[i][j] = 길이가 i이고 마지막 숫자가 j인 오르막 수의 개수

        // 초기값: 길이가 1일 때는 각 숫자 하나씩
        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }

        // 길이 N이고 마지막 숫자가 0~9인 모든 경우 합
        int result = 0;
        for (int j = 0; j <= 9; j++) {
            result = (result + dp[N][j]) % MOD;
        }

        System.out.println(result);
    }
}