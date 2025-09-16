import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        if (n == 0) { System.out.println(0); return; }

        int[] cnt = new int[31];
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine().trim());
            cnt[v]++;
        }

        int cut = (int)Math.round(n * 0.15);
        int remain = n;

        // drop low
        int need = cut, val = 1;
        while (need > 0 && val <= 30) {
            int d = Math.min(need, cnt[val]);
            cnt[val] -= d; remain -= d; need -= d;
            if (cnt[val] == 0) val++;
        }
        // drop high
        need = cut; val = 30;
        while (need > 0 && val >= 1) {
            int d = Math.min(need, cnt[val]);
            cnt[val] -= d; remain -= d; need -= d;
            if (cnt[val] == 0) val--;
        }

        long sum = 0;
        for (int i = 1; i <= 30; i++) sum += (long)i * cnt[i];
        int ans = (int)Math.round(sum / (double)remain);
        System.out.println(ans);
    }
}
