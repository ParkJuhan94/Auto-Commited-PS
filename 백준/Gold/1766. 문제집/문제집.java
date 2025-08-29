import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> g = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) g.add(new ArrayList<>());
        int[] indeg = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            g.get(A).add(B);
            indeg[B]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 가장 쉬운 문제(번호 작은 것) 우선
        for (int i = 1; i <= N; i++) if (indeg[i] == 0) pq.offer(i);

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(' ');
            for (int nxt : g.get(cur)) {
                if (--indeg[nxt] == 0) pq.offer(nxt);
            }
        }

        System.out.println(sb.toString().trim());
    }
}
