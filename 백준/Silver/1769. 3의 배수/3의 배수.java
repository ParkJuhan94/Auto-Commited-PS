import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine().trim();
        
        int count = 0;
        
        // 한 자리가 될 때까지 반복
        while (X.length() > 1) {
            long sum = 0;
            for (char c : X.toCharArray()) sum += c - '0';
            X = String.valueOf(sum);
            count++;
        }
        
        int digit = X.charAt(0) - '0';
        System.out.println(count);
        System.out.println((digit == 3 || digit == 6 || digit == 9) ? "YES" : "NO");
    }
}