import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {

        int len = message.length();

        // 1. 스포 구간 마킹 (boolean 배열)
        boolean[] isSpoiler = new boolean[len];
        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                isSpoiler[i] = true;
            }
        }

        // 2. 단어 파싱 + 비스포 단어 Set 구성
        List<int[]> wordRanges = new ArrayList<>();  // [start, end] of each word
        List<String> wordList  = new ArrayList<>();

        int i = 0;
        while (i < len) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }
            // 단어 시작
            int start = i;
            while (i < len && message.charAt(i) != ' ') {
                i++;
            }
            int end = i - 1;
            wordRanges.add(new int[]{start, end});
            wordList.add(message.substring(start, end + 1));
        }

        // 3. 비스포 단어 Set 먼저 구성 (전체 순회 필요)
        Set<String> nonSpoilerWords = new HashSet<>();
        for (int w = 0; w < wordList.size(); w++) {
            int[] range = wordRanges.get(w);
            boolean wordIsSpoiler = false;
            for (int j = range[0]; j <= range[1]; j++) {
                if (isSpoiler[j]) {
                    wordIsSpoiler = true;
                    break;
                }
            }
            if (!wordIsSpoiler) {
                nonSpoilerWords.add(wordList.get(w));
            }
        }

        // 4. 왼쪽부터 중요 단어 판별
        Set<String> revealedSpoilerWords = new HashSet<>();
        int answer = 0;

        for (int w = 0; w < wordList.size(); w++) {
            int[] range = wordRanges.get(w);
            String word = wordList.get(w);

            // 스포 단어 여부 확인
            boolean wordIsSpoiler = false;
            for (int j = range[0]; j <= range[1]; j++) {
                if (isSpoiler[j]) {
                    wordIsSpoiler = true;
                    break;
                }
            }

            if (!wordIsSpoiler) continue; // 비스포 단어는 패스

            // 중요 단어 조건 3가지 체크
            if (!nonSpoilerWords.contains(word) && !revealedSpoilerWords.contains(word)) {
                answer++;
                revealedSpoilerWords.add(word);
            }
        }

        return answer;
    }
}