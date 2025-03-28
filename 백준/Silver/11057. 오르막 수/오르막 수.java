//package BOJ.Section11.P11057;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section11/P11057/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] dp = new int[10][N + 1];
        for(int i = 0; i < 10; i++) {
            dp[i][1] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k <= j; k++) {
                    dp[j][i] += dp[k][i - 1];
                }
                dp[j][i] %= 10007;
            }
        }

        int answer = 0;
        for(int i = 0; i < 10; i++) {
            answer += dp[i][N];
        }

        System.out.println(answer % 10007);
    }

}
