import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long B;
    static final int MOD = 1000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        
        long[][] A = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }
        
        long[][] result = power(A, B);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] % MOD).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    // 재귀적으로 행렬 제곱을 계산하는 메서드
    static long[][] power(long[][] matrix, long exp) {
        if (exp == 1) {
            // 기본 케이스: 행렬의 각 원소를 MOD로 나눈 나머지 반환
            long[][] base = new long[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    base[i][j] = matrix[i][j] % MOD;
                }
            }
            return base;
        }
        
        long[][] half = power(matrix, exp / 2);
        long[][] result = multiply(half, half);
        
        if (exp % 2 == 1) {
            result = multiply(result, matrix);
        }
        
        return result;
    }
    
    // 두 행렬의 곱셈을 수행 (모든 연산은 MOD 연산 포함)
    static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }
}
