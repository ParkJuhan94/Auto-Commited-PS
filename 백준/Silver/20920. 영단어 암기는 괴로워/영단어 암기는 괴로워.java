import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 1. 빈도수 카운팅 (길이 M 이상만)
        HashMap<String, Integer> wordCount = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            
            if (word.length() >= M) {  // M 이상만 저장
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        // 2. 정렬을 위해 List로 변환
        List<String> words = new ArrayList<>(wordCount.keySet());
        
        // 3. 커스텀 정렬
        words.sort((w1, w2) -> {
            int count1 = wordCount.get(w1);
            int count2 = wordCount.get(w2);
            
            // 1순위: 빈도수 내림차순
            if (count1 != count2) {
                return count2 - count1;  // 큰 값이 앞으로
            }
            
            // 2순위: 길이 내림차순
            if (w1.length() != w2.length()) {
                return w2.length() - w1.length();
            }
            
            // 3순위: 사전순 오름차순
            return w1.compareTo(w2);
        });
        
        // 4. 출력
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append('\n');
        }
        System.out.print(sb);
    }
}