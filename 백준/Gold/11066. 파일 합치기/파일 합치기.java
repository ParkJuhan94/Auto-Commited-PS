import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] files = new long[K];
            for (int i = 0; i < K; i++) {
                files[i] = Long.parseLong(st.nextToken());
            }
            
            // 누적합(prefix sum) 배열: prefix[i]는 파일 0부터 i-1까지의 합.
            long[] prefix = new long[K + 1];
            for (int i = 0; i < K; i++) {
                prefix[i + 1] = prefix[i] + files[i];
            }
            
            // dp[i][j]: i번째부터 j번째 파일까지 합치는 최소 비용
            long[][] dp = new long[K][K];
            // opt[i][j]: dp[i][j]의 최적 분할 위치 (Knuth 최적화를 위한 배열)
            int[][] opt = new int[K][K];
            
            // 한 파일만 있는 경우 비용은 0
            for (int i = 0; i < K; i++) {
                dp[i][i] = 0;
                opt[i][i] = i;
            }
            
            // 구간 길이 l = 2부터 K까지
            for (int l = 2; l <= K; l++) {
                for (int i = 0; i <= K - l; i++) {
                    int j = i + l - 1;
                    dp[i][j] = Long.MAX_VALUE;
                    // Knuth 최적화: 최적 분할 위치의 후보 범위는 opt[i][j-1]부터 opt[i+1][j]까지입니다.
                    int start = opt[i][j - 1];
                    int end = opt[i + 1][j];
                    for (int k = start; k <= end; k++) {
                        if (k < j) {
                            long cost = dp[i][k] + dp[k + 1][j] + (prefix[j + 1] - prefix[i]);
                            if (dp[i][j] > cost) {
                                dp[i][j] = cost;
                                opt[i][j] = k;
                            }
                        }
                    }
                }
            }
            sb.append(dp[0][K - 1]).append("\n");
        }
        System.out.print(sb.toString());
    }
}
