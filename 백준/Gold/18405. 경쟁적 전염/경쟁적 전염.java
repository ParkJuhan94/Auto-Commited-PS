import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[][] grid = new int[N][N];
        
        // 우선순위 큐: (time, virus_num, r, c)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        int[][] visited = new int[N][N]; // 점령한 바이러스 번호 (0=미점령)
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = sc.nextInt();
                if (grid[r][c] != 0) {
                    visited[r][c] = grid[r][c];
                    pq.offer(new int[]{0, grid[r][c], r, c});
                }
            }
        }
        
        int S = sc.nextInt(), X = sc.nextInt() - 1, Y = sc.nextInt() - 1;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], virus = cur[1], r = cur[2], c = cur[3];
            
            if (time >= S) break; // S초 이후 확산 불필요
            
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc] != 0) continue;
                
                visited[nr][nc] = virus;
                pq.offer(new int[]{time + 1, virus, nr, nc});
            }
        }
        
        System.out.println(visited[X][Y]);
    }
}