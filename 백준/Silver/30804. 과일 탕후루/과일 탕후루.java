import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] count = new int[10];  // 과일 번호 1~9 카운트
        int kinds = 0;              // 현재 윈도우의 과일 종류 수
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < N; right++) {
            // right 과일 추가
            if (count[fruits[right]] == 0) {
                kinds++;  // 새로운 종류 추가
            }
            count[fruits[right]]++;
            
            // 과일 종류가 3개 이상이면 left 이동
            while (kinds > 2) {
                count[fruits[left]]--;
                if (count[fruits[left]] == 0) {
                    kinds--;  // 종류 하나 제거됨
                }
                left++;
            }
            
            // 현재 구간 길이 갱신
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        System.out.println(maxLen);
    }
}