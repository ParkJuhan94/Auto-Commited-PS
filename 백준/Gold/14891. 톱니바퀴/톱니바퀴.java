import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer>[] gears = new ArrayDeque[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 상태 입력
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            gears[i] = new ArrayDeque<>();
            for (char c : line.toCharArray()) {
                gears[i].addLast(c - '0');
            }
        }

        int k = Integer.parseInt(br.readLine()); // 회전 횟수

        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1; // 톱니 번호 (0-indexed)
            int dir = Integer.parseInt(st.nextToken());

            int[] rotateDir = new int[4];
            rotateDir[num] = dir;

            // 왼쪽 전파
            for (int i = num - 1; i >= 0; i--) {
                if (getNth(gears[i], 2) != getNth(gears[i + 1], 6)) {
                    rotateDir[i] = -rotateDir[i + 1];
                } else break;
            }

            // 오른쪽 전파
            for (int i = num + 1; i < 4; i++) {
                if (getNth(gears[i - 1], 2) != getNth(gears[i], 6)) {
                    rotateDir[i] = -rotateDir[i - 1];
                } else break;
            }

            // 회전 실행
            for (int i = 0; i < 4; i++) {
                if (rotateDir[i] == 1) rotateClockwise(gears[i]);
                else if (rotateDir[i] == -1) rotateCounterClockwise(gears[i]);
            }
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].peekFirst() == 1) {
                score += (1 << i); // 1, 2, 4, 8
            }
        }

        System.out.println(score);
    }

    static void rotateClockwise(Deque<Integer> gear) {
        gear.addFirst(gear.pollLast());
    }

    static void rotateCounterClockwise(Deque<Integer> gear) {
        gear.addLast(gear.pollFirst());
    }

    static int getNth(Deque<Integer> gear, int index) {
        int[] arr = gear.stream().mapToInt(i -> i).toArray();
        return arr[index];
    }
}
