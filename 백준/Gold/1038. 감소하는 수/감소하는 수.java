import java.io.*;
import java.util.*;

public class Main {
    static List<Long> decreasing = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 0~9 각 숫자로 시작하는 감소하는 수 생성
        for (int i = 0; i <= 9; i++) {
            generate(i, i);
        }
        
        // 정렬
        Collections.sort(decreasing);
        
        // N번째 출력 (0-indexed)
        if (N >= decreasing.size()) {
            System.out.println(-1);
        } else {
            System.out.println(decreasing.get(N));
        }
    }
    
    // num: 현재까지 만든 수, last: 마지막으로 추가한 숫자
    static void generate(long num, int last) {
        decreasing.add(num);
        
        // last보다 작은 숫자를 뒤에 추가
        for (int next = 0; next < last; next++) {
            generate(num * 10 + next, next);
        }
    }
}