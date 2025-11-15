import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1; // 현재 깊이의 곱셈값
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
                
            } else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
                
            } else if (ch == ')') {
                // 스택이 비었거나 짝 안 맞으면 invalid
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                
                // 직전이 '('면 값 추가 (완성된 괄호)
                if (s.charAt(i - 1) == '(') {
                    result += temp;
                }
                
                stack.pop();
                temp /= 2; // 깊이 복구
                
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                
                if (s.charAt(i - 1) == '[') {
                    result += temp;
                }
                
                stack.pop();
                temp /= 3;
                
            } else {
                // 예상치 못한 문자
                result = 0;
                break;
            }
        }
        
        // 스택이 비어있지 않으면 invalid
        if (!stack.isEmpty()) {
            result = 0;
        }
        
        System.out.println(result);
    }
}