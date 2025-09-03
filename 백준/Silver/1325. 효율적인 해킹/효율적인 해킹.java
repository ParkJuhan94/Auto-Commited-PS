//package BOJ.Section12.P1325;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] visited = new int[10001];
    static int stamp = 1;
    static int[] rank;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section12/P1325/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        rank = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
//            rank[i] = dfs(i);
            rank[i] = bfs(i);
            max = Math.max(max, rank[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (rank[i] == max) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb.toString());
    }

//    static int dfs(int node) {
//        visited[node] = true;
//        int res = 0;
//
//        for (int i = 0; i < graph[node].size(); i++) {
//            int next = graph[node].get(i);
//
//            if (!visited[next]) {
//                res += dfs(next);
//                res++;
//            }
//        }
//
//        return res;
//    }

    static int bfs(int node) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited[node] = stamp;
        int res = 0;

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int i = 0; i < graph[cur].size(); i++) {
                int next = graph[cur].get(i);
                if (visited[next] != stamp) {
                    visited[next] = stamp;
                    q.add(next);
                    res++;
                }
            }
        }
        stamp++;
        return res;
    }
}
