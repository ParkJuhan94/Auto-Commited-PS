import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();

        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];

            // 왼쪽에 추가
            left.put(t, left.getOrDefault(t, 0) + 1);

            // 오른쪽에서 제거
            right.put(t, right.get(t) - 1);
            if (right.get(t) == 0) {
                right.remove(t);
            }

            // 종류 수가 같으면 공평하게 나눔
            if (left.size() == right.size()) {
                answer++;
            }
        }

        return answer;
    }
}
