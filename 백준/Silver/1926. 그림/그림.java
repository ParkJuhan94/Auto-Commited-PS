//package BOJ.Section12.P1926;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int countGroup = 0;
    static int area;
    static int maxArea = 0;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
     //  System.setIn(new FileInputStream("src/BOJ/Section12/P1926/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    int area = dfs(i, j);
                    countGroup++;

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println(countGroup);
        System.out.println(maxArea);
    }

    static int dfs(int curR, int curC) {
        int size = 1;
        visited[curR][curC] = true;

        for (int i = 0; i < 4; i++) {
            int nr = curR + dr[i];
            int nc = curC + dc[i];

            if (0 <= nr && nr < N && 0 <= nc && nc < M
                && !visited[nr][nc] && board[nr][nc] == 1) {
                visited[nr][nc] = true;
                size += dfs(nr, nc);
            }
        }

        return size;
    }
}
