import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String ,Integer> map = new HashMap<>();
        // 참가자 카운팅
        for(int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        // 완주자 제거
        for(int i = 0 ; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
            if(map.get(completion[i]) == 0) {
                map.remove(completion[i]);
            }
        }
        
        for(int i = 0; i < participant.length; i++) {
            if(map.containsKey(participant[i])) {
                answer = participant[i];
            }
        }
        
        return answer;
    }
}