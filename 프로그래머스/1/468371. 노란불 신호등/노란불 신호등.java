class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;

        // 각 신호등의 주기 계산
        int[] cycle = new int[n];
        for (int i = 0; i < n; i++) {
            cycle[i] = signals[i][0] + signals[i][1] + signals[i][2];
        }

        // 전체 LCM (이 안에 답이 없으면 -1)
        long totalLCM = cycle[0];
        for (int i = 1; i < n; i++) {
            totalLCM = lcm(totalLCM, cycle[i]);
        }

        // t=1부터 LCM까지 탐색
        for (long t = 1; t <= totalLCM; t++) {
            if (allYellow(t, signals, cycle, n)) {
                return (int) t;
            }
        }

        return -1;
    }

    // 시각 t에 모든 신호등이 노란불인지 확인
    private boolean allYellow(long t, int[][] signals, int[] cycle, int n) {
        for (int i = 0; i < n; i++) {
            // 0-indexed 위치 (1초 시작이므로 t-1)
            long pos = (t - 1) % cycle[i];
            int green  = signals[i][0];
            int yellow = signals[i][1];
            // 노란불 구간: [green, green+yellow)
            if (pos < green || pos >= green + yellow) {
                return false;
            }
        }
        return true;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}