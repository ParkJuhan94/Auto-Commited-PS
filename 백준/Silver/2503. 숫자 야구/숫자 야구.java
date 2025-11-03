import java.io.*;
import java.util.*;

public class Main {
    static class Query {
        String num;
        int strike, ball;
        
        Query(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Query> queries = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            queries.add(new Query(num, strike, ball));
        }
        
        int count = 0;
        
        // 123 ~ 987 모든 후보 시도
        for (int candidate = 123; candidate <= 987; candidate++) {
            String candStr = String.valueOf(candidate);
            
            // 0 포함하거나 중복 숫자 있으면 스킵
            if (!isValid(candStr)) continue;
            
            // 모든 질문에 대해 조건 만족하는지 체크
            boolean possible = true;
            for (Query q : queries) {
                int[] result = calcStrikeBall(candStr, q.num);
                if (result[0] != q.strike || result[1] != q.ball) {
                    possible = false;
                    break;
                }
            }
            
            if (possible) count++;
        }
        
        System.out.println(count);
    }
    
    // 유효성 검사: 0 없고, 세 자리 모두 다른지
    static boolean isValid(String num) {
        if (num.contains("0")) return false;
        if (num.charAt(0) == num.charAt(1)) return false;
        if (num.charAt(1) == num.charAt(2)) return false;
        if (num.charAt(0) == num.charAt(2)) return false;
        return true;
    }
    
    // 스트라이크와 볼 계산
    static int[] calcStrikeBall(String answer, String guess) {
        int strike = 0, ball = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (answer.charAt(i) == guess.charAt(j)) {
                    if (i == j) {
                        strike++; // 같은 위치
                    } else {
                        ball++;   // 다른 위치
                    }
                }
            }
        }
        
        return new int[]{strike, ball};
    }
}