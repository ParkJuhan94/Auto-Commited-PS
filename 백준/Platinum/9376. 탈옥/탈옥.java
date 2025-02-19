import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 100000000;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            // 맵 확장: 테두리를 추가하여 크기를 (h+2) x (w+2)로 만듦
            char[][] map = new char[h + 2][w + 2];
            for (int i = 0; i < h + 2; i++) {
                Arrays.fill(map[i], '.');
            }
            
            List<Point> prisoners = new ArrayList<>();
            for (int i = 1; i <= h; i++) {
                String line = br.readLine();
                for (int j = 1; j <= w; j++) {
                    map[i][j] = line.charAt(j - 1);
                    if (map[i][j] == '$') {
                        prisoners.add(new Point(i, j));
                    }
                }
            }
            
            // 0-1 BFS 세 번 실행
            int[][] distOutside = bfs(map, 0, 0, h + 2, w + 2);
            int[][] distP1 = bfs(map, prisoners.get(0).x, prisoners.get(0).y, h + 2, w + 2);
            int[][] distP2 = bfs(map, prisoners.get(1).x, prisoners.get(1).y, h + 2, w + 2);
            
            int answer = INF;
            // 모든 칸에 대해 세 BFS의 결과를 합산
            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    // 하나라도 도달할 수 없는 경우는 무시
                    if (distOutside[i][j] == INF || distP1[i][j] == INF || distP2[i][j] == INF) continue;
                    
                    int sum = distOutside[i][j] + distP1[i][j] + distP2[i][j];
                    // 해당 칸이 문이면, 중복 개수를 보정
                    if (map[i][j] == '#') sum -= 2;
                    
                    answer = Math.min(answer, sum);
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
    
    // 0-1 BFS 함수: 시작점 (startX, startY)에서 각 칸까지 도달하기 위한 문의 최소 개수를 계산
    static int[][] bfs(char[][] map, int startX, int startY, int H, int W) {
        int[][] dist = new int[H][W];
        for (int i = 0; i < H; i++) {
            Arrays.fill(dist[i], INF);
        }
        Deque<Point> deque = new LinkedList<>();
        deque.offer(new Point(startX, startY));
        dist[startX][startY] = 0;
        
        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            int x = cur.x, y = cur.y;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (map[nx][ny] == '*') continue; // 벽은 지나갈 수 없음
                
                int cost = dist[x][y];
                if (map[nx][ny] == '#') cost += 1;
                
                if (dist[nx][ny] > cost) {
                    dist[nx][ny] = cost;
                    // 비용이 추가된 경우 뒤에, 비용 변화가 없는 경우 앞에 넣음
                    if (map[nx][ny] == '#') {
                        deque.offerLast(new Point(nx, ny));
                    } else {
                        deque.offerFirst(new Point(nx, ny));
                    }
                }
            }
        }
        return dist;
    }
    
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }
}
