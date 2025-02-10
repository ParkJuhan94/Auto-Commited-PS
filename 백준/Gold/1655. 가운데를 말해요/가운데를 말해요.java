//package BOJ.Section11.P1655;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
      //  System.setIn(new FileInputStream("src/BOJ/Section11/P1655/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 왼쪽 힙: 최대 힙 (중앙값 또는 그보다 작은 값들을 저장)
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 오른쪽 힙: 최소 힙 (중앙값보다 큰 값들을 저장)
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 왼쪽 힙이 비어있거나, num이 왼쪽 힙의 최대값 이하라면 왼쪽 힙에 삽입
            if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
                leftHeap.offer(num);
            } else {
                rightHeap.offer(num);
            }

            // 두 힙의 크기 균형 맞추기 (왼쪽 힙의 크기가 오른쪽 힙보다 2 이상 크면 오른쪽으로 이동,
            // 오른쪽 힙이 더 크다면 왼쪽으로 이동)
            if (leftHeap.size() > rightHeap.size() + 1) {
                rightHeap.offer(leftHeap.poll());
            } else if (rightHeap.size() > leftHeap.size()) {
                leftHeap.offer(rightHeap.poll());
            }

            // 현재 중앙값은 항상 leftHeap의 루트
            sb.append(leftHeap.peek()).append('\n');
        }

        System.out.print(sb);
    }
}
