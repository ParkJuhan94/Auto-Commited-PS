class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int total   = toSec(video_len);
        int cur     = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd   = toSec(op_end);

        // 오프닝 스킵: 명령 수행 후 + 최초 시작 위치도 체크
        cur = skipOpening(cur, opStart, opEnd);

        for (String cmd : commands) {
            if (cmd.equals("prev")) {
                cur = Math.max(0, cur - 10);
            } else {
                cur = Math.min(total, cur + 10);
            }
            cur = skipOpening(cur, opStart, opEnd);
        }

        return toTime(cur);
    }

    // 오프닝 구간이면 op_end로 점프
    private int skipOpening(int cur, int opStart, int opEnd) {
        if (cur >= opStart && cur <= opEnd) {
            return opEnd;
        }
        return cur;
    }

    // "mm:ss" → 초
    private int toSec(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 초 → "mm:ss"
    private String toTime(int sec) {
        return String.format("%02d:%02d", sec / 60, sec % 60);
    }
}