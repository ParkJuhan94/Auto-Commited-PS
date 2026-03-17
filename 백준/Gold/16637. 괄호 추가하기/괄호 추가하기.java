import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String expr = br.readLine().trim();

        int numCount = (N + 1) / 2;
        long[] nums = new long[numCount];
        char[] ops = new char[numCount - 1];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) nums[i / 2] = expr.charAt(i) - '0';
            else ops[i / 2] = expr.charAt(i);
        }

        int opCount = numCount - 1;
        long maxVal = Long.MIN_VALUE;

        for (int mask = 0; mask < (1 << opCount); mask++) {
            // 인접한 두 연산자 동시 선택 불가
            boolean valid = true;
            for (int i = 0; i < opCount - 1; i++) {
                if (((mask >> i) & 1) == 1 && ((mask >> (i + 1)) & 1) == 1) {
                    valid = false;
                    break;
                }
            }
            if (!valid) continue;

            List<Long> newNums = new ArrayList<>();
            List<Character> newOps = new ArrayList<>();

            int i = 0;
            while (i < numCount) {
                long val;
                int nextI;
                if (i < opCount && ((mask >> i) & 1) == 1) {
                    // 괄호: nums[i] ops[i] nums[i+1]
                    val = calc(nums[i], ops[i], nums[i + 1]);
                    nextI = i + 2;
                } else {
                    val = nums[i];
                    nextI = i + 1;
                }
                newNums.add(val);
                // 다음 그룹과 연결하는 연산자: ops[nextI - 1]
                if (nextI < numCount) newOps.add(ops[nextI - 1]);
                i = nextI;
            }

            // 왼쪽부터 순서대로 계산
            long result = newNums.get(0);
            for (int j = 0; j < newOps.size(); j++)
                result = calc(result, newOps.get(j), newNums.get(j + 1));

            maxVal = Math.max(maxVal, result);
        }

        System.out.println(maxVal);
    }

    static long calc(long a, char op, long b) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }
}