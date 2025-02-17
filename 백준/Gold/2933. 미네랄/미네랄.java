import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    // 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }
        
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        // 막대 던지기: 첫번째는 왼쪽에서, 그 다음은 오른쪽에서 던짐
        for (int turn = 0; turn < n; turn++) {
            int height = Integer.parseInt(st.nextToken());
            int row = R - height; // 높이 1은 바닥(마지막 행)
            
            // 막대 던지기 (방향에 따라 탐색 순서가 달라짐)
            if (turn % 2 == 0) { // 왼쪽에서 오른쪽
                for (int j = 0; j < C; j++) {
                    if (map[row][j] == 'x') {
                        map[row][j] = '.';
                        break;
                    }
                }
            } else { // 오른쪽에서 왼쪽
                for (int j = C - 1; j >= 0; j--) {
                    if (map[row][j] == 'x') {
                        map[row][j] = '.';
                        break;
                    }
                }
            }
            
            // 제거 후, 바닥에 연결된 미네랄 찾기 (BFS)
            boolean[][] visited = new boolean[R][C];
            for (int j = 0; j < C; j++) {
                if (map[R - 1][j] == 'x' && !visited[R - 1][j]) {
                    bfs(R - 1, j, visited);
                }
            }
            
            // 바닥과 연결되지 않은(방문되지 않은) 미네랄은 떠 있는 클러스터
            List<int[]> cluster = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] == 'x' && !visited[i][j]) {
                        cluster.add(new int[]{i, j});
                    }
                }
            }
            
            // 떠 있는 클러스터가 없으면 다음 턴으로
            if (cluster.isEmpty()) continue;
            
            // 클러스터를 지도에서 제거
            for (int[] cell : cluster) {
                map[cell[0]][cell[1]] = '.';
            }
            
            // 클러스터가 얼마만큼 떨어질 수 있는지 계산
            int dropDistance = R; // 최댓값 초기화
            for (int[] cell : cluster) {
                int r0 = cell[0];
                int c0 = cell[1];
                int d = 0;
                while (true) {
                    int nr = r0 + d + 1;
                    if (nr >= R) break; // 바닥에 도달
                    if (map[nr][c0] == 'x') break; // 다른 미네랄을 만남
                    d++;
                }
                dropDistance = Math.min(dropDistance, d);
            }
            
            // 클러스터를 떨어뜨린 후 다시 지도에 배치
            for (int[] cell : cluster) {
                map[cell[0] + dropDistance][cell[1]] = 'x';
            }
        }
        
        // 최종 지도의 상태 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(new String(map[i])).append("\n");
        }
        System.out.print(sb);
    }
    
    // BFS를 통해 (r, c)에서 시작하여 연결된 미네랄(바닥과 연결된)을 방문 처리
    static void bfs(int r, int c, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curR = cur[0], curC = cur[1];
            
            for (int d = 0; d < 4; d++) {
                int nr = curR + dx[d];
                int nc = curC + dy[d];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] == 'x') {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}
