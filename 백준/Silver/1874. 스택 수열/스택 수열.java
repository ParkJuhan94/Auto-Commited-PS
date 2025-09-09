//package BOJ.Section12.P1874;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
   //     System.setIn(new FileInputStream("src/BOJ/Section12/P1874/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        int[] numbers = new int[N];    // 4, 3, 6, 8, 7, 5, 2, 1
        int numbersIdx = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            // push
            stack.push(i);
            sb.append("+").append("\n");

            if (numbers[numbersIdx] == i) {
                // pop
                while (true && !stack.isEmpty()) {
                    Integer cur = stack.peek();

                    if (cur == numbers[numbersIdx]) {
                        stack.pop();
                        sb.append("-").append("\n");
                        numbersIdx++;
                    } else {
                        break;
                    }
                }
            }
        }

        // 안되면 NO
        if (stack.isEmpty()) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }

}
