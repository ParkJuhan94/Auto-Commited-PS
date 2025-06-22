import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static int[] group;
    static boolean isBipartite;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        while (K-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            group = new int[V + 1];
            isBipartite = true;

            for (int i = 1; i <= V; i++) {
                if (group[i] == 0) {
                    bfs(i);
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        group[start] = 1;

        while (!q.isEmpty() && isBipartite) {
            int current = q.poll();

            for (int neighbor : graph.get(current)) {
                if (group[neighbor] == 0) {
                    group[neighbor] = 3 - group[current]; // 1 <-> 2
                    q.add(neighbor);
                } else if (group[neighbor] == group[current]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
