import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] p = new int[N + 1]; // 1-based
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) p[i] = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N + 1];
            int cycles = 0;

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    int cur = i;
                    while (!visited[cur]) {
                        visited[cur] = true;
                        cur = p[cur];
                    }
                    cycles++;
                }
            }
            out.append(cycles).append('\n');
        }
        System.out.print(out.toString());
    }
}
