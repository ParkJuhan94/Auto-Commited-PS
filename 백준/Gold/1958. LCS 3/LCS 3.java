//package BOJ.Section11.P1958;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp;  // 최장 공통 부분 수열의 길이를 저장
    static char[] str1;
    static char[] str2;
    static char[] str3;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section11/P1958/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        str3 = br.readLine().toCharArray();
        dp = new int[str1.length + 1][str2.length + 1][str3.length + 1];

        System.out.println(lcs(str1.length, str2.length, str3.length));
    }

    public static int lcs(int a, int b, int c) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    if (str1[i - 1] == str2[j - 1] && str2[j - 1] == str3[k - 1]) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]);
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k - 1]);
                    }
                }
            }
        }

        return dp[a][b][c];
    }
}
