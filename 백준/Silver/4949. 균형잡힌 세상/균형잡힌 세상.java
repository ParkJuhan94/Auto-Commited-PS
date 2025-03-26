//package BOJ.Section11.P4949;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
    //    System.setIn(new FileInputStream("src/BOJ/Section11/P4949/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;


        while (!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean isPossible = true;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '(') {
                    stack.push('(');
                } else if (input.charAt(i) == '[') {
                    stack.push('[');
                } else if (input.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                    char c = stack.pop();
                    if (c != '(') {
                        isPossible = false;
                        break;
                    }
                } else if (input.charAt(i) == ']') {
                    if (stack.isEmpty()) {
                        isPossible = false;
                        break;
                    }
                    char c = stack.pop();
                    if (c != '[') {
                        isPossible = false;
                        break;
                    }
                }
            }

            // 괄호 스택에 남아있는지 확인
            if (!stack.isEmpty()) {
                isPossible = false;
            }

            if (isPossible) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

}
