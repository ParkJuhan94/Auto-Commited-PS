import java.util.*;

public class Main {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
        
        // 파이어볼: {r, c, m, s, d}
        List<int[]> balls = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int r = sc.nextInt()-1, c = sc.nextInt()-1;
            int m = sc.nextInt(), s = sc.nextInt(), d = sc.nextInt();
            balls.add(new int[]{r, c, m, s, d});
        }
        
        for (int k = 0; k < K; k++) {
            // 1. 이동
            for (int[] b : balls) {
                b[0] = ((b[0] + dr[b[4]] * b[3]) % N + N) % N;
                b[1] = ((b[1] + dc[b[4]] * b[3]) % N + N) % N;
            }
            
            // 2. 칸별로 모으기
            @SuppressWarnings("unchecked")
            List<int[]>[][] grid = new List[N][N];
            for (int r = 0; r < N; r++)
                for (int c = 0; c < N; c++)
                    grid[r][c] = new ArrayList<>();
            
            for (int[] b : balls)
                grid[b[0]][b[1]].add(b);
            
            balls.clear();
            
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    List<int[]> cell = grid[r][c];
                    if (cell.isEmpty()) continue;
                    if (cell.size() == 1) {
                        balls.add(cell.get(0));
                        continue;
                    }
                    
                    // 합치기
                    int sumM = 0, sumS = 0;
                    int oddCnt = 0, evenCnt = 0;
                    for (int[] b : cell) {
                        sumM += b[2]; sumS += b[3];
                        if (b[4] % 2 == 0) evenCnt++; else oddCnt++;
                    }
                    int newM = sumM / 5;
                    int newS = sumS / cell.size();
                    if (newM == 0) continue;
                    
                    // 방향 결정
                    int[] dirs = (oddCnt == 0 || evenCnt == 0) 
                        ? new int[]{0, 2, 4, 6} 
                        : new int[]{1, 3, 5, 7};
                    
                    for (int d : dirs)
                        balls.add(new int[]{r, c, newM, newS, d});
                }
            }
        }
        
        int ans = 0;
        for (int[] b : balls) ans += b[2];
        System.out.println(ans);
    }
}