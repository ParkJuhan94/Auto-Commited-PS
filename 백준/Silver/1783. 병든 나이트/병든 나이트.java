import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();
        
        long answer;
        
        if (N == 1) {
            answer = 1;
        } else if (N == 2) {
            answer = Math.min(4L, (M + 1) / 2);
        } else {
            // N >= 3
            if (M <= 6) {
                answer = Math.min(M, 4L);
            } else {
                answer = M - 2;
            }
        }
        
        System.out.println(answer);
    }
}