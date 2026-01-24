import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int countA = 0;
    static int countB = 0;
    static int countC = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }            
        
        solve(0, 0, N);
        
        System.out.println(countA);
        System.out.println(countB);
        System.out.println(countC);
    }
    
    static void solve(int r, int c, int size) {
        if(isPossible(r, c, size)) {
            if(paper[r][c] == -1) {
                countA++;
            }
            
            if(paper[r][c] == 0) {
                countB++;
            }
            
            if(paper[r][c] == 1) {
                countC++;
            }
            
            return;
        }
        
        int newSize = size / 3;
        
        solve(r, c, newSize);
        solve(r, c + newSize, newSize);
        solve(r, c + 2 * newSize, newSize);
        solve(r + newSize, c, newSize);
        solve(r + newSize, c + newSize, newSize);
        solve(r + newSize, c + 2 * newSize , newSize);
        solve(r + 2 * newSize, c, newSize);
        solve(r + 2 * newSize, c + newSize, newSize);
        solve(r + 2 * newSize, c + 2 * newSize, newSize);
    }
    
    static boolean isPossible(int r, int c, int size) {
        int target = paper[r][c];
        
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(paper[i][j] != target) {
                    return false;
                } 
            }
        }
        
        return true;
    }
}