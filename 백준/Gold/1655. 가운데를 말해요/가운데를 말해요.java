//package BOJ.Section11.P1655;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
       // System.setIn(new FileInputStream("src/BOJ/Section11/P1655/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int mid = 0;    // 중간값
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxPQ.size() <= minPQ.size()) {
                if (minPQ.size() == 0) {
                    maxPQ.add(num);
                } else {
                    if (num < minPQ.peek()) {
                        maxPQ.add(minPQ.poll());
                        minPQ.add(num);
                    } else {
                        maxPQ.add(num);
                    }
                }
            } else {
                if (maxPQ.size() == 0) {
                    minPQ.add(num);
                } else {
                    if (num > maxPQ.peek()) {
                        minPQ.add(maxPQ.poll());
                        maxPQ.add(num);
                    } else {
                        minPQ.add(num);
                    }
                }
            }

            // 출력
            if (maxPQ.size() <= minPQ.size()) {
                System.out.println(minPQ.peek());
            } else {
                System.out.println(maxPQ.peek());
            }

        }
    }

}

