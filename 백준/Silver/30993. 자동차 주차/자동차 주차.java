//package BOJ.Section11.P30993;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, A, B, C;

    public static void main(String[] args) throws IOException {
  //      System.setIn(new FileInputStream("src/BOJ/Section11/P30993/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long factorialN = 1;
        for(int i = 1; i <= N; i++ ) {
            factorialN *= i;
        }

        long factorialA = 1;
        for(int i = 1; i <= A; i++ ) {
            factorialA *= i;
        }

        long factorialB = 1;
        for(int i = 1; i <= B; i++ ) {
            factorialB *= i;
        }

        long factorialC = 1;
        for(int i = 1; i <= C; i++ ) {
            factorialC *= i;
        }

        System.out.println(factorialN / (factorialA * factorialB * factorialC));
    }

}
