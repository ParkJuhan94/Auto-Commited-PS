//package BOJ.Section11.P10610;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/BOJ/Section11/P10610/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int sumDigit = 0;
        boolean includeZero = false;

        for(int i  =0 ; i < str.length(); i++) {
            sumDigit += str.charAt(i) - '0';
            if(str.charAt(i) == '0') {
                includeZero = true;
            }
        }

        if(sumDigit % 3 != 0 || !includeZero) {
            System.out.println(-1);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < str.length(); i++) {
            pq.add(str.charAt(i) - '0');
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            sb.append(pq.poll());
        }

        System.out.println(sb.toString());
    }

}
