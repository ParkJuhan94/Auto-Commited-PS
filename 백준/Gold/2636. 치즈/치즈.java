//package BOJ.Section12.P2636;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간 2. 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수 를 구하는 프로그램
 */
public class Main {

    static int N, M;
    static int[][] board;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answerDayCount = 0;
    static int beforeCheeseCount = 0;
    static int cheeseCount = 0;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section12/P2636/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int curCheeseCount = countCheese();     // 스냅샷: 녹이기 직전
            if (curCheeseCount == 0) break;         // 이미 다 녹았으면 종료
            meltOneHour();                          // 외부 공기와 맞닿은 치즈 녹이기
            answerDayCount++;
            beforeCheeseCount = curCheeseCount;     // “마지막 한 시간 전” 치즈 카운트 갱신
        }

        System.out.println(answerDayCount);
        System.out.println(beforeCheeseCount);
    }

    static void meltOneHour() {
        ArrayList<Point> edgePoints = edgeCheesePoints();

        for (Point p : edgePoints) {
            board[p.r][p.c] = 0;
        }
    }

    static ArrayList<Point> edgeCheesePoints() {
        ArrayList<Point> res = new ArrayList<>();
        boolean[][] visited = new boolean[N][M];
        Queue<Point> q = new ArrayDeque<>();

        q.add(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && board[nr][nc] == 0) {
                    q.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }

                if (0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && board[nr][nc] == 1) {
                    res.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }

        return res;
    }

    static int countCheese() {
        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}

class Point {

    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}