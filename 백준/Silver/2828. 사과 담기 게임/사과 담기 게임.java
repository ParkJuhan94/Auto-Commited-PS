import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int J = sc.nextInt();
        
        int left = 1; // 바구니 왼쪽 끝 (1-indexed)
        int total = 0;
        
        for (int i = 0; i < J; i++) {
            int apple = sc.nextInt();
            // 바구니 범위: [left, left+M-1]
            if (apple < left) {
                // 왼쪽으로 이동
                total += left - apple;
                left = apple;
            } else if (apple > left + M - 1) {
                // 오른쪽으로 이동
                total += apple - (left + M - 1);
                left = apple - M + 1;
            }
            // 이미 범위 안이면 이동 불필요
        }
        
        System.out.println(total);
    }
}