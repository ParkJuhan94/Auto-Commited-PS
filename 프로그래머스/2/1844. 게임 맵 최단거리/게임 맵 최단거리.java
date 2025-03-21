import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        boolean[][] visited = new boolean[N][M];
        
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            if(cur.r == N - 1 && cur.c == M - 1) {
                answer = cur.dist;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;
                
                if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc] && maps[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, cur.dist + 1));
                }
            }
        }
        
        
        
        return answer;
    }    
}

class Point {
    int r;
    int c;
    int dist;
    Point (int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}