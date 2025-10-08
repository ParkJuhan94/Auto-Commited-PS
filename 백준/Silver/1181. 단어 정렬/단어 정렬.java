import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Set<String> words = new HashSet<>();
        
        // 중복 제거하며 입력받기
        for (int i = 0; i < n; i++) {
            words.add(br.readLine());
        }
        
        // List로 변환 후 정렬
        List<String> list = new ArrayList<>(words);
        list.sort((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();  // 길이 오름차순
            }
            return a.compareTo(b);  // 사전순
        });
        
        // 출력
        for (String word : list) {
            sb.append(word).append('\n');
        }
        
        System.out.print(sb);
    }
}