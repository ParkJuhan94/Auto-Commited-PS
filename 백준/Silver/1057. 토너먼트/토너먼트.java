import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        
        int round = 1;
        
        while (true) {
            int size = q.size();
            Queue<Integer> nextRound = new LinkedList<>();
            
            for (int i = 0; i < size; i += 2) {
                int first = q.poll();
                
                if (i == size - 1) { // 홀수, 자동 진출
                    nextRound.add(first);
                } else {
                    int second = q.poll();
                    
                    // 대결 체크
                    if ((first == a && second == b) || (first == b && second == a)) {
                        System.out.println(round);
                        return;
                    }
                    
                    // 승자 결정 (a, b는 항상 이김)
                    if (first == a || first == b) {
                        nextRound.add(first);
                    } else if (second == a || second == b) {
                        nextRound.add(second);
                    } else {
                        nextRound.add(first); // 둘 다 아니면 임의
                    }
                }
            }
            
            q = nextRound;
            round++;
        }
    }
}
