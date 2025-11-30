import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static String[] cards;
    static boolean[] used;
    static HashSet<String> results = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        cards = new String[n];
        used = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }
        
        dfs(0, "");
        
        System.out.println(results.size());
    }
    
    static void dfs(int depth, String current) {
        // k개 선택 완료
        if (depth == k) {
            results.add(current);
            return;
        }
        
        // n개 카드 중에서 선택
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(depth + 1, current + cards[i]);
                used[i] = false;
            }
        }
    }
}