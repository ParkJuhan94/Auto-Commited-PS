import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dr = {1, 0, -1, -1, -1, 0, 1, 1};
    static int[] dc = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[][] board;
    static boolean[][] visited;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < N; i++) {            
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
        
        System.out.print(answer);
    }
    
    static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c, 0));
        visited = new boolean[N][M];
        visited[r][c] = true;
        
        while(!q.isEmpty()) {
            Point cur = q.poll();
            
            for(int i = 0; i < 8; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]) {
                    visited[nr][nc] = true;  // ✅ 여기로 이동! (상어든 빈칸이든 무조건 방문 처리)
                    
                    if(board[nr][nc] == 1) {
                        answer = Math.max(answer, cur.dist + 1);
                        return;  // ✅ 최초 상어 발견 시 종료 (BFS는 최단거리 보장)
                    } else {
                        q.add(new Point(nr, nc, cur.dist + 1));
                    }
                }
            }
        }
    }
}

class Point { 
    int r;
    int c;
    int dist;
    
    public Point(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }
}