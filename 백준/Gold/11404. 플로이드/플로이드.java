//package BOJ.Section12.P11404;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
    //    System.setIn(new FileInputStream("src/BOJ/Section12/P11404/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        int INF = Integer.MAX_VALUE;
        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[start][end] = Math.min(dist[start][end], cost);
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (dist[j][i] == INF) {
                    continue;
                }
                for (int k = 1; k < N + 1; k++) {
                    if(dist[i][k] == INF) {
                        continue;
                    }
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                if(dist[i][j] == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

}

