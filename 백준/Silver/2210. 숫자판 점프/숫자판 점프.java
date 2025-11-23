import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static String[][] board = new String[5][5];
    static Set<String> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = st.nextToken();
            }
        }
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                dfs(0, i, j, board[i][j]);        
            }
        }
        
        System.out.println(set.size());
    }        
    
    static void dfs(int depth, int r, int c, String str) {
        if(depth == 5) {
            set.add(str);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(0 <= nr && nr < 5 && 0 <= nc && nc < 5) {
                dfs(depth + 1, nr, nc, str + board[nr][nc]);
            }
        }
    }
}