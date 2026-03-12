import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), P = sc.nextInt();
        
        Map<Integer, Integer> seen = new HashMap<>();
        int cur = A, idx = 0;
        
        while (!seen.containsKey(cur)) {
            seen.put(cur, idx++);
            // 다음 항 계산
            int next = 0, tmp = cur;
            while (tmp > 0) {
                int digit = tmp % 10;
                int pw = 1;
                for (int i = 0; i < P; i++) pw *= digit;
                next += pw;
                tmp /= 10;
            }
            cur = next;
        }
        
        System.out.println(seen.get(cur));
    }
}