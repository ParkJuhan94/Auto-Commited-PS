import java.util.*;

public class Main {
    static long[] size;
    static long[] patty;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long X = sc.nextLong();
        
        size = new long[N + 1];
        patty = new long[N + 1];
        size[0] = 1;
        patty[0] = 1;
        
        for (int i = 1; i <= N; i++) {
            size[i] = Math.min(size[i-1] * 2 + 3, (long) 4e18); // overflow 방지
            patty[i] = patty[i-1] * 2 + 1;
        }
        
        System.out.println(count(N, X));
    }
    
    static long count(int lv, long x) {
        if (x == 0) return 0;
        if (lv == 0) return 1; // x는 반드시 1
        
        // 1) 첫 번째 B
        if (x == 1) return 0;
        x--;
        
        // 2) 첫 번째 Level-(lv-1) 버거
        if (x <= size[lv-1]) return count(lv - 1, x);
        long p = patty[lv-1];
        x -= size[lv-1];
        
        // 3) 중간 P
        if (x == 1) return p + 1;
        x--;
        p++;
        
        // 4) 두 번째 Level-(lv-1) 버거
        if (x <= size[lv-1]) return p + count(lv - 1, x);
        
        // 5) 마지막 B (전부 먹은 경우)
        return p + patty[lv-1];
    }
}