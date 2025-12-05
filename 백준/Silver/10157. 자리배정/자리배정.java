import java.io.*;
import java.util.*;

public class Main {
    static int C, R, K;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        
        board = new int[R][C];
        visited = new boolean[R][C];
        int dir = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(R - 1, 0, dir, 1));
        visited[R - 1][0] = true;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            // 종료 조건
            if(cur.count == K) {
                System.out.print((cur.c + 1) + " " + (R - cur.r));
                return;
            }
            
            int nr = cur.r + dr[dir];
            int nc = cur.c + dc[dir];
            
            if(0 <= nr && nr < R && 0 <= nc && nc < C && !visited[nr][nc]) {
                q.add(new Point(nr, nc, dir, cur.count + 1));
                visited[nr][nc] = true;
            } else {
                dir = (dir + 1) % 4;
                nr = cur.r + dr[dir];
                nc = cur.c + dc[dir];
                
                if(!visited[nr][nc]) {                    
                    q.add(new Point(nr, nc, dir, cur.count + 1));
                    visited[nr][nc] = true;
                }
            }            
        }
        
        System.out.print(0);
    }
}

class Point {
    int r;
    int c;
    int dir;
    int count;
    
    public Point(int r, int c, int dir, int count) {
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.count = count;
    }
}