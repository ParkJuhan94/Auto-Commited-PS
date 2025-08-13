import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        int sx = -1, sy = -1; // 시작(I)
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'I') { sx = i; sy = j; }
            }
        }

        int friends = bfs(sx, sy);
        if (friends == 0) System.out.println("TT");
        else System.out.println(friends);
    }

    static int bfs(int sx, int sy) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'X') continue; // 벽

                visited[nx][ny] = true;
                if (map[nx][ny] == 'P') cnt++;
                q.offer(new int[]{nx, ny});
            }
        }
        return cnt;
    }
}
