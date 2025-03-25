import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 집합 S에 포함된 문자열들을 HashSet에 저장
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        
        int count = 0;
        // M개의 검사 문자열에 대해 집합 S에 포함되어 있는지 확인
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (set.contains(query)) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
