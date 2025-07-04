import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        // 큐에 [인덱스, 우선순위] 넣기
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        int order = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 맨 앞 프로세스 꺼냄
            boolean hasHigher = false;

            // 큐 안에 현재보다 높은 우선순위가 있는지 검사
            for (int[] process : queue) {
                if (process[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.add(current); // 우선순위 높은 게 있으니까 다시 넣기
            } else {
                order++; // 실행 완료
                if (current[0] == location) {
                    return order;
                }
            }
        }

        return -1; // 여긴 절대 안 옴
    }
}
