//package BOJ.Section11.P1459;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
     //   System.setIn(new FileInputStream("src/BOJ/Section11/P1459/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long W = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());

        long minXY = Math.min(x, y);
        long maxXY = Math.max(x, y);
        long diff = maxXY - minXY;

        long ans;

        if (S < W * 2) {
            // 대각선이 직선 두 번보다 빠를 때
            if (S < W) {
                // 대각선이 직선보다도 빠를 때 → 남은 거리도 전부 대각선으로 커버 가능
                ans = (maxXY % 2 == minXY % 2) ?
                    maxXY * S :
                    (maxXY - 1) * S + W;
            } else {
                // 대각선이 직선보다 빠르지는 않음 → 남은 거리는 직선으로
                ans = minXY * S + diff * W;
            }
        } else {
            // 그냥 직선만 걷는 게 이득
            ans = (x + y) * W;
        }

        System.out.println(ans);
    }

}
