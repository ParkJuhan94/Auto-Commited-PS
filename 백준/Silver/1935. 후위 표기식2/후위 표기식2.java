import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String expr = br.readLine().trim();

        double[] val = new double[26];
        for (int i = 0; i < N; i++) val[i] = Double.parseDouble(br.readLine().trim());

        Deque<Double> st = new ArrayDeque<>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if ('A' <= c && c <= 'Z') {
                st.push(val[c - 'A']);
            } else {
                double b = st.pop();
                double a = st.pop();
                double r;
                switch (c) {
                    case '+': r = a + b; break;
                    case '-': r = a - b; break;
                    case '*': r = a * b; break;
                    case '/': r = a / b; break;
                    default: throw new IllegalArgumentException("invalid op: " + c);
                }
                st.push(r);
            }
        }
        System.out.printf(Locale.US, "%.2f%n", st.pop());
    }
}
