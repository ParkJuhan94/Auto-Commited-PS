import java.util.*;
import java.io.*;

public class Main {
    static int[] len = new int[50];  // len[k] = S(k)의 길이
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 길이 배열 미리 계산
        len[0] = 3;
        for (int i = 1; i < 50; i++) {
            len[i] = len[i-1] * 2 + (i + 3);
            if (len[i] > 1_000_000_000) {
                len[i] = 1_000_000_000;  // 오버플로우 방지
            }
        }
        
        System.out.println(find(N));
    }
    
    static char find(int n) {
        // Base case: S(0) = "moo"
        if (n <= 3) {
            return (n == 1) ? 'm' : 'o';
        }
        
        // n이 속하는 S(k) 찾기
        int k = 0;
        while (len[k] < n) {
            k++;
        }
        
        // 구간 나누기
        int prevLen = len[k-1];
        int midLen = k + 3;
        
        if (n <= prevLen) {
            // 앞쪽 S(k-1)
            return find(n);
        } else if (n <= prevLen + midLen) {
            // 가운데 "m" + "o"*(k+2)
            return (n == prevLen + 1) ? 'm' : 'o';
        } else {
            // 뒤쪽 S(k-1)
            return find(n - prevLen - midLen);
        }
    }
}