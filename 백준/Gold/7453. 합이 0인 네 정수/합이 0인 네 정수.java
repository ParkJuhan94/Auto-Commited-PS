//package BOJ.Section11.P7453;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section11/P7453/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // A + B 합 배열 생성
        int[] sumsAB = new int[N * N];
        int[] sumsCD = new int[N * N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumsAB[idx] = A[i] + B[j];
                sumsCD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(sumsAB);
        Arrays.sort(sumsCD);

        // 투 포인터 탐색
        long ans = 0;
        int left = 0;
        int right = sumsCD.length - 1;

        while (left < sumsAB.length && right >= 0) {
            int sumAB = sumsAB[left];
            int sumCD = sumsCD[right];
            int totalSum = sumAB + sumCD;

            if (totalSum == 0) {
                long countAB = 0;
                long countCD = 0;

                // 같은 값 세기 (A + B)
                while (left < sumsAB.length && sumsAB[left] == sumAB) {
                    left++;
                    countAB++;
                }

                // 같은 값 세기 (C + D)
                while (right >= 0 && sumsCD[right] == sumCD) {
                    right--;
                    countCD++;
                }

                ans += countAB * countCD;
            } else if (totalSum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(ans);
    }
}
