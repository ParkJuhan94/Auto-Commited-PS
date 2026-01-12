import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  // 현재 랭킹 개수
        int newScore = Integer.parseInt(st.nextToken());  // 태수 점수
        int P = Integer.parseInt(st.nextToken());  // 랭킹 최대 개수
        
        // N=0 예외 처리
        if (N == 0) {
            System.out.println(1);
            return;
        }
        
        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        
        // 랭킹 꽉 차고 + 꼴찌보다 낮거나 같으면 진입 불가
        if (N == P && newScore <= scores[N - 1]) {
            System.out.println(-1);
            return;
        }
        
        // 등수 찾기
        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (newScore < scores[i]) {
                rank++;
            } else {
                break;  // 같거나 크면 멈춤 (비오름차순이므로)
            }
        }
        
        System.out.println(rank);
    }
}