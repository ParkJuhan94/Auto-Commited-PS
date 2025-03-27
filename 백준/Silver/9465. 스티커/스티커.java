//package BOJ.Section11.P9465;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section11/P9465/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][N];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            /*
            각 열마다 세 가지 선택지
            [0] : 위쪽 스티커를 떼는 경우
            [1] : 아래쪽 스티커를 떼는 경우
            [2] : 아무 스티커도 떼지 않는 경우
             */
            int[][] dp = new int[3][N];

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[2][0] = 0;

            for (int i = 1; i < N; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[2][i - 1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[2][i - 1]) + arr[1][i];
                dp[2][i] = Math.max(dp[0][i - 1], Math.max(dp[1][i - 1], dp[2][i - 1]));
            }

            System.out.println(Math.max(dp[0][N - 1], Math.max(dp[1][N - 1], dp[2][N - 1])));
        }
    }

}
