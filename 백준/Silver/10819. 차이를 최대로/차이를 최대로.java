//package BOJ.Section12.P10819;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, ans = 0;
    static ArrayList<Integer> nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
  //      System.setIn(new FileInputStream("src/BOJ/Section12/P10819/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        int[] resNums = new int[N];
        visited = new boolean[N];

        dfs(0, resNums);

        System.out.println(ans);
    }

    static void dfs(int depth, int[] resNums) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += (Math.abs(resNums[i] - resNums[i + 1]));
            }

            if (ans < sum) {
                ans = sum;
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                resNums[depth] = nums.get(i);
                visited[i] = true;
                dfs(depth + 1, resNums);
                visited[i] = false;
            }
        }
    }
}
