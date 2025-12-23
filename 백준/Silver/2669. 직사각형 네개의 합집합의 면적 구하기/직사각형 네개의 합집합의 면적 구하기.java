import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited = new boolean[101][101];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            
            makeVisited(r1, c1, r2, c2);
        }
        
        int answer = 0;
        
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                if(visited[i][j]) {
                    answer++;
                }
            }
        }
        
        System.out.println(answer);
    }
    
    static void makeVisited(int r1, int c1, int r2, int c2) {
        for(int i = r1; i < r2; i++) {
            for(int j = c1; j < c2; j++) {
                visited[i][j] = true;
            }
        }
    }
}