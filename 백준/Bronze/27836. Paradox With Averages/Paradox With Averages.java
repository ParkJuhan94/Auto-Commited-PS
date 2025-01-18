import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/BOJ/Section11/P27836/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] scienceStu = new int[a];
            int[] economicStu = new int[b];

            st = new StringTokenizer(br.readLine());
            double avgScienceStu = 0;
            for(int j = 0; j < a; j++) {
                scienceStu[j] = Integer.parseInt(st.nextToken());
                avgScienceStu += scienceStu[j];
            }
            avgScienceStu /= a;

            st = new StringTokenizer(br.readLine());
            double avgEconomicStu = 0;
            for(int j = 0; j < b; j++) {
                economicStu[j] = Integer.parseInt(st.nextToken());
                avgEconomicStu += economicStu[j];
            }
            avgEconomicStu /= b;

            Arrays.sort(scienceStu);
            Arrays.sort(economicStu);

            int ans = 0;
            for(int j = 0; j < a; j++) {
                if(scienceStu[j] < avgScienceStu &&
                        scienceStu[j] > avgEconomicStu
                ) {
                    ans++;
                }
            }

            System.out.println(ans);
        }
    }

}
