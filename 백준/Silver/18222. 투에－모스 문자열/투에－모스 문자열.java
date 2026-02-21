import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        System.out.println(find(k));
    }
    
    static int find(long k) {
        if (k == 1) return 0;  // Base case
        
        // k를 포함하는 구간의 절반 크기
        long halfSize = Long.highestOneBit(k - 1);
        
        // 뒷부분이므로 앞부분 값의 반전
        return 1 - find(k - halfSize);
    }
}