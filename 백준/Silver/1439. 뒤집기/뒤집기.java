//package BOJ.Section11.P1439;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section11/P1439/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int group0Count = 0;
        int group1Count = 0;
        String prev = Character.toString(str.charAt(0));
        if (prev.equals("0")) {
            group0Count++;
        } else {
            group1Count++;
        }

        for (int i = 1; i < str.length(); i++) {
            String cur = Character.toString(str.charAt(i));
            if (!cur.equals(prev)) {
                prev = cur;
                if (cur.equals("0")) {
                    group0Count++;
                } else {
                    group1Count++;
                }
            }
        }

        System.out.println(Math.min(group0Count, group1Count));
    }

}
