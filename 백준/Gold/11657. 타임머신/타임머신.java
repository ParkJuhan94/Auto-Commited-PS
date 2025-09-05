import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int u, v; int w;
        Edge(int u, int v, int w) { this.u=u; this.v=v; this.w=w; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, C));
        }

        final long INF = 9_000_000_000_000_000L;
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // N-1번 이완
        for (int i = 1; i <= N - 1; i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.u] == INF) continue; // 1에서 도달 불가면 스킵
                long nd = dist[e.u] + e.w;
                if (nd < dist[e.v]) {
                    dist[e.v] = nd;
                    updated = true;
                }
            }
            if (!updated) break; // 조기 종료
        }

        // 도달 가능한 음수 사이클 체크
        for (Edge e : edges) {
            if (dist[e.u] == INF) continue;
            if (dist[e.u] + e.w < dist[e.v]) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int v = 2; v <= N; v++) {
            sb.append(dist[v] == INF ? -1 : dist[v]).append('\n');
        }
        System.out.print(sb);
    }
}
