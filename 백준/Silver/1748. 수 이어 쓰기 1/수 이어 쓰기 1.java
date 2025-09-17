import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        long N = Long.parseLong(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());
        long ans = 0;
        long start = 1;
        int digits = 1;

        // 각 자릿수 구간 합산
        while (start * 10 <= N) {          // [start, start*10-1] 전부 포함
            long count = 9 * start;        // 해당 자릿수에 속한 개수
            ans += count * digits;
            start *= 10;
            digits++;
        }

        // 마지막 자릿수 구간 처리: [start, N]
        ans += (N - start + 1) * digits;

        System.out.println(ans);
    }
}
