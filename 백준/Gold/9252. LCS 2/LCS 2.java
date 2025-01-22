//package BOJ.Section06.P9252;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    static int[][] dp;  // 최장 공통 부분 수열의 길이를 저장
    static char[] str1;
    static char[] str2;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
    //    System.setIn(new FileInputStream("src/BOJ/Section06/P9252/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        dp = new int[str1.length + 1][str2.length + 1];

        System.out.println(lcs(str1.length, str2.length));

        sb = new StringBuilder();
        findLCS(str1.length, str2.length);
        System.out.println(sb);
    }

    public static int lcs(int a, int b) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a][b];
    }

    static void findLCS(int r, int c) {
        while (r > 0 && c > 0) {
            if (str1[r - 1] == str2[c - 1]) {
                sb.append(str1[r - 1]);
                r--;
                c--;
            } else if (dp[r - 1][c] >= dp[r][c - 1]) {
                r--;
            } else {
                c--;
            }
        }
        sb.reverse();  // LCS는 역순으로 추가되므로 뒤집어야 함
    }
}