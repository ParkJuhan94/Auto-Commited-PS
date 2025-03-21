import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new ArrayList<>();
        int N = score.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++) {
            pq.add(score[i]);     
            if(pq.size() == k + 1) {
                pq.poll();
            }
            answer.add(pq.peek());
        }
    
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}