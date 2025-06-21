import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N + 1];       // 최소 연산 횟수 저장
        int[] prev = new int[N + 1];     // 이전 숫자 저장 (경로 추적용)

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 3으로 나누기
            if (cur % 3 == 0 && dp[cur / 3] > dp[cur] + 1) {
                dp[cur / 3] = dp[cur] + 1;
                prev[cur / 3] = cur;
                q.offer(cur / 3);
            }

            // 2로 나누기
            if (cur % 2 == 0 && dp[cur / 2] > dp[cur] + 1) {
                dp[cur / 2] = dp[cur] + 1;
                prev[cur / 2] = cur;
                q.offer(cur / 2);
            }

            // 1 빼기
            if (cur - 1 >= 1 && dp[cur - 1] > dp[cur] + 1) {
                dp[cur - 1] = dp[cur] + 1;
                prev[cur - 1] = cur;
                q.offer(cur - 1);
            }
        }

        // 출력 1: 최소 연산 횟수
        System.out.println(dp[1]);

        // 출력 2: 경로 추적
        List<Integer> path = new ArrayList<>();
        int cur = 1;
        while (cur != 0) {
            path.add(cur);
            cur = prev[cur];
        }

        Collections.reverse(path);
        for (int num : path) {
            System.out.print(num + " ");
        }
    }
}
