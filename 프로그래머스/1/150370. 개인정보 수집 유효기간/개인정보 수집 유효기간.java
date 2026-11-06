import java.util.*;

class Solution {
    static Map<String, Integer> term = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {        
        // 규칙 세팅        
        for(String t : terms) {
            term.put(t.split(" ")[0], Integer.parseInt(t.split(" ")[1]) * 28);
        }
        
        List<Integer> answers = new ArrayList<>();
        
        // 파싱 -> 파기일 정하기 -> 판별 후 파기해야할 개인정보 번호 오름차순으로
        for(int i = 0; i < privacies.length; i++) {
            int todayNum = Integer.parseInt(today.split("\\.")[0]) * 12 * 28 + Integer.parseInt(today.split("\\.")[1]) * 28 + Integer.parseInt(today.split("\\.")[2]);
            if(todayNum >= cal(privacies[i])) {
                answers.add(i + 1);
            }
        }
        
        int[] answer = new int[answers.size()];
        for(int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
        }
        
        return answer;
    }
    
    private int cal(String privacy) {        
        int y = Integer.parseInt(privacy.split(" ")[0].split("\\.")[0]);
        int m = Integer.parseInt(privacy.split(" ")[0].split("\\.")[1]);
        int d = Integer.parseInt(privacy.split(" ")[0].split("\\.")[2]);
        String abc = privacy.split(" ")[1];        
        
        return y * 12 * 28 + m * 28 + d + term.get(abc);
    }
}