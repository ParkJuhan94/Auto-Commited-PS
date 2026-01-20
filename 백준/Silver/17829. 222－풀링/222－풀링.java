import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1x1이 될 때까지 풀링 반복
        while (N > 1) {
            matrix = pooling(matrix, N);
            N /= 2;
        }
        
        System.out.println(matrix[0][0]);
    }
    
    static int[][] pooling(int[][] matrix, int N) {
        int newN = N / 2;
        int[][] result = new int[newN][newN];
        
        for (int i = 0; i < newN; i++) {
            for (int j = 0; j < newN; j++) {
                // 2x2 블록에서 2번째로 큰 값 찾기
                int[] block = new int[4];
                block[0] = matrix[i * 2][j * 2];
                block[1] = matrix[i * 2][j * 2 + 1];
                block[2] = matrix[i * 2 + 1][j * 2];
                block[3] = matrix[i * 2 + 1][j * 2 + 1];
                
                // 정렬 후 2번째로 큰 값 (인덱스 2)
                Arrays.sort(block);
                result[i][j] = block[2];  // 4개 중 2번째로 큰 값
            }
        }
        
        return result;
    }
}