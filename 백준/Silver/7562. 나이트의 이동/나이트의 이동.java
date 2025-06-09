//package BOJ.Section11.P7562;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
 //       System.setIn(new FileInputStream("src/BOJ/Section11/P7562/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int curR = Integer.parseInt(st.nextToken());
            int curC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());

            // bfs
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(curR, curC, 0));
            visited[curR][curC] = true;

            while (!q.isEmpty()) {
                Point cur = q.poll();

                if (cur.r == endR && cur.c == endC) {
                    System.out.println(cur.dist);
                }

                for (int i = 0; i < 8; i++) {
                    int nextR = cur.r + dr[i];
                    int nextC = cur.c + dc[i];

                    if (0 <= nextR && nextR < N && 0 <= nextC && nextC < N && !visited[nextR][nextC]) {
                        q.add(new Point(nextR, nextC, cur.dist + 1));
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }
    }

}

class Point {

    int r;
    int c;
    int dist;

    public Point(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}
