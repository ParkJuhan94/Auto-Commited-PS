//package BOJ.Section12.P16928;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] board = new int[101];
    static int[] dist = new int[101];

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section12/P16928/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;
        int answer = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 목표 도착
            if (cur == 100) {
                answer = Math.min(answer, dist[100]);
                continue;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;

                if (next <= 100) {
                    int move = board[next]; // 뱀이나 사다리 없다면 0

                    if (move == 0) {
                        if (dist[next] > dist[cur] + 1) {
                            q.add(next);
                            dist[next] = dist[cur] + 1;
                        }
                    } else {
                        if (dist[move] > dist[cur] + 1) {
                            q.add(move);
                            dist[move] = dist[cur] + 1;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

}
