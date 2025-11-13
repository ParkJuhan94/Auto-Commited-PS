import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] original;
    static int[][] operations;
    static boolean[] used;
    static int[] order;
    static int answer = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        original = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        operations = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            operations[i][0] = Integer.parseInt(st.nextToken()) - 1; // 0-based
            operations[i][1] = Integer.parseInt(st.nextToken()) - 1;
            operations[i][2] = Integer.parseInt(st.nextToken());
        }
        
        // 모든 순열 시도
        used = new boolean[K];
        order = new int[K];
        permute(0);
        
        System.out.println(answer);
    }
    
    // 회전 연산 순서의 순열 생성
    static void permute(int depth) {
        if (depth == K) {
            // 현재 순서로 회전 수행 후 배열 값 계산
            int[][] arr = copyArray(original);
            
            for (int i = 0; i < K; i++) {
                int idx = order[i];
                rotate(arr, operations[idx][0], operations[idx][1], operations[idx][2]);
            }
            
            answer = Math.min(answer, getArrayValue(arr));
            return;
        }
        
        for (int i = 0; i < K; i++) {
            if (!used[i]) {
                used[i] = true;
                order[depth] = i;
                permute(depth + 1);
                used[i] = false;
            }
        }
    }
    
    // 배열 회전 (r, c, s) - 0-based
    static void rotate(int[][] arr, int r, int c, int s) {
        // s개의 사각형 레이어를 각각 회전
        for (int depth = 1; depth <= s; depth++) {
            int r1 = r - depth;
            int c1 = c - depth;
            int r2 = r + depth;
            int c2 = c + depth;
            
            // 임시 저장: 좌상단
            int temp = arr[r1][c1];
            
            // 왼쪽 세로 (위로 이동)
            for (int i = r1; i < r2; i++) {
                arr[i][c1] = arr[i + 1][c1];
            }
            
            // 아래쪽 가로 (왼쪽으로 이동)
            for (int j = c1; j < c2; j++) {
                arr[r2][j] = arr[r2][j + 1];
            }
            
            // 오른쪽 세로 (아래로 이동)
            for (int i = r2; i > r1; i--) {
                arr[i][c2] = arr[i - 1][c2];
            }
            
            // 위쪽 가로 (오른쪽으로 이동)
            for (int j = c2; j > c1 + 1; j--) {
                arr[r1][j] = arr[r1][j - 1];
            }
            
            // 임시 값 복원
            arr[r1][c1 + 1] = temp;
        }
    }
    
    // 배열 값 계산: 각 행의 합 중 최솟값
    static int getArrayValue(int[][] arr) {
        int minSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < M; j++) {
                rowSum += arr[i][j];
            }
            minSum = Math.min(minSum, rowSum);
        }
        
        return minSum;
    }
    
    // 배열 깊은 복사
    static int[][] copyArray(int[][] arr) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = arr[i].clone();
        }
        return copy;
    }
}