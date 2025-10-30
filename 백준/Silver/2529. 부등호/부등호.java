import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static char[] signs;
    static boolean[] used;
    static int[] arr;
    static String maxResult = "";
    static String minResult = "";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        signs = new char[K];
        for (int i = 0; i < K; i++) {
            signs[i] = st.nextToken().charAt(0);
        }
        
        // 최댓값 찾기 (9부터 시작)
        used = new boolean[10];
        arr = new int[K + 1];
        findMax(0);
        
        // 최솟값 찾기 (0부터 시작)
        used = new boolean[10];
        arr = new int[K + 1];
        findMin(0);
        
        System.out.println(maxResult);
        System.out.println(minResult);
    }
    
    // 최댓값: 큰 수부터 시도
    static void findMax(int depth) {
        if (!maxResult.isEmpty()) return; // 이미 찾았으면 종료
        
        if (depth == K + 1) {
            if (isValid()) {
                StringBuilder sb = new StringBuilder();
                for (int num : arr) sb.append(num);
                maxResult = sb.toString();
            }
            return;
        }
        
        // 9부터 0까지 (큰 것부터)
        for (int i = 9; i >= 0; i--) {
            if (!used[i]) {
                used[i] = true;
                arr[depth] = i;
                findMax(depth + 1);
                used[i] = false;
            }
        }
    }
    
    // 최솟값: 작은 수부터 시도
    static void findMin(int depth) {
        if (!minResult.isEmpty()) return; // 이미 찾았으면 종료
        
        if (depth == K + 1) {
            if (isValid()) {
                StringBuilder sb = new StringBuilder();
                for (int num : arr) sb.append(num);
                minResult = sb.toString();
            }
            return;
        }
        
        // 0부터 9까지 (작은 것부터)
        for (int i = 0; i <= 9; i++) {
            if (!used[i]) {
                used[i] = true;
                arr[depth] = i;
                findMin(depth + 1);
                used[i] = false;
            }
        }
    }
    
    // 부등호 검증
    static boolean isValid() {
        for (int i = 0; i < K; i++) {
            if (signs[i] == '<') {
                if (arr[i] >= arr[i + 1]) return false;
            } else { // '>'
                if (arr[i] <= arr[i + 1]) return false;
            }
        }
        return true;
    }
}