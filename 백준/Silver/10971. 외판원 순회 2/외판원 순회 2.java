import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] W;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[N];
        visited[0] = true;
        
        dfs(0, 0, 1, 0);
        
        System.out.println(minCost);
    }
    
    static void dfs(int start, int current, int count, int cost) {
        // 모든 도시 방문 완료
        if (count == N) {
            // 시작점으로 돌아갈 수 있으면
            if (W[current][start] != 0) {
                minCost = Math.min(minCost, cost + W[current][start]);
            }
            return;
        }
        
        // 가지치기: 현재 비용이 이미 최솟값보다 크면
        if (cost >= minCost) return;
        
        // 다음 도시 탐색
        for (int next = 0; next < N; next++) {
            if (!visited[next] && W[current][next] != 0) {
                visited[next] = true;
                dfs(start, next, count + 1, cost + W[current][next]);
                visited[next] = false;
            }
        }
    }
}