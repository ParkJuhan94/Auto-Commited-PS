import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;

        int MAX = 1_000_000;
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        Deque<Integer> q = new ArrayDeque<>();
        q.add(x);
        dist[x] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 세 후보를 개별 체크
            int[] nexts = {cur + n, cur * 2, cur * 3};
            for (int nxt : nexts) {
                if (nxt > MAX) continue;       // 경계
                if (dist[nxt] != -1) continue; // 방문
                dist[nxt] = dist[cur] + 1;
                if (nxt == y) return dist[nxt];
                if (nxt <= y) q.add(nxt);      // y보다 큰 값은 굳이 확장 안 해도 됨
            }
        }
        return -1;
    }
}
