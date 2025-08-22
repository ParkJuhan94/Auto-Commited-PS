import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int maxWallet = Math.max(wallet[0], wallet[1]);
        int minWallet = Math.min(wallet[0], wallet[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(bill[0]);
        pq.add(bill[1]);
        
        while(true) {            
            // 종료 조건            
            int minBill = pq.poll();
            int maxBill = pq.poll();
            
            if(maxBill <= maxWallet && minBill <= minWallet) {
                break;
            }                        
            
            pq.add(maxBill/2);
            pq.add(minBill);
            
            answer++;
        }
        
        return answer;
    }
}