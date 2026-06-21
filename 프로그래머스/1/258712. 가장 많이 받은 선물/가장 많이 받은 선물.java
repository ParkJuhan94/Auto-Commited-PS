import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        int n = friends.length;

        // 이름 → 인덱스 매핑
        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idx.put(friends[i], i);
        }

        // giftMap[i][j] : i가 j에게 준 선물 수
        int[][] giftMap = new int[n][n];
        // giftScore[i] : 선물 지수 (준 것 - 받은 것)
        int[] giftScore = new int[n];

        // 선물 기록 파싱
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giver    = idx.get(parts[0]);
            int receiver = idx.get(parts[1]);
            giftMap[giver][receiver]++;
            giftScore[giver]++;    // 준 사람 +1
            giftScore[receiver]--; // 받은 사람 -1
        }

        // 다음 달 받을 선물 수 계산
        int[] nextMonth = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int iToJ = giftMap[i][j];
                int jToI = giftMap[j][i];

                if (iToJ > jToI) {
                    // i가 j에게 더 많이 줬으면 → 다음달 i가 선물 받음
                    nextMonth[i]++;
                } else if (jToI > iToJ) {
                    // j가 i에게 더 많이 줬으면 → 다음달 j가 선물 받음
                    nextMonth[j]++;
                } else {
                    // 주고받은 수가 같거나 기록 없음 → 선물 지수 비교
                    if (giftScore[i] > giftScore[j]) {
                        nextMonth[i]++;
                    } else if (giftScore[j] > giftScore[i]) {
                        nextMonth[j]++;
                    }
                    // 지수도 같으면 아무것도 안 함
                }
            }
        }

        // 최댓값 반환
        int answer = 0;
        for (int count : nextMonth) {
            answer = Math.max(answer, count);
        }
        return answer;
    }
}