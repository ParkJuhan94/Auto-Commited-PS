import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] innings;  // [이닝][선수번호] = 결과
    static int[] order = new int[9];  // 타순 (0~8번 타석에 누가 서는지)
    static boolean[] used = new boolean[9];
    static int maxScore = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        innings = new int[N][9];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1번 선수(인덱스 0)는 4번 타자(인덱스 3)로 고정
        order[3] = 0;
        used[0] = true;
        
        makeOrder(0);
        System.out.println(maxScore);
    }
    
    // 타순 순열 생성
    static void makeOrder(int idx) {
        if (idx == 9) {
            int score = playGame();
            maxScore = Math.max(maxScore, score);
            return;
        }
        
        if (idx == 3) {  // 4번 타자는 스킵
            makeOrder(idx + 1);
            return;
        }
        
        for (int i = 1; i < 9; i++) {  // 2~9번 선수 (인덱스 1~8)
            if (!used[i]) {
                used[i] = true;
                order[idx] = i;
                makeOrder(idx + 1);
                used[i] = false;
            }
        }
    }
    
    // 야구 경기 시뮬레이션
    static int playGame() {
        int score = 0;
        int batterIdx = 0;  // 현재 타자 (0~8 순환)
        
        for (int inning = 0; inning < N; inning++) {
            int out = 0;
            boolean[] base = new boolean[4];  // 1루, 2루, 3루 (인덱스 1~3)
            
            while (out < 3) {
                int player = order[batterIdx];
                int result = innings[inning][player];
                
                if (result == 0) {  // 아웃
                    out++;
                } else if (result == 4) {  // 홈런
                    score++;  // 타자 득점
                    for (int i = 1; i <= 3; i++) {
                        if (base[i]) {
                            score++;
                            base[i] = false;
                        }
                    }
                } else {  // 안타/2루타/3루타
                    // 주자들 진루 (역순으로 처리해야 덮어쓰기 방지)
                    for (int i = 3; i >= 1; i--) {
                        if (base[i]) {
                            int next = i + result;
                            if (next >= 4) {
                                score++;
                            } else {
                                base[next] = true;
                            }
                            base[i] = false;
                        }
                    }
                    // 타자 진루
                    if (result < 4) {
                        base[result] = true;
                    }
                }
                
                batterIdx = (batterIdx + 1) % 9;
            }
        }
        
        return score;
    }
}