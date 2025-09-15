import java.io.*;
import java.util.*;

public class Main {
    static void toggle(int[] a, int i) { a[i] ^= 1; }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N + 1]; // 1-indexed
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) a[i] = Integer.parseInt(st.nextToken());

        int S = Integer.parseInt(br.readLine().trim());
        for (int s = 0; s < S; s++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (gender == 1) { // male
                for (int i = k; i <= N; i += k) toggle(a, i);
            } else { // female
                int l = k - 1, r = k + 1;
                while (l >= 1 && r <= N && a[l] == a[r]) { l--; r++; }
                // expand overshot by one on both sides
                for (int i = l + 1; i <= r - 1; i++) toggle(a, i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(a[i]);
            if (i % 20 == 0 || i == N) sb.append('\n');
            else sb.append(' ');
        }
        System.out.print(sb.toString());
    }
}
