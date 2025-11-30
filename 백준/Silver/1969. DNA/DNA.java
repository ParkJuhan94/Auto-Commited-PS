import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] dna = new String[N];
        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }
        
        char[] result = new char[M];
        int totalDistance = 0;
        
        // 각 위치마다 최적 문자 선택
        for (int i = 0; i < M; i++) {
            int[] count = new int[4];  // A, C, G, T
            
            // 해당 위치의 각 문자 빈도 계산
            for (int j = 0; j < N; j++) {
                char c = dna[j].charAt(i);
                if (c == 'A') count[0]++;
                else if (c == 'C') count[1]++;
                else if (c == 'G') count[2]++;
                else if (c == 'T') count[3]++;
            }
            
            // 최빈 문자 찾기 (동점이면 사전순)
            int maxCount = 0;
            int maxIdx = 0;
            for (int k = 0; k < 4; k++) {
                if (count[k] > maxCount) {
                    maxCount = count[k];
                    maxIdx = k;
                }
            }
            
            // 결과 저장
            char[] chars = {'A', 'C', 'G', 'T'};
            result[i] = chars[maxIdx];
            
            // Hamming Distance 누적 (N - 최빈도)
            totalDistance += (N - maxCount);
        }
        
        System.out.println(new String(result));
        System.out.println(totalDistance);
    }
}