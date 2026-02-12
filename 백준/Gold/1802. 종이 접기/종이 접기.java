import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            output.append(isValid(s) ? "YES" : "NO").append('\n');
        }
        
        System.out.print(output);
    }
    
    static boolean isValid(String s) {
        // Base case: 길이 1은 항상 가능
        if (s.length() == 1) {
            return true;
        }
        
        int mid = s.length() / 2;
        String left = s.substring(0, mid);
        String right = s.substring(mid + 1);
        
        // 오른쪽이 왼쪽의 역순+반전인지 확인
        if (!right.equals(reverseAndFlip(left))) {
            return false;
        }
        
        // 왼쪽만 재귀 검증 (오른쪽은 왼쪽의 변형이므로 자동 검증됨)
        return isValid(left);
    }
    
    static String reverseAndFlip(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            sb.append(c == '0' ? '1' : '0');
        }
        return sb.toString();
    }
}