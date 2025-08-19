import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 무향 그래프, 중복 간선 허용되어도 로직엔 영향 없음
            g[a].add(b);
            g[b].add(a);
        }

        int answer = 1;
        int bestSum = Integer.MAX_VALUE;

        // 각 사람을 시작점으로 BFS
        for (int s = 1; s <= N; s++) {
            int sum = bfsSum(g, N, s);
            if (sum < bestSum) {
                bestSum = sum;
                answer = s;
            }
        }
        System.out.println(answer);
    }

    private static int bfsSum(List<Integer>[] g, int N, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.add(start);

        int sum = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : g[cur]) {
                if (dist[nxt] != -1) continue;
                dist[nxt] = dist[cur] + 1;
                sum += dist[nxt]; // 방문하면서 바로 누적
                q.add(nxt);
            }
        }
        return sum;
    }
}
