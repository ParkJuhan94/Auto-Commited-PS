//package BOJ.Section11.P1676;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
 //       System.setIn(new FileInputStream("src/BOJ/Section11/P1676/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(i % 5 == 0) {
                int n = i;

                while(n % 5 == 0) {
                    n /= 5;
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

}
