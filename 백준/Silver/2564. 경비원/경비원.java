import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt(), H = sc.nextInt();
        int perimeter = 2 * (W + H);
        int n = sc.nextInt();
        
        int[] shops = new int[n];
        for (int i = 0; i < n; i++) {
            shops[i] = toLinear(sc.nextInt(), sc.nextInt(), W, H);
        }
        int me = toLinear(sc.nextInt(), sc.nextInt(), W, H);
        
        long total = 0;
        for (int s : shops) {
            int diff = Math.abs(me - s);
            total += Math.min(diff, perimeter - diff);
        }
        System.out.println(total);
    }
    
    static int toLinear(int dir, int d, int W, int H) {
        switch (dir) {
            case 1: return d;                    // 북: 왼→오
            case 4: return W + d;                // 동: 위→아래
            case 2: return W + H + (W - d);      // 남: 오→왼
            case 3: return 2 * W + H + (H - d);  // 서: 아래→위
        }
        return 0;
    }
}