import java.util.*;

public class Main {
    static int s, N, K;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt(); N = sc.nextInt(); K = sc.nextInt();
        long R1 = sc.nextLong(), R2 = sc.nextLong();
        long C1 = sc.nextLong(), C2 = sc.nextLong();
        
        // N^s 크기 미리 계산 (s=0이면 1)
        long[] blockSize = new long[s + 1];
        blockSize[0] = 1;
        for (int i = 1; i <= s; i++) blockSize[i] = blockSize[i-1] * N;
        
        StringBuilder sb = new StringBuilder();
        for (long r = R1; r <= R2; r++) {
            for (long c = C1; c <= C2; c++) {
                sb.append(isBlack(r, c, s, blockSize) ? '1' : '0');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    
    static boolean isBlack(long r, long c, int level, long[] blockSize) {
        if (level == 0) return false;
        
        long bSize = blockSize[level - 1]; // 서브블록 하나의 크기
        int br = (int)(r / bSize);
        int bc = (int)(c / bSize);
        long lr = r % bSize;
        long lc = c % bSize;
        
        int offset = (N - K) / 2;
        // 가운데 K×K 영역인지 확인
        if (br >= offset && br < offset + K && bc >= offset && bc < offset + K) {
            return true;
        }
        
        return isBlack(lr, lc, level - 1, blockSize);
    }
}