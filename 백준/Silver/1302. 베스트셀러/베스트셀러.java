//package BOJ.Section11.P1302;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
    //    System.setIn(new FileInputStream("src/BOJ/Section11/P1302/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> bookMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            bookMap.put(book, bookMap.getOrDefault(book, 0) + 1);
        }

        int max = 0;
        for(String key : bookMap.keySet()) {
            max = Math.max(max, bookMap.get(key));
        }

        PriorityQueue<String> answers = new PriorityQueue<>();
        for(String key : bookMap.keySet()) {
            if(bookMap.get(key) == max) {
                answers.add(key);
            }
        }

        System.out.println(answers.peek());
    }

}
