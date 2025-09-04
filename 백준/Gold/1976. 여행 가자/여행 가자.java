//package BOJ.Section12.P1976;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section12/P1976/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < N + 1; j++) {
                int linked = Integer.parseInt(st.nextToken());
                if (linked == 1) {
                    union(i, j);
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            path.add(Integer.parseInt(st.nextToken()));
        }

        if (groupCount(path) == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static int groupCount(ArrayList<Integer> path) {
        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < path.size(); i++) {
            roots.add(find(path.get(i))); // 각 노드의 루트
        }
        return roots.size();
    }

    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }

        return parents[x] = find(parents[x]);
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return false;
        }

        // 더 작은 번호의 노드를 부모로 해야한다면
        if (x <= y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
        return true;
    }
}
