import java.io.*;
import java.util.*;

public class Main {
    // 상태 정보를 저장하는 클래스 (행, 열, 방향, 현재까지 사용한 거울 수)
    static class State {
        int r, c, d, cost;
        State(int r, int c, int d, int cost) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        String[] grid = new String[H];
        for (int i = 0; i < H; i++) {
            grid[i] = br.readLine();
        }
        
        // 두 'C'의 좌표를 찾는다.
        int[][] points = new int[2][2];
        int idx = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (grid[i].charAt(j) == 'C') {
                    points[idx][0] = i;
                    points[idx][1] = j;
                    idx++;
                    if(idx == 2) break;
                }
            }
            if(idx == 2) break;
        }
        int startR = points[0][0], startC = points[0][1];
        int targetR = points[1][0], targetC = points[1][1];
        
        // 각 위치에 대해 4방향(위, 오른쪽, 아래, 왼쪽)으로 도달할 때의 최소 거울 수를 저장
        int[][][] dist = new int[H][W][4];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        Deque<State> deque = new ArrayDeque<>();
        // 출발점에서는 모든 방향으로 진행 가능하며, 초기 거울 개수는 0
        for (int d = 0; d < 4; d++) {
            dist[startR][startC][d] = 0;
            deque.add(new State(startR, startC, d, 0));
        }
        
        // 이동 방향: 0: 위, 1: 오른쪽, 2: 아래, 3: 왼쪽
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while (!deque.isEmpty()) {
            State cur = deque.pollFirst();
            int r = cur.r, c = cur.c, d = cur.d, cost = cur.cost;
            // 현재 비용보다 큰 경우는 이미 처리된 경우이므로 continue
            if (cost > dist[r][c][d]) continue;
            
            for (int nd = 0; nd < 4; nd++) {
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                
                // 범위 체크 및 벽인 경우 건너뜀
                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if (grid[nr].charAt(nc) == '*') continue;
                
                // 방향이 바뀌면 거울 설치 필요 (비용 1 증가)
                int ncost = cost + (nd == d ? 0 : 1);
                if (dist[nr][nc][nd] > ncost) {
                    dist[nr][nc][nd] = ncost;
                    // 비용이 증가하지 않으면 deque의 앞쪽에, 증가하면 뒤쪽에 삽입
                    if (nd == d) {
                        deque.addFirst(new State(nr, nc, nd, ncost));
                    } else {
                        deque.addLast(new State(nr, nc, nd, ncost));
                    }
                }
            }
        }
        
        // 도착점에 도달하는 네 방향 중 최소 거울 개수를 찾는다.
        int answer = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            answer = Math.min(answer, dist[targetR][targetC][d]);
        }
        
        System.out.println(answer);
    }
}
