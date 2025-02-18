import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n은 최대 10^18까지 주어질 수 있음
        long n = Long.parseLong(br.readLine());
        
        // fast doubling을 통해 F(n)를 구함 (첫번째 원소가 F(n))
        long[] result = fib(n);
        System.out.println(result[0] % MOD);
    }
    
    /**
     * fast doubling 방식으로 [F(n), F(n+1)]을 반환.
     * 재귀적으로 n/2를 구한 후 아래 관계식을 사용
     * 
     * a = F(n), b = F(n+1) 인 상황에서
     * F(2n)   = a * (2*b - a)
     * F(2n+1) = a*a + b*b
     */
    private static long[] fib(long n) {
        if(n == 0) return new long[]{0, 1};
        
        long[] half = fib(n / 2);
        long a = half[0]; // F(n/2)
        long b = half[1]; // F(n/2 + 1)
        
        // 계산 시 음수가 나오지 않도록 주의
        long c = (a * ((2 * b % MOD - a + MOD) % MOD)) % MOD; // F(2*(n/2)) = F(n)
        long d = ( (a * a) % MOD + (b * b) % MOD ) % MOD;         // F(2*(n/2)+1) = F(n+1)
        
        if(n % 2 == 0) {
            return new long[]{c, d};
        } else {
            return new long[]{d, (c + d) % MOD};
        }
    }
}
