import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        
        for (int k = 1; k <= K; k++) {
            int N = sc.nextInt();
            int[] scores = new int[N];
            for (int i = 0; i < N; i++) scores[i] = sc.nextInt();
            
            Arrays.sort(scores);
            
            int max = scores[N - 1];
            int min = scores[0];
            
            int largestGap = 0;
            for (int i = 1; i < N; i++)
                largestGap = Math.max(largestGap, scores[i] - scores[i - 1]);
            
            System.out.println("Class " + k);
            System.out.println("Max " + max + ", Min " + min + ", Largest gap " + largestGap);
        }
    }
}