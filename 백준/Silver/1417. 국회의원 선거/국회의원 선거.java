import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());  // 다솜이 득표수
        
        // Edge Case: 후보가 다솜이 혼자인 경우
        if (N == 1) {
            System.out.println(0);
            return;
        }
        
        // 최대 힙 (다른 후보들의 득표수)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 1; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        
        int count = 0;  // 매수한 사람 수
        
        // 다솜이가 최다 득표가 될 때까지 반복
        while (!pq.isEmpty() && pq.peek() >= dasom) {
            int maxVote = pq.poll();  // 가장 표 많은 후보
            
            maxVote--;    // 1표 빼앗기
            dasom++;      // 다솜이 1표 증가
            count++;      // 매수 카운트
            
            pq.offer(maxVote);  // 다시 힙에 넣기
        }
        
        System.out.println(count);
    }
}