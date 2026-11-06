import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> line = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) {
            line.put(i + 1, players[i]);
            rank.put(players[i], i + 1);
        }
        
        for(int i = 0; i < callings.length; i++) {
            String calling = callings[i];
            
            // 앞사람 찾고
            int curRank = rank.get(calling);
            String frontPlayer = line.get(curRank - 1);
            
            // 앞 뒤 등수 바꿔주고, rank 갱신                        
            line.put(curRank, frontPlayer);
            line.put(curRank - 1, calling);            
            rank.put(frontPlayer, curRank);
            rank.put(calling, curRank - 1);            
        }
        
        String[] answer = new String[players.length];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = line.get(i + 1);
        }
        
        return answer;
    }
}