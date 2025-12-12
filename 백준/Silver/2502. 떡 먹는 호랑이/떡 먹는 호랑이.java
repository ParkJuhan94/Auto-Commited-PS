import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // i번째 날의 떡 개수 = weightA[i] * A + weightB[i] * B
        int[] weightA = new int[D + 1];
        int[] weightB = new int[D + 1];
        
        // 초기값: 첫째 날은 A개, 둘째 날은 B개
        weightA[1] = 1;  weightB[1] = 0;  // 1일차: A
        weightA[2] = 0;  weightB[2] = 1;  // 2일차: B
        
        // 피보나치 점화식으로 계수 계산
        for (int i = 3; i <= D; i++) {
            weightA[i] = weightA[i - 1] + weightA[i - 2];
            weightB[i] = weightB[i - 1] + weightB[i - 2];
        }
        
        // D일차: weightA[D] * A + weightB[D] * B = K
        // A를 1부터 시도하며 정수 B 찾기
        for (int A = 1; A <= K; A++) {
            int remainder = K - weightA[D] * A;
            
            // B가 양의 정수이고, A ≤ B를 만족하는지 확인
            if (remainder > 0 && remainder % weightB[D] == 0) {
                int B = remainder / weightB[D];
                
                if (A <= B) {
                    System.out.println(A);
                    System.out.println(B);
                    return;
                }
            }
        }
    }
}