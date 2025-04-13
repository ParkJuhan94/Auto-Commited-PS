import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 4개의 톱니바퀴 상태를 읽어와서 char 배열에 저장합니다.
        char[][] gears = new char[4][8];
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            gears[i] = line.toCharArray();
        }
        
        // 회전 횟수 K 읽기
        int K = Integer.parseInt(br.readLine());
        // K번의 회전 명령 처리
        for (int command = 0; command < K; command++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearIndex = Integer.parseInt(st.nextToken()) - 1; // 0부터 시작하도록 조정
            int direction = Integer.parseInt(st.nextToken());
            
            // 각 톱니바퀴의 회전 방향 (0: 회전하지 않음)
            int[] directions = new int[4];
            directions[gearIndex] = direction;
            
            // 왼쪽으로 회전 전파
            for (int i = gearIndex - 1; i >= 0; i--) {
                // 오른쪽 톱니바퀴의 6번, 현재 톱니바퀴의 2번 극을 비교합니다.
                if (gears[i + 1][6] != gears[i][2]) {
                    directions[i] = -directions[i + 1];
                } else {
                    break;
                }
            }
            
            // 오른쪽으로 회전 전파
            for (int i = gearIndex + 1; i < 4; i++) {
                // 왼쪽 톱니바퀴의 2번, 현재 톱니바퀴의 6번 극을 비교합니다.
                if (gears[i - 1][2] != gears[i][6]) {
                    directions[i] = -directions[i - 1];
                } else {
                    break;
                }
            }
            
            // 각 톱니바퀴에 대해 회전 수행
            for (int i = 0; i < 4; i++) {
                if (directions[i] != 0) {
                    gears[i] = rotate(gears[i], directions[i]);
                }
            }
        }
        
        // 최종 점수 계산
        int score = 0;
        if (gears[0][0] == '1') score += 1;
        if (gears[1][0] == '1') score += 2;
        if (gears[2][0] == '1') score += 4;
        if (gears[3][0] == '1') score += 8;
        System.out.println(score);
    }
    
    // 톱니바퀴를 회전시키는 메서드
    // direction == 1: 시계 방향, direction == -1: 반시계 방향
    public static char[] rotate(char[] gear, int direction) {
        char[] newGear = new char[8];
        if (direction == 1) { // 시계 방향: 마지막 원소를 앞으로
            newGear[0] = gear[7];
            for (int i = 1; i < 8; i++) {
                newGear[i] = gear[i - 1];
            }
        } else if (direction == -1) { // 반시계 방향: 첫 원소를 뒤로
            for (int i = 0; i < 7; i++) {
                newGear[i] = gear[i + 1];
            }
            newGear[7] = gear[0];
        }
        return newGear;
    }
}
