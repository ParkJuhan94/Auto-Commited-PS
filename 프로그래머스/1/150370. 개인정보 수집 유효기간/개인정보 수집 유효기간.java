import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> term = new HashMap<>();
        for (String t : terms) {
            String[] p = t.split(" ");
            term.put(p[0], Integer.parseInt(p[1]) * 28);
        }

        int todayNum = toDays(today);
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] p = privacies[i].split(" ");
            int expire = toDays(p[0]) + term.get(p[1]);
            if (todayNum >= expire) answers.add(i + 1);
        }
        return answers.stream().mapToInt(Integer::intValue).toArray();
    }

    // "yyyy.MM.dd" -> 일수 (모든 달 28일)
    private int toDays(String date) {
        String[] d = date.split("\\.");
        return Integer.parseInt(d[0]) * 12 * 28
             + Integer.parseInt(d[1]) * 28
             + Integer.parseInt(d[2]);
    }
}