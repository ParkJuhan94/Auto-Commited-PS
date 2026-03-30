import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt();
        int m = sc.nextInt();
        
        // A진법 → 10진법
        long val = 0;
        for (int i = 0; i < m; i++) {
            val = val * A + sc.nextInt();
        }
        
        // 10진법 → B진법
        if (val == 0) {
            System.out.println(0);
            return;
        }
        
        List<Long> digits = new ArrayList<>();
        while (val > 0) {
            digits.add(val % B);
            val /= B;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = digits.size() - 1; i >= 0; i--) {
            if (i < digits.size() - 1) sb.append(' ');
            sb.append(digits.get(i));
        }
        System.out.println(sb);
    }
}