import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[N][];
        for (int i = 0; i < N; i++) A[i] = br.readLine().toCharArray();

        long ans = -1;

        // 모든 시작 위치
        for (int sr = 0; sr < N; sr++) {
            for (int sc = 0; sc < M; sc++) {

                // 모든 등차(step) 쌍
                for (int dr = -N; dr <= N; dr++) {
                    for (int dc = -M; dc <= M; dc++) {
                        if (dr == 0 && dc == 0) continue; // 같은 칸 반복 금지

                        int r = sr, c = sc;
                        long num = 0;

                        while (0 <= r && r < N && 0 <= c && c < M) {
                            num = num * 10 + (A[r][c] - '0');

                            // 끝자리 필터: 제곱수의 일의 자리 {0,1,4,5,6,9}
                            int last = (int)(num % 10);
                            if (last == 0 || last == 1 || last == 4 || last == 5 || last == 6 || last == 9) {
                                if (isPerfectSquare(num)) ans = Math.max(ans, num);
                            }

                            if (num < 0) break; // long 오버플로우 시 음수됨

                            r += dr;
                            c += dc;
                        }
                    }
                }
            }
        }

        // 길이 1(단일 칸) 케이스는 위 루프에 포함됨
        System.out.println(ans);
    }

    static boolean isPerfectSquare(long x) {
        if (x < 0) return false;
        long s = (long)Math.sqrt(x);
        return s * s == x || (s + 1) * (s + 1) == x; // 근사 오차 보정
    }
}
