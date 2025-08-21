import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        PriorityQueue<Integer> pqAll = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < score.length; i++){
            pqAll.add(score[i]);
        }
                
        PriorityQueue<Integer> pqPart = new PriorityQueue<>();
        
        while(!pqAll.isEmpty()) {
            int cur = pqAll.poll();            
            pqPart.add(cur);
            
            // 박스 꽉 차면
            if(pqPart.size() == m) {
                answer += pqPart.poll() * m;
                pqPart = new PriorityQueue<>();    
            }
        }
        
        return answer;
    }
}