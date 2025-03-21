//package BOJ.Section04.P1010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R, ans;
    private static final int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section04/P1010/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            System.out.println(combination(N, R));
        }
    }

    private static int combination(int n, int r)
    {
        if(r == 0 || n == r) {
            return 1;
        }
        
        if(dp[n][r] != 0) {
            return dp[n][r];
        }
        
        return dp[n][r] = (combination(n - 1, r) + combination(n - 1, r - 1));
    }

}