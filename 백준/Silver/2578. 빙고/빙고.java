import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] checked = new boolean[5][5];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 빙고판 입력 + 좌표 매핑
        Map<Integer, int[]> pos = new HashMap<>();
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                pos.put(num, new int[]{i, j});
            }
        }
        
        // 2. 사회자가 부르는 수 입력
        int[] calls = new int[25];
        int idx = 0;
        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                calls[idx++] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 3. 차례대로 지우면서 빙고 체크
        for(int turn = 0; turn < 25; turn++) {
            int[] p = pos.get(calls[turn]);
            checked[p[0]][p[1]] = true;
            
            if(turn >= 11 && countBingo() >= 3) {  // 최소 12칸 지워야 빙고 가능
                System.out.print(turn + 1);
                return;
            }
        }
    }
    
    static int countBingo() {
        int cnt = 0;
        
        // 가로 체크
        for(int i = 0; i < 5; i++) {
            boolean bingo = true;
            for(int j = 0; j < 5; j++) {
                if(!checked[i][j]) {
                    bingo = false;
                    break;
                }
            }
            if(bingo) cnt++;
        }
        
        // 세로 체크
        for(int j = 0; j < 5; j++) {
            boolean bingo = true;
            for(int i = 0; i < 5; i++) {
                if(!checked[i][j]) {
                    bingo = false;
                    break;
                }
            }
            if(bingo) cnt++;
        }
        
        // 대각선 1 (\)
        boolean bingo1 = true;
        for(int i = 0; i < 5; i++) {
            if(!checked[i][i]) {
                bingo1 = false;
                break;
            }
        }
        if(bingo1) cnt++;
        
        // 대각선 2 (/)
        boolean bingo2 = true;
        for(int i = 0; i < 5; i++) {
            if(!checked[i][4-i]) {
                bingo2 = false;
                break;
            }
        }
        if(bingo2) cnt++;
        
        return cnt;
    }
}