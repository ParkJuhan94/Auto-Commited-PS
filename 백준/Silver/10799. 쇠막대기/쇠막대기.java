//package BOJ.Section12.P10799;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section12/P10799/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();

        int open = 0;      // 현재 열려있는 막대 개수 (=스택 크기)
        long pieces = 0;   // 조각 수는 커질 수 있어 long

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                open++;
            } else { // ')'
                open--;
                if (i > 0 && s[i - 1] == '(') {
                    // 레이저: 바로 이전 '('와 이번 ')'가 한 쌍
                    pieces += open; // 레이저가 열린 막대 open개를 자름
                } else {
                    // 막대의 끝
                    pieces += 1;
                }
            }
        }
        System.out.println(pieces);
    }

}
