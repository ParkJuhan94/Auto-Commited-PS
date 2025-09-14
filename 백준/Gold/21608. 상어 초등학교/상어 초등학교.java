//package BOJ.Section12.P21608;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board;   // 0이면 빈 칸으로 생각
    static Student[] students;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
   //     System.setIn(new FileInputStream("src/BOJ/Section12/P21608/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        students = new Student[N * N + 1];
        for(int i = 0; i < N * N + 1; i++) {
            students[i] = new Student();
        }

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 4; j++) {
                int like = Integer.parseInt(st.nextToken());
                students[idx].addLikes(like);
            }

            solve(idx);
        }

        System.out.println(getSat());
    }

    // 학생 자리 지정하는 시뮬레이션 함수
    static void solve(int idx) {
        // 자리 후보
        ArrayList<Point> pointsA = new ArrayList<>();

        // 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
        int maxLike = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == 0) {
                    int countLike = 0;
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];

                        if (0 <= nr && nr < N && 0 <= nc && nc < N
                            && board[nr][nc] != 0
                            && students[idx].isLike(board[nr][nc])) {
                            countLike++;
                        }
                    }

                    if (countLike > maxLike) {
                        maxLike = countLike;
                        pointsA.clear();
                        pointsA.add(new Point(r, c));
                    } else if (countLike == maxLike) {
                        pointsA.add(new Point(r, c));
                    }
                }
            }
        }

        if(pointsA.size() == 1) {
            Point p = pointsA.get(0);
            board[p.r][p.c] = idx;
            return;
        }

        // 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
        int maxEmpty = 0;
        // 자리 후보
        ArrayList<Point> pointsB = new ArrayList<>();

        for (Point p : pointsA) {
            int countEmpty = 0;

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(0 <= nr && nr < N && 0 <= nc && nc < N && board[nr][nc] == 0) {
                    countEmpty++;
                }
            }

            if(countEmpty > maxEmpty) {
                maxEmpty = countEmpty;
                pointsB.clear();
                pointsB.add(new Point(p.r, p.c));
            } else if (countEmpty == maxEmpty) {
                pointsB.add(new Point(p.r, p.c));
            }
        }

        if(pointsB.size() == 1) {
            Point p = pointsB.get(0);
            board[p.r][p.c] = idx;
            return;
        }

        // 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로,
        // 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        Collections.sort(pointsB);
        Point p = pointsB.get(0);
        board[p.r][p.c] = idx;
    }

    // 만족도를 구하는 함수
    static int getSat() {
        int res = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int countLike = 0;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (0 <= nr && nr < N && 0 <= nc && nc < N
                        && students[board[r][c]].isLike(board[nr][nc])) {
                        countLike++;
                    }
                }

                if(countLike == 1) {
                    res += 1;
                } else if (countLike == 2) {
                    res += 10;
                } else if (countLike == 3) {
                    res += 100;
                } else if (countLike == 4) {
                    res += 1000;
                }
            }
        }

        return res;
    }
}

class Student {

    Point point;
    ArrayList<Integer> likes = new ArrayList<>();

    public void addLikes(int like) {
        this.likes.add(like);
    }

    public boolean isLike(int idx) {
        for (int like : likes) {
            if (like == idx) {
                return true;
            }
        }
        return false;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}

class Point implements Comparable<Point> {

    int r;
    int c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Point o) {
        if(this.r == o.r) {
            return o.c - this.c;
        } else {
            return o.r - this.r;
        }
    }
}