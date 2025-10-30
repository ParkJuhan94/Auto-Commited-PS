import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String A = st.nextToken();
        String B = st.nextToken();
        
        int lenA = A.length();
        int lenB = B.length();
        int minDiff = Integer.MAX_VALUE;
        
        // A를 B의 각 위치에 맞춰보기
        for (int start = 0; start <= lenB - lenA; start++) {
            int diff = 0;
            
            // start 위치부터 A 길이만큼 비교
            for (int i = 0; i < lenA; i++) {
                if (A.charAt(i) != B.charAt(start + i)) {
                    diff++;
                }
            }
            
            minDiff = Math.min(minDiff, diff);
        }
        
        System.out.println(minDiff);
    }
}