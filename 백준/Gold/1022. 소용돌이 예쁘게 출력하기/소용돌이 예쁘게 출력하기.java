import java.util.*;

public class Main {
    static int r1, c1, r2, c2, rows, cols;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        rows = r2 - r1 + 1;
        cols = c2 - c1 + 1;
        map = new int[rows][cols];

        int[] dx = {0, -1, 0, 1}; // → ↑ ← ↓
        int[] dy = {1, 0, -1, 0};

        int x = 0, y = 0, num = 1;
        int len = 1; // 현재 방향으로 이동할 칸 수
        int dir = 0; // 현재 방향 index

        int filled = 0;
        int total = rows * cols;

        while (filled < total) {
            for (int i = 0; i < 2; i++) { // 같은 길이로 두 번(방향 두 개) 이동
                for (int j = 0; j < len; j++) {
                    if (r1 <= x && x <= r2 && c1 <= y && y <= c2) {
                        map[x - r1][y - c1] = num;
                        filled++;
                    }
                    if (filled >= total) break;

                    x += dx[dir];
                    y += dy[dir];
                    num++;
                }
                dir = (dir + 1) % 4; // 방향 바꾸기
            }
            len++; // 다음 사이클마다 이동 길이 증가
        }

        // 최대 숫자의 길이 계산
        int maxLen = 0;
        for (int[] row : map) {
            for (int val : row) {
                maxLen = Math.max(maxLen, val);
            }
        }
        int maxDigits = Integer.toString(maxLen).length();

        // 출력
        for (int[] row : map) {
            for (int val : row) {
                System.out.print(String.format("%" + maxDigits + "d ", val));
            }
            System.out.println();
        }
    }
}
