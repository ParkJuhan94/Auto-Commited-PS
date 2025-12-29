import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[][] room = new char[N][N];
        
        // 입력 받기
        for (int i = 0; i < N; i++) {
            room[i] = br.readLine().toCharArray();
        }
        
        int horizontal = 0;  // 가로 누울 자리
        int vertical = 0;    // 세로 누울 자리
        
        // 1. 가로 누울 자리 찾기
        for (int i = 0; i < N; i++) {
            int count = 0;  // 연속된 '.' 개수
            
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    // 'X' 만났을 때 이전 연속 구간 체크
                    if (count >= 2) {
                        horizontal++;
                    }
                    count = 0;  // 초기화
                }
            }
            
            // 행 끝에서 마지막 구간 체크
            if (count >= 2) {
                horizontal++;
            }
        }
        
        // 2. 세로 누울 자리 찾기
        for (int j = 0; j < N; j++) {
            int count = 0;
            
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) {
                        vertical++;
                    }
                    count = 0;
                }
            }
            
            // 열 끝에서 마지막 구간 체크
            if (count >= 2) {
                vertical++;
            }
        }
        
        System.out.println(horizontal + " " + vertical);
    }
}