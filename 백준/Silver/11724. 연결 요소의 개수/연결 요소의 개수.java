//package BOJ.Section11.P11724;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int groupCount = 0;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section11/P11724/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);
        }

        int ans = 0;

        // 그룹 넘버 만들기
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                groupCount++;
            }
        }

        System.out.println(groupCount);
    }

    static void dfs(int cur) {
        for (int i = 0; i < graph[cur].size(); i++) {
            int next = graph[cur].get(i);

            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
