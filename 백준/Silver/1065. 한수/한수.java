//package BOJ.Section11.P1065;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section11/P1065/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N < 100) {
            System.out.println(N);
        } else { // 100 ~ 1000
            int ans = 99;

            for (int i = 1; i <= 9; i++) {
                for (int j = -4; j <= 4; j++) {
                    int tens = i + j;
                    int ones = i + 2 * j;
                    if (tens >= 0 && tens <= 9 && ones >= 0 && ones <= 9) {
                        int num = i * 100 + tens * 10 + ones;
                        if (num <= N)
                            ans++;
                    }
                }
            }

            System.out.println(ans);
        }
    }

}
